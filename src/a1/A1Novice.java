package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Get # of customers
		int customerCount = scan.nextInt();

		// Loop through all customers
		for (int i = 0; i < customerCount; i++) {
			// Print cutomer name
			System.out.printf("%c. %s: ", scan.next().charAt(0), scan.next());

			// Find the total spent by the customer
			int itemTypeCount = scan.nextInt();
			double totalSpent = 0;
			for (int j = 0; j < itemTypeCount; j++) {
				int itemQuantity = scan.nextInt();
				scan.next();
				double itemPrice = scan.nextDouble();
				totalSpent += itemQuantity * itemPrice;
			}

			// Print the total amount spent by the customer
			System.out.printf("%.2f%n", totalSpent);
		}
	}
}
