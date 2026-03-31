package online_voting_system;

public class Candidate {

    private String candidateId;
    private String name;
    private int votes;

    public Candidate(String candidateId, String name) {
        this.candidateId = candidateId;
        this.name = name;
        this.votes = 0;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public String getName() {
        return name;
    }

    public void addVote() {
        votes++;
    }

    public int getVotes() {
        return votes;
    }
}
