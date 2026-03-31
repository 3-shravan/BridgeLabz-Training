public class LegacyAPI {

  @Deprecated
  public void oldFeature() {
    System.out.println("This is the old feature (Deprecated)");
  }

  public void newFeature() {
    System.out.println("This is the new feature (Recommended)");
  }

  public static void main(String[] args) {
    LegacyAPI api = new LegacyAPI();
    api.oldFeature();
    api.newFeature();
  }
}
