package default_methods;

interface ReportExporter {

  void export(String data);

  default void exportToJSON(String data) {
    System.out.println("Exporting data in JSON format:");
    System.out.println("{ \"report\": \"" + data + "\" }");
  }
}

class CSVExporter implements ReportExporter {

  @Override
  public void export(String data) {
    System.out.println("Exporting data to CSV: " + data);
  }
}

class PDFExporter implements ReportExporter {

  @Override
  public void export(String data) {
    System.out.println("Exporting data to PDF: " + data);
  }
}

public class ReportingApp {

  public static void main(String[] args) {

    ReportExporter csv = new CSVExporter();
    ReportExporter pdf = new PDFExporter();

    csv.export("Sales Report");
    csv.exportToJSON("Sales Report");

    pdf.export("User Report");
    pdf.exportToJSON("User Report");

  }
}
