public class ParcelTracker {
  // Stage
  static class StageNode {
    String stage;
    StageNode next;

    StageNode(String stage) {
      this.stage = stage;
      this.next = null;
    }
  }

  // Parcel Tracker

  static class Tracker {

    private StageNode head;

    public void addStage(String stage) {
      StageNode newNode = new StageNode(stage);
      if (head == null) {
        head = newNode;
      } else {
        StageNode current = head;
        while (current.next != null) {
          current = current.next;
        }
        current.next = newNode;
      }
      System.out.println("Stage added: " + stage);
    }

    // checkpoint
    public void addCheckPoint(String afterStage, String newStage) {
      StageNode current = head;
      while (current != null && !current.stage.equals(afterStage)) {
        current = current.next;
      }
      if (current == null) {
        System.out.println("Stage not found");
        return;
      }
      StageNode newNode = new StageNode(newStage);
      newNode.next = current.next;
      current.next = newNode;

      System.out.println("Checkpoint added " + newStage + " after " + afterStage);
    }

    public void trackParcel() {
      if (head == null) {
        System.out.println("Parcel lost (no tracking data)");
        return;
      }
      StageNode current = head;
      System.out.print("\n Parcel Journey: ");
      while (current != null) {
        System.out.print(current.stage + " - > ");
        current = current.next;
      }
      System.out.println("END");
    }
  }

  // Main
  public static void main(String[] args) {

    Tracker parcel = new Tracker();

    parcel.addStage("Packed");
    parcel.addStage("Shipped");
    parcel.addStage("In Transit");
    parcel.addStage("Delivered");

    parcel.trackParcel();

    parcel.addCheckPoint("Shipped", "Customs Check");
    parcel.trackParcel();
  }
}
