package a1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Create a map relating the prices of items to their names
		Map<String, Double> itemsSold = new HashMap<>();
		int itemTypeCount = scan.nextInt();
		for (int i = 0; i < itemTypeCount; i++) {
			itemsSold.put(scan.next(), scan.nextDouble());
		}

		// Create variables to track relevant data
		String bigFirst = "", bigLast = "", smallFirst = "", smallLast = "";
		double bigSpent = 0, smallSpent = 0, overallTotalSpent = 0;
		int numberOfCustomers = scan.nextInt();

		// Loop through all customers
		for (int i = 0; i < numberOfCustomers; i++) {
			String first = scan.next(), last = scan.next();
			int itemsBought = scan.nextInt();
			double totalSpent = 0;

			// Loop through each item purchased and add it to the customer's total
			for (int j = 0; j < itemsBought; j++)
				totalSpent += scan.nextInt() * itemsSold.get(scan.next());

			// Update data tracker variables
			overallTotalSpent += totalSpent;
			if (bigFirst.equals("") || totalSpent > bigSpent) {
				bigFirst = first;
				bigLast = last;
				bigSpent = totalSpent;
			}
			if (smallFirst.equals("") || totalSpent < smallSpent) {
				smallFirst = first;
				smallLast = last;
				smallSpent = totalSpent;
			}
		}

		// Print results
		System.out.printf("Biggest: %s %s (%.2f)%n", bigFirst, bigLast, bigSpent);
		System.out.printf("Smallest: %s %s (%.2f)%n", smallFirst, smallLast, smallSpent);
		System.out.printf("Average: %.2f%n", overallTotalSpent / numberOfCustomers);
	}
}
