package it.project.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ItemList {

    private static final String DATA_FILE_PATH = "/list/item.txt";
    private static final String DELIMITER_REGEX = ",\\s*";
    private static final int EXPECTED_PARTS = 3;

    private ItemList() {
        throw new UnsupportedOperationException("This is a utility class and should not be instantiated.");
    }

    public static List<Item> getItemList() {
        List<Item> items = new ArrayList<>();

        try (InputStream is = ItemList.class.getResourceAsStream(DATA_FILE_PATH)) {

            if (is == null) {
                System.err.println("FATAL: Resource not found: " + DATA_FILE_PATH +
                        ". Ensure it is in the classpath (e.g., src/main/resources).");
                return Collections.emptyList(); // Return an unmodifiable empty list
            }

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
                String line;

                while ((line = reader.readLine()) != null) {
                    String trimmedLine = line.trim();

                    if (trimmedLine.isEmpty() || trimmedLine.startsWith("#")) {
                        continue;
                    }

                    String[] parts = trimmedLine.split(DELIMITER_REGEX);

                    if (parts.length == EXPECTED_PARTS) {
                        try {
                            String name = parts[0].trim();
                            String price = parts[1].trim();
                            String imagePath = parts[2].trim();

                            items.add(new Item(name, price, imagePath));
                        } catch (Exception e) {
                            System.err.println("Skipping item due to construction error: " + trimmedLine + ". Error: " + e.getMessage());
                        }
                    } else {
                        System.err.println("Skipping malformed item line (Expected " + EXPECTED_PARTS + " parts): " + trimmedLine);
                    }
                }
            } catch (IOException e) {
                System.err.println("FATAL: An I/O error occurred while reading the file: " + DATA_FILE_PATH);
                e.printStackTrace();
                return Collections.emptyList();
            }

        } catch (Exception e) {
            System.err.println("FATAL: An unexpected error occurred while accessing the file resource.");
            e.printStackTrace();
            return Collections.emptyList();
        }

        return items;
    }
}