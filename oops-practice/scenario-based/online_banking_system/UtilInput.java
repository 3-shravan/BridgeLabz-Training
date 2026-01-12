package scenario_based.online_banking_system;

import java.util.Scanner;

public class UtilInput {

	Scanner read;

	public UtilInput(Scanner scanner) {
		this.read = scanner;
	}

	int readInt(String prompt) {
		System.out.print(prompt);
		String input = read.nextLine();

		try {
			Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.out.println("Invalid input. Please enter a valid integer.");
			readInt(prompt);
		}
		return Integer.parseInt(input);

	}

	long readLong(String prompt) {
		System.out.print(prompt);
		String input = read.nextLine();
		try {
			return Long.parseLong(input);
		} catch (NumberFormatException e) {
			System.out.println("Invalid input. Please enter a valid long integer.");
			return readLong(prompt);
		}

	double readDouble(String prompt) {
		System.out.print(prompt);
		String input = read.nextLine();
		try {
			return Double.parseDouble(input);
		} catch (NumberFormatException e) {
			System.out.println("Invalid input. Please enter a valid number.");
			return readDouble(prompt);
		}
	}

	String readString(String prompt) {
		System.out.print(prompt);
		String input = read.nextLine();
		if (input.trim().isEmpty()) {
			System.out.println("Input cannot be empty. Please enter a valid string.");
			return readString(prompt);
		}
		return input;
	}

	boolean realBoolean(String prompt) {
		System.out.print(prompt);
		String input = read.nextLine().trim().toLowerCase();
		if (input.equals("yes")) {
			return true;
		} else if (input.equals("no")) {
			return false;
		} else {
			System.out.println("Invalid input. Please enter 'yes' or 'no'.");
			return realBoolean(prompt);
		}

	}

}
