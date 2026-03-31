package online_voting_system;

public class Voter {

    private String voterId;
    private String name;
    private boolean hasVoted;

    public Voter(String voterId, String name) {
        this.voterId = voterId;
        this.name = name;
        this.hasVoted = false;
    }

    public String getVoterId() {
        return voterId;
    }

    public boolean hasVoted() {
        return hasVoted;
    }

    public void markVoted() {
        this.hasVoted = true;
    }
}
