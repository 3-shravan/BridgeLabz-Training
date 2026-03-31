package marker_interfaces;

import java.io.Serializable;

class BackupRecord implements Serializable {
  private static final long serialVersionUID = 1L;
  private String data;

  BackupRecord(String data) {
    this.data = data;
  }

  @Override
  public String toString() {
    return "BackupRecord: " + data;
  }
}

public class BackupSerialization {

  public static void main(String[] args) {

    BackupRecord record = new BackupRecord("Daily backup");
    System.out.println(record);
    System.out.println("Serializable: " + (record instanceof Serializable));
  }
}
