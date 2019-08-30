package a1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		// Create HashMap for data storage
		// Maps the name of a product to a mapping from customer names to the number of that product the customer purchased
		Map<String, Map<String, Integer>> productRecord = new HashMap<>();
		
		// Create an array to track the order products should be listed in
		int productTypeCount = scan.nextInt();
		String[] productNames = new String[productTypeCount];

		// Create map entries for each type of product;
		for (int i = 0; i < productTypeCount; i++) {
			String name = scan.next();
			productRecord.put(name, new HashMap<>());
			productNames[i] = name;
			scan.next();
		}

		// Loop through customers
		int totalCustomerCount = scan.nextInt();
		for (int i = 0; i < totalCustomerCount; i++) {
			// Get customer name
			String customerName = scan.next() + " " + scan.next();

			// Get the customer's purchases
			int purchaseCount = scan.nextInt();
			for (int j = 0; j < purchaseCount; j++) {
				int quantityBought = scan.nextInt();
				String productName = scan.next();

				// Update the product record
				Integer priorAmount = productRecord.get(productName).putIfAbsent(customerName, quantityBought);
				if (priorAmount != null) {
					productRecord.get(productName).put(customerName, priorAmount + quantityBought);
				}
			}
		}

		// Print results
		for (String productName : productNames) {
			int customerCount = productRecord.get(productName).size();
			int purchaseCount = productRecord.get(productName).values().stream().mapToInt(Integer::intValue).sum();
			System.out.printf("%s customers bought %s%s%n", customerCount == 0 ? "No" : customerCount, purchaseCount == 0 ? "" : purchaseCount + " ", productName);
		}
	}
}
