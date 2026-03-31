package scenario_based.library_management_system;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryServiceImpl implements LibraryService {
  private final Map<String, Book> booksById = new HashMap<>();
  private final Map<String, Member> membersById = new HashMap<>();
  private final List<Transaction> transactions = new ArrayList<>();
  private int transactionCounter = 1000;

  @Override
  public void addBook(Book book) {
    if (book == null) {
      throw new IllegalArgumentException("Book cannot be null");
    }
    if (booksById.containsKey(book.getId())) {
      throw new IllegalArgumentException("Book already exists with id: " + book.getId());
    }
    booksById.put(book.getId(), book);
  }

  @Override
  public void updateBook(String bookId, String title, String author, int totalCopies) {
    Book book = requireBook(bookId);
    book.setTitle(title);
    book.setAuthor(author);
    book.setTotalCopies(totalCopies);
  }

  @Override
  public void deleteBook(String bookId) {
    Book book = requireBook(bookId);
    boolean hasActiveIssue = transactions.stream().anyMatch(t -> !t.isReturned() && t.getBookId().equals(book.getId()));
    if (hasActiveIssue) {
      throw new IllegalStateException("Cannot delete book. There is an active issued transaction.");
    }
    booksById.remove(book.getId());
  }

  @Override
  public List<Book> listBooks() {
    return new ArrayList<>(booksById.values());
  }

  @Override
  public Book getBookById(String bookId) {
    return booksById.get(bookId);
  }

  @Override
  public void registerMember(Member member) {
    if (member == null) {
      throw new IllegalArgumentException("Member cannot be null");
    }
    if (membersById.containsKey(member.getId())) {
      throw new IllegalArgumentException("Member already exists with id: " + member.getId());
    }
    membersById.put(member.getId(), member);
  }

  @Override
  public void updateMember(String memberId, String name, String phone, String email) {
    Member member = requireMember(memberId);
    member.setName(name);
    member.setPhone(phone);
    member.setEmail(email);
  }

  @Override
  public void deleteMember(String memberId) {
    Member member = requireMember(memberId);
    boolean hasActiveIssue = transactions.stream()
        .anyMatch(t -> !t.isReturned() && t.getMemberId().equals(member.getId()));
    if (hasActiveIssue) {
      throw new IllegalStateException("Cannot delete member. There is an active issued transaction.");
    }
    membersById.remove(member.getId());
  }

  @Override
  public List<Member> listMembers() {
    return new ArrayList<>(membersById.values());
  }

  @Override
  public Member getMemberById(String memberId) {
    return membersById.get(memberId);
  }

  @Override
  public Transaction issueBook(String memberId, String bookId, LocalDate issueDate) throws BookNotAvailableException {
    Member member = requireMember(memberId);
    Book book = requireBook(bookId);

    boolean alreadyIssuedSameBook = transactions.stream()
        .anyMatch(t -> !t.isReturned() && t.getMemberId().equals(memberId) && t.getBookId().equals(bookId));
    if (alreadyIssuedSameBook) {
      throw new IllegalStateException("This member already has this book issued.");
    }

    book.issueOneCopy();
    LocalDate dueDate = issueDate.plusDays(member.getLoanDays());
    Transaction txn = new Transaction(nextTransactionId(), bookId, memberId, issueDate, dueDate);
    transactions.add(txn);
    return txn;
  }

  @Override
  public Transaction returnBook(String memberId, String bookId, LocalDate returnDate) {
    requireMember(memberId);
    Book book = requireBook(bookId);
    Transaction txn = findActiveTransaction(memberId, bookId);
    if (txn == null) {
      throw new IllegalArgumentException(
          "No active transaction found for memberId=" + memberId + " and bookId=" + bookId);
    }

    Member member = requireMember(memberId);
    long daysLate = ChronoUnit.DAYS.between(txn.getDueDate(), returnDate);
    if (daysLate < 0) {
      daysLate = 0;
    }
    double fine = member.getFineCalculator().calculateFine(daysLate);
    txn.markReturned(returnDate, fine);
    book.returnOneCopy();
    return txn;
  }

  @Override
  public List<Transaction> listTransactions() {
    return new ArrayList<>(transactions);
  }

  private String nextTransactionId() {
    transactionCounter++;
    return "T" + transactionCounter;
  }

  private Book requireBook(String bookId) {
    Book book = booksById.get(bookId);
    if (book == null) {
      throw new IllegalArgumentException("Book not found: " + bookId);
    }
    return book;
  }

  private Member requireMember(String memberId) {
    Member member = membersById.get(memberId);
    if (member == null) {
      throw new IllegalArgumentException("Member not found: " + memberId);
    }
    return member;
  }

  private Transaction findActiveTransaction(String memberId, String bookId) {
    for (Transaction t : transactions) {
      if (!t.isReturned() && t.getMemberId().equals(memberId) && t.getBookId().equals(bookId)) {
        return t;
      }
    }
    return null;
  }
}
