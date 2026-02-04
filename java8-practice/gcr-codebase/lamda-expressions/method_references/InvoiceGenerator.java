package method_references;

import java.util.List;

class Invoice {
    private String transactionId;

    Invoice(String transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public String toString() {
        return "Invoice for transaction: " + transactionId;
    }
}

public class InvoiceGenerator {

    public static void main(String[] args) {

        List<String> transactionIds = List.of(
                "TXN1001",
                "TXN1002",
                "TXN1003");
        List<Invoice> invoices = transactionIds.stream().map(Invoice::new).toList();
        invoices.forEach(System.out::println);

    }
}