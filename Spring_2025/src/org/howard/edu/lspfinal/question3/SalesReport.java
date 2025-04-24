package org.howard.edu.lspfinal.question3;

/**
 * Sales report with custom implementation for each step.
 */
public class SalesReport extends ReportGenerator {
    @Override
    protected void loadData() {
        System.out.println("Loading sales data...");
    }

    @Override
    protected void formatData() {
        System.out.println("Formatting sales data...");
    }

    @Override
    protected void printReport() {
        System.out.println("Printing sales report.");
    }
}
