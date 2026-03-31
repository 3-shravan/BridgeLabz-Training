package scenario_based.library_management_system;

import java.time.LocalDate;

public class Transaction {
  private final String id;
  private final String bookId;
  private final String memberId;
  private final LocalDate issueDate;
  private final LocalDate dueDate;
  private LocalDate returnDate;
  private double fineAmount;

  public Transaction(String id, String bookId, String memberId, LocalDate issueDate, LocalDate dueDate) {
    this.id = id;
    this.bookId = bookId;
    this.memberId = memberId;
    this.issueDate = issueDate;
    this.dueDate = dueDate;
  }

  public String getId() {
    return id;
  }

  public String getBookId() {
    return bookId;
  }

  public String getMemberId() {
    return memberId;
  }

  public LocalDate getIssueDate() {
    return issueDate;
  }

  public LocalDate getDueDate() {
    return dueDate;
  }

  public LocalDate getReturnDate() {
    return returnDate;
  }

  public boolean isReturned() {
    return returnDate != null;
  }

  public void markReturned(LocalDate returnDate, double fineAmount) {
    this.returnDate = returnDate;
    this.fineAmount = fineAmount;
  }

  public double getFineAmount() {
    return fineAmount;
  }

  @Override
  public String toString() {
    return "Transaction{id='" + id + "', bookId='" + bookId + "', memberId='" + memberId + "', issueDate=" + issueDate
        + ", dueDate=" + dueDate + ", returnDate=" + returnDate + ", fine=" + fineAmount + "}";
  }
}
