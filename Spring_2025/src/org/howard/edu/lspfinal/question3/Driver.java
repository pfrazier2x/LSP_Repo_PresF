package org.howard.edu.lspfinal.question3;

/**
 * Demonstrates Template Method pattern with different report types.
 */
public class Driver {
    public static void main(String[] args) {
        ReportGenerator sales = new SalesReport();
        ReportGenerator inventory = new InventoryReport();

        sales.generateReport();
        System.out.println();
        inventory.generateReport();
    }
}
