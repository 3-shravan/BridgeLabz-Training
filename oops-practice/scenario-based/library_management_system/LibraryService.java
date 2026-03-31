package scenario_based.library_management_system;

import java.time.LocalDate;
import java.util.List;

public interface LibraryService {
  // Book CRUD
  void addBook(Book book);

  void updateBook(String bookId, String title, String author, int totalCopies);

  void deleteBook(String bookId);

  List<Book> listBooks();

  Book getBookById(String bookId);

  // Member CRUD
  void registerMember(Member member);

  void updateMember(String memberId, String name, String phone, String email);

  void deleteMember(String memberId);

  List<Member> listMembers();

  Member getMemberById(String memberId);

  // Issue/Return
  Transaction issueBook(String memberId, String bookId, LocalDate issueDate) throws BookNotAvailableException;

  Transaction returnBook(String memberId, String bookId, LocalDate returnDate);

  List<Transaction> listTransactions();
}
