package org.howard.edu.lsp.assignment2;

import java.io.*;
import java.util.*;

/**
 * Preston Frazier
 * @param args
 */

public class ETLPipeline {
    public static void main(String[] args) {
        String inputFilePath = "data/products.csv";
        String outputFilePath = "data/transformed_products.csv";
        
        List<String[]> transformedData = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
            String line;
            boolean isHeader = true;
            
            while ((line = br.readLine()) != null) {
                if (isHeader) {
                    transformedData.add(new String[]{"ProductID", "Name", "Price", "Category", "PriceRange"});
                    isHeader = false;
                    continue;
                }

                // Skip empty lines
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] values = line.split(",");

                // Ensure the line has exactly 4 columns (ProductID, Name, Price, Category)
                if (values.length != 4) {
                    System.err.println("Skipping invalid line: " + line);
                    continue;
                }

                try {
                    String productId = values[0];
                    String name = values[1].toUpperCase();
                    double price = Double.parseDouble(values[2]);
                    String category = values[3];

                    // Apply 10% discount for Electronics
                    if (category.equals("Electronics")) {
                        price *= 0.9;
                        price = Math.round(price * 100.0) / 100.0; // Round to 2 decimal places
                    }

                    // Adjust category for expensive items
                    if (price > 500) {
                        category = "Premium Electronics";
                    }

                    // Assign Price Range
                    String priceRange = getPriceRange(price);
                    transformedData.add(new String[]{productId, name, String.format("%.2f", price), category, priceRange});
                } catch (Exception e) {
                    System.err.println("Error processing line: " + line);
                }
            }

            writeToFile(outputFilePath, transformedData);
            System.out.println("ETL Process Completed. Transformed data saved to " + outputFilePath);
        } catch (FileNotFoundException e) {
            System.err.println("Error: Input file not found in 'data/' directory.");
        } catch (IOException e) {
            System.err.println("Error reading the input file: " + e.getMessage());
        }
    }

    private static String getPriceRange(double price) {
        if (price <= 10) return "Low";
        if (price <= 100) return "Medium";
        if (price <= 500) return "High";
        return "Premium";
    }

    private static void writeToFile(String filePath, List<String[]> data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String[] row : data) {
                bw.write(String.join(",", row));
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to output file: " + e.getMessage());
        }
    }
}
