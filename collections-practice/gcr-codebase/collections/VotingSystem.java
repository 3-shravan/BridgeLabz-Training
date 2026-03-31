import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

class VotingManager {
  // Candidate -> Votes
  private Map<String, Integer> voteMap = new HashMap<>();
  private Map<String, Integer> insertionOrderMap = new LinkedHashMap<>();
  private Map<String, Integer> sortedResultMap = new TreeMap<>();

  public void castVote(String candidate) {
    voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
    insertionOrderMap.put(candidate, insertionOrderMap.getOrDefault(candidate, 0) + 1);
  }

  public void displayVotesInOrder() {
    System.out.println("Votes in Insertion Order:");
    insertionOrderMap.forEach((k, v) -> System.out.println(k + " -> " + v));
  }

  public void displaySortedResults() {
    sortedResultMap.clear();
    sortedResultMap.putAll(voteMap);

    System.out.println("\nVotes in Sorted Order:");
    sortedResultMap.forEach((k, v) -> System.out.println(k + " -> " + v));
  }

  public void displayWinner() {
    String winner = null;
    int maxVotes = Integer.MIN_VALUE;

    for (Map.Entry<String, Integer> entry : voteMap.entrySet()) {
      if (entry.getValue() > maxVotes) {
        maxVotes = entry.getValue();
        winner = entry.getKey();
      }
    }

    System.out.println("\n Winner: " + winner + " with " + maxVotes + " votes");
  }

}

public class VotingSystem {

  public static void main(String[] args) {
    VotingManager votingManager = new VotingManager();

    votingManager.castVote("Alice");
    votingManager.castVote("Bob");
    votingManager.castVote("Alice");
    votingManager.castVote("Charlie");
    votingManager.castVote("Bob");
    votingManager.castVote("Alice");

    votingManager.displayVotesInOrder();
    votingManager.displaySortedResults();
    votingManager.displayWinner();
  }

}
