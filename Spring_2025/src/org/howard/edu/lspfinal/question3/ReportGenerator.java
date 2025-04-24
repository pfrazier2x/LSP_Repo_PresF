package org.howard.edu.lspfinal.question3;

/**
 * Abstract class using Template Method pattern to define report workflow.
 */
public abstract class ReportGenerator {

    // Template method (do not override)
    public final void generateReport() {
        loadData();
        formatData();
        printReport();
    }

    protected abstract void loadData();
    protected abstract void formatData();
    protected abstract void printReport();
}
