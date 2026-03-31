package online_voting_system;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ElectionService service = new VotingService();

        while (true) {
            System.out.println("""
                    1. Register Voter
                    2. Add Candidate
                    3. Cast Vote
                    4. Declare Results
                    5. Exit
                    """);

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            try {
                switch (choice) {

                case 1:
                    System.out.print("Enter Voter ID: ");
                    service.registerVoter(sc.next(), sc.next());
                    break;

                case 2:
                    System.out.print("Enter Candidate ID: ");
                    service.addCandidate(sc.next(), sc.next());
                    break;

                case 3:
                    System.out.print("Enter Voter ID: ");
                    String voterId = sc.next();
                    System.out.print("Enter Candidate ID: ");
                    String candidateId = sc.next();
                    service.castVote(voterId, candidateId);
                    break;

                case 4:
                    service.declareResults();
                    break;

                case 5:
                    sc.close();
                    System.out.println("Voting closed.");
                    return;

                default:
                    System.out.println("Invalid choice");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
