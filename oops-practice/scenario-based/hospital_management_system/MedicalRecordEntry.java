import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MedicalRecordEntry {

  private final LocalDateTime createdAt;
  private final String note;

  public MedicalRecordEntry(String note) {
    if (note == null || note.isBlank()) {
      throw new IllegalArgumentException("note cannot be empty");
    }
    this.createdAt = LocalDateTime.now();
    this.note = note;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public String getNote() {
    return note;
  }

  @Override
  public String toString() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    return createdAt.format(formatter) + " - " + note;
  }
}
