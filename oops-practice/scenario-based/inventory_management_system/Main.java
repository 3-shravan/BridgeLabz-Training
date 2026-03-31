package scenario_based.inventory_management_system;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Inventory inventory = new Inventory(new LowStockAlertService());

		while (true) {
			showMenu();
			int choice = sc.nextInt();

			try {
				switch (choice) {
				case 1:
					System.out.print("Enter Product ID: ");
					String id = sc.next();

					System.out.print("Enter Product Name: ");
					String name = sc.next();

					System.out.print("Enter Initial Stock: ");
					int stock = sc.nextInt();

					inventory.addProduct(id, name, stock);
					break;

				case 2:
					System.out.print("Enter Product ID: ");
					String pid = sc.next();

					System.out.print("Enter quantity to reduce: ");
					int qty = sc.nextInt();

					inventory.updateStock(pid, qty);
					break;

				case 3:
					inventory.viewAllProducts();
					break;

				case 4:
					System.out.println("Exiting Inventory System...");
					sc.close();
					return;

				default:
					System.out.println("Invalid choice");
				}
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
			}
		}
	}

	private static void showMenu() {
		System.out.println("""
				\n1. Add Product
				2. Update Stock
				3. View Inventory
				4. Exit
				Enter your choice:
				""");
	}
}
