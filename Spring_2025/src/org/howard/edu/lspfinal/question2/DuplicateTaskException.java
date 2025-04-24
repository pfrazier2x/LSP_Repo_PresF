package org.howard.edu.lspfinal.question2;

/**
 * Custom exception for when a task already exists.
 */
public class DuplicateTaskException extends Exception {
    public DuplicateTaskException(String message) {
        super(message);
    }
}
