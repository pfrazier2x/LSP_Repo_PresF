package org.howard.edu.lsp.midterm.question3;

/**
 * Preston Frazier
 * @param args
 */

public class VotingMachineTest {
    public static void main(String[] args) {
        VotingMachine vm = new VotingMachine();

        // Adding candidates
        vm.addCandidate("Alice");
        vm.addCandidate("Bob");
        vm.addCandidate("Charlie");

        // Casting votes
        vm.castVote("Alice");
        vm.castVote("Alice");
        vm.castVote("Bob");
        vm.castVote("Charlie");
        vm.castVote("Charlie");
        vm.castVote("Charlie");

        // Attempt to vote for a non-existent candidate
        boolean success = vm.castVote("Eve");
        System.out.println("Vote for Eve successful? " + success); // Expected: false

        // Display results
        vm.displayResults();

        // Print the winner
        System.out.println("Winner: " + vm.getWinner());
    }
}
