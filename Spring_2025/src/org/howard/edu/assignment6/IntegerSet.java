package org.howard.edu.assignment6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntegerSet {
    private List<Integer> set = new ArrayList<>();

    public void clear() {
        set.clear();
    }

    public int length() {
        return set.size();
    }

    public boolean equals(IntegerSet b) {
        List<Integer> sortedA = new ArrayList<>(this.set);
        List<Integer> sortedB = new ArrayList<>(b.set);
        Collections.sort(sortedA);
        Collections.sort(sortedB);
        return sortedA.equals(sortedB);
    }

    public boolean contains(int value) {
        return set.contains(value);
    }

    public int largest() throws IntegerSetException {
        if (set.isEmpty()) {
            throw new IntegerSetException("Set is empty.");
        }
        return Collections.max(set);
    }

    public int smallest() throws IntegerSetException {
        if (set.isEmpty()) {
            throw new IntegerSetException("Set is empty.");
        }
        return Collections.min(set);
    }

    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    public void union(IntegerSet intSetb) {
        for (int item : intSetb.set) {
            this.add(item);
        }
    }

    public void intersect(IntegerSet intSetb) {
        set.retainAll(intSetb.set);
    }

    public void diff(IntegerSet intSetb) {
        set.removeAll(intSetb.set);
    }

    // ✅ FIXED: Complement now means A - B
    public void complement(IntegerSet intSetb) {
        this.set.removeAll(intSetb.set);
    }

    public boolean isEmpty() {
        return set.isEmpty();
    }

    public String toString() {
        return set.toString();
    }
}
