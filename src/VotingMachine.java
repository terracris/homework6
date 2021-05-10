import java.util.Scanner;

/**
 * The user interface. Handles the Input/Output.
 */
public class VotingMachine {
    ElectionData electionData;
    Scanner keyboard = new Scanner(System.in);

    public VotingMachine(ElectionData electionData) {
        this.electionData = electionData;
    }


    public void printBallot() {
        System.out.println("The candidates are ");

        for (String candidate : electionData.getCandidates()) {
            System.out.println(candidate);
        }
    }

    public void screen() {
        this.printBallot();
        System.out.println("Who is your first choice??");
        String candidate1 = keyboard.next();
        System.out.println("You voted for " + candidate1);

        System.out.println("Who is your second choice??");
        String candidate2 = keyboard.next();
        System.out.println("You voted for " + candidate2);


        System.out.println("Who is your third choice??");
        String candidate3 = keyboard.next();
        System.out.println("You voted for " + candidate1);


        try {
            this.electionData.processVote(candidate1, candidate2, candidate3);
        } catch (UnknownCandidateException unknownCandidate) {
            System.out.println("Candidate" + unknownCandidate.getName() +
                    " not found. Would you like to add them to the ballot? Y/N");
            String response = keyboard.next();
            if (response.toLowerCase().equals("y")) {
                this.addWriteIn(unknownCandidate.getName());
                this.screen();
            }

        } catch (DuplicateVotesException e) {
            System.out.println("You cannot vote for the same candidate twice.");
            screen();
        }
    }

    private void addWriteIn(String name) {
        try {
            this.electionData.addCandidate(name);
        } catch (CandidateExistsException e) {
            e.printStackTrace();
        }


    }
}
