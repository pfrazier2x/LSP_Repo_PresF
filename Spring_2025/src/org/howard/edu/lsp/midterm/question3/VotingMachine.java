package org.howard.edu.lsp.midterm.question3;

import java.util.HashMap;
import java.util.Map;

/**
 * Preston Frazier
 * @param args
 */

public class VotingMachine {
    private Map<String, Integer> votes;

    // Constructor
    public VotingMachine() {
        this.votes = new HashMap<>();
    }

    // Method to add a candidate
    public void addCandidate(String candidateName) {
        if (!votes.containsKey(candidateName)) {
            votes.put(candidateName, 0);
        }
    }

    // Method to cast a vote
    public boolean castVote(String candidateName) {
        if (votes.containsKey(candidateName)) {
            votes.put(candidateName, votes.get(candidateName) + 1);
            return true;
        } else {
            return false; // Candidate does not exist
        }
    }

    // Method to display election results
    public void displayResults() {
        System.out.println("Election Results:");
        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            System.out.println(entry.getKey() + " received " + entry.getValue() + " votes.");
        }
    }

    // Method to determine the winner
    public String getWinner() {
        String winner = null;
        int maxVotes = -1;

        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winner = entry.getKey();
            }
        }

        return winner + " WINS with " + maxVotes + " votes!!";
    }
}
