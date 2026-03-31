package scenario_based.ecommerce_order_management;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("E-commerce Order Management System");

		OrderService service = new OrderServiceImpl();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			printMenu();
			int choice = readInt(scanner, "Enter your choice: ");

			try {
				switch (choice) {
					case 1: { // add product
						int id = readInt(scanner, "Enter product id: ");
						String name = readNonEmpty(scanner, "Enter product name: ");
						double price = readDouble(scanner, "Enter price: ");
						service.addProduct(new Product(id, name, price));
						break;
					}
					case 2: { // list products
						service.listProducts();
						break;
					}
					case 3: { // place order
						int productId = readInt(scanner, "Enter product id to order: ");
						int customerId = readInt(scanner, "Enter customer id: ");
						String customerName = readNonEmpty(scanner, "Enter customer name: ");
						Payment payment = choosePayment(scanner);
						service.placeOrder(productId, new Customer(customerId, customerName), payment);
						break;
					}
					case 4: { // cancel order
						int orderId = readInt(scanner, "Enter order id to cancel: ");
						service.cancelOrder(orderId);
						break;
					}
					case 5: { // list orders
						service.listOrders();
						break;
					}
					case 0:
						System.out.println("Exiting...");
						scanner.close();
						return;
					default:
						System.out.println("Invalid choice. Please try again.");
				}
			} catch (PaymentFailedException e) {
				System.out.println("Payment Error: " + e.getMessage());
			} catch (RuntimeException e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	}

	private static void printMenu() {
		System.out.println("\n1. Add product");
		System.out.println("2. List products");
		System.out.println("3. Place order");
		System.out.println("4. Cancel order");
		System.out.println("5. List orders");
		System.out.println("0. Exit");
	}

	private static int readInt(Scanner sc, String prompt) {
		while (true) {
			System.out.print(prompt);
			String s = sc.nextLine().trim();
			try {
				return Integer.parseInt(s);
			} catch (NumberFormatException e) {
				System.out.println("Enter a valid integer.");
			}
		}
	}

	private static double readDouble(Scanner sc, String prompt) {
		while (true) {
			System.out.print(prompt);
			String s = sc.nextLine().trim();
			try {
				return Double.parseDouble(s);
			} catch (NumberFormatException e) {
				System.out.println("Enter a valid number.");
			}
		}
	}

	private static String readNonEmpty(Scanner sc, String prompt) {
		while (true) {
			System.out.print(prompt);
			String s = sc.nextLine().trim();
			if (!s.isEmpty())
				return s;
			System.out.println("Input cannot be empty.");
		}
	}

	private static Payment choosePayment(Scanner sc) {
		System.out.println("Choose payment method: 1) UPI  2) Card  3) Wallet");
		while (true) {
			System.out.print("Enter option: ");
			String s = sc.nextLine().trim();
			switch (s) {
				case "1":
					return new UpiPayment();
				case "2":
					return new CardPayment();
				case "3":
					return new WalletPayment();
				default:
					System.out.println("Invalid option. Try again.");
			}
		}
	}
}
