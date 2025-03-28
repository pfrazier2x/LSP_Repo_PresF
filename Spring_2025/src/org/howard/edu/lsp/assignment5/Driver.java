package org.howard.edu.lsp.assignment5;

/**
 * Preston Frazier
 * @param args
 */

public class Driver {
    public static void main(String[] args) {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        // Add elements
        System.out.println("== Add Elements ==");
        set1.add(1);
        set1.add(2);
        set1.add(3);
        System.out.println("Set1: " + set1.toString());

        set2.add(3);
        set2.add(4);
        set2.add(5);
        System.out.println("Set2: " + set2.toString());

        // Contains check
        System.out.println("\n== Contains ==");
        System.out.println("Set1 contains 2? " + set1.contains(2));
        System.out.println("Set1 contains 10? " + set1.contains(10));

        // Smallest and Largest
        System.out.println("\n== Smallest and Largest ==");
        System.out.println("Smallest in Set1: " + set1.smallest());
        System.out.println("Largest in Set2: " + set2.largest());

        // Equals
        System.out.println("\n== Equals ==");
        IntegerSet set3 = new IntegerSet();
        set3.add(3);
        set3.add(2);
        set3.add(1);
        System.out.println("Set1 equals Set3? " + set1.equals(set3));

        // Remove
        System.out.println("\n== Remove ==");
        System.out.println("Before removing 2 from Set1: " + set1.toString());
        set1.remove(2);
        System.out.println("After removing 2 from Set1: " + set1.toString());

        // Union
        System.out.println("\n== Union ==");
        System.out.println("Set1: " + set1.toString());
        System.out.println("Set2: " + set2.toString());
        set1.union(set2);
        System.out.println("After union (Set1 ∪ Set2): " + set1.toString());

        // Intersect
        System.out.println("\n== Intersect ==");
        set1.clear();
        set2.clear();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set2.add(2);
        set2.add(3);
        set2.add(4);
        System.out.println("Set1: " + set1.toString());
        System.out.println("Set2: " + set2.toString());
        set1.intersect(set2);
        System.out.println("After intersection: " + set1.toString());

        // Difference
        System.out.println("\n== Difference ==");
        set1.clear();
        set2.clear();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set2.add(2);
        set2.add(4);
        System.out.println("Set1: " + set1.toString());
        System.out.println("Set2: " + set2.toString());
        set1.diff(set2);
        System.out.println("After Set1 - Set2: " + set1.toString());

        // Complement
        System.out.println("\n== Complement ==");
        set1.clear();
        set2.clear();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set2.add(2);
        set2.add(3);
        System.out.println("Set1: " + set1.toString());
        System.out.println("Set2: " + set2.toString());
        set1.complement(set2);
        System.out.println("After complement (Set1 elements not in Set2): " + set1.toString());

        // isEmpty and clear
        System.out.println("\n== isEmpty & Clear ==");
        System.out.println("Set1: " + set1.toString());
        System.out.println("Set1 is empty? " + set1.isEmpty());
        set1.clear();
        System.out.println("After clear, Set1 is empty? " + set1.isEmpty());
    }
}
