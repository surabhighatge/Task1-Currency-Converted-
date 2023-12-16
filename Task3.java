// Currency Converted //

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task3 {

    private static final Map<String, Double> exchangeRates = new HashMap<>();

    static {
        // Initialize exchange rates (example rates)
        exchangeRates.put("USD", 1.0); // US Dollar
        exchangeRates.put("EUR", 0.85); // Euro
        exchangeRates.put("GBP", 0.75); // British Pound
        exchangeRates.put("INR", 74.50); // Indian Rupee
        exchangeRates.put("RUB", 73.20); // Russian Ruble
        // Add more currencies as needed
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Currency Converter!");

        // Input amount
        System.out.print("Enter the amount: ");
        double amount = scanner.nextDouble();

        // Input source currency
        System.out.print("Enter the source currency code (e.g., USD): ");
        String fromCurrency = scanner.next().toUpperCase();

        // Input target currency
        System.out.print("Enter the target currency code (e.g., EUR): ");
        String toCurrency = scanner.next().toUpperCase();

        // Perform currency conversion
        double convertedAmount = convertCurrency(amount, fromCurrency, toCurrency);

        // Display result
        System.out.println(amount + " " + fromCurrency + " is equal to " + convertedAmount + " " + toCurrency);

        scanner.close();
    }

    private static double convertCurrency(double amount, String fromCurrency, String toCurrency) {
        String upperFromCurrency = fromCurrency.toUpperCase();
        String upperToCurrency = toCurrency.toUpperCase();

        if (!exchangeRates.containsKey(upperFromCurrency) || !exchangeRates.containsKey(upperToCurrency)) {
            System.out.println("Invalid currency code");
            return 0.0;
        }

        double rateFrom = exchangeRates.get(upperFromCurrency);
        double rateTo = exchangeRates.get(upperToCurrency);

        // Conversion formula: convertedAmount = amount * (rateTo / rateFrom)
        return amount * (rateTo / rateFrom);
    }

}
