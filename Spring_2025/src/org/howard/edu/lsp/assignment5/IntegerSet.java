package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * IntegerSet is a custom class that simulates a mathematical set of integers.
 * It includes functionality such as union, intersection, difference, and more.
 * Duplicates are not allowed.
 * 
 * @author Preston Frazier
 */
public class IntegerSet {
	private List<Integer> set = new ArrayList<Integer>();

	/**
	 * Default constructor. Initializes an empty set.
	 */
	public IntegerSet() {
	}

	/**
	 * Constructor that takes an initialized set.
	 * @param set ArrayList of integers
	 */
	public IntegerSet(ArrayList<Integer> set) {
		this.set = set;
	}

	/**
	 * Clears all elements from the set.
	 */
	public void clear() {
		set.clear();
	}

	/**
	 * Returns the number of elements in the set.
	 * @return size of set
	 */
	public int length() {
		return set.size();
	}

	/**
	 * Checks if this set is equal to another set.
	 * @param o the object to compare
	 * @return true if both sets contain the same elements
	 */
	public boolean equals(Object o) {
		if (!(o instanceof IntegerSet)) return false;
		IntegerSet other = (IntegerSet) o;
		List<Integer> copy1 = new ArrayList<>(this.set);
		List<Integer> copy2 = new ArrayList<>(other.set);
		Collections.sort(copy1);
		Collections.sort(copy2);
		return copy1.equals(copy2);
	}

	/**
	 * Returns true if the set contains the given value.
	 * @param value the value to check
	 * @return true if found, else false
	 */
	public boolean contains(int value) {
		return set.contains(value);
	}

	/**
	 * Returns the largest value in the set.
	 * @return the maximum value in the set
	 * @throws RuntimeException if the set is empty
	 */
	public int largest() {
		if (set.isEmpty()) {
			throw new RuntimeException("Set is empty.");
		}
		return Collections.max(set);
	}

	/**
	 * Returns the smallest value in the set.
	 * @return the minimum value in the set
	 * @throws RuntimeException if the set is empty
	 */
	public int smallest() {
		if (set.isEmpty()) {
			throw new RuntimeException("Set is empty.");
		}
		return Collections.min(set);
	}

	/**
	 * Adds a value to the set if not already present.
	 * @param item value to add
	 */
	public void add(int item) {
		if (!set.contains(item)) {
			set.add(item);
		}
	}

	/**
	 * Removes a value from the set if present.
	 * @param item value to remove
	 */
	public void remove(int item) {
		set.remove(Integer.valueOf(item));
	}

	/**
	 * Performs the union with another IntegerSet.
	 * @param intSetb the other set
	 */
	public void union(IntegerSet intSetb) {
		for (int item : intSetb.set) {
			if (!this.set.contains(item)) {
				this.set.add(item);
			}
		}
	}

	/**
	 * Keeps only elements also in the other set.
	 * @param intSetb the other set
	 */
	public void intersect(IntegerSet intSetb) {
		set.retainAll(intSetb.set);
	}

	/**
	 * Removes elements in the other set from this set.
	 * @param intSetb the other set
	 */
	public void diff(IntegerSet intSetb) {
		set.removeAll(intSetb.set);
	}

	/**
	 * Replaces the current set with elements not in the other set.
	 * @param intSetb the other set
	 */
	public void complement(IntegerSet intSetb) {
		List<Integer> result = new ArrayList<>();
		for (int i : set) {
			if (!intSetb.set.contains(i)) {
				result.add(i);
			}
		}
		set = result;
	}

	/**
	 * Checks if the set is empty.
	 * @return true if empty, false otherwise
	 */
	public boolean isEmpty() {
		return set.isEmpty();
	}

	/**
	 * Returns a string representation of the set.
	 * @return set as string
	 */
	public String toString() {
		return set.toString();
	}
}
