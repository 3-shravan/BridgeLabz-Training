package online_voting_system;

public interface ElectionService {

    void registerVoter(String voterId, String name);

    void addCandidate(String candidateId, String name);

    void castVote(String voterId, String candidateId)
            throws DuplicateVoteException;

    void declareResults();
}
