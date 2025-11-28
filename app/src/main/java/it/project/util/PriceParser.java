package it.project.util;

public class PriceParser {

    public static double parsePrice(String price) {
        try {
            String cleanPrice = price.replaceAll("[^\\d.]", "");
            return Double.parseDouble(cleanPrice);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
}
