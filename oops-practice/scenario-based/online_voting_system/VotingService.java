package online_voting_system;

import java.util.*;

/*
 Acts as backend service
*/
public class VotingService implements ElectionService {

    private Map<String, Voter> voters = new HashMap<>();
    private Map<String, Candidate> candidates = new HashMap<>();
    private List<Vote> votes = new ArrayList<>();

    @Override
    public void registerVoter(String voterId, String name) {
        voters.put(voterId, new Voter(voterId, name));
        System.out.println("Voter registered.");
    }

    @Override
    public void addCandidate(String candidateId, String name) {
        candidates.put(candidateId, new Candidate(candidateId, name));
        System.out.println("Candidate added.");
    }

    @Override
    public void castVote(String voterId, String candidateId) throws DuplicateVoteException {

        Voter voter = voters.get(voterId);

        if (voter.hasVoted()) {
            throw new DuplicateVoteException("You have already voted!");
        }

        Candidate candidate = candidates.get(candidateId);

        candidate.addVote();
        voter.markVoted();
        votes.add(new Vote(voterId, candidateId));

        System.out.println("Vote cast successfully.");
    }

    @Override
    public void declareResults() {
        System.out.println("\n--- Election Results ---");
        for (Candidate c : candidates.values()) {
            System.out.println(c.getName() + " : " + c.getVotes() + " votes");
        }
    }
}
