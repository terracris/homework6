public class Main {
    public static void main(String[] args) {
        ElectionData electionData = new ElectionData();
        try {
            electionData.addCandidate("chris");
        } catch (CandidateExistsException e) {
            System.out.println("oopsies");
        }

        VotingMachine votingMachine = new VotingMachine(electionData);
        votingMachine.screen();
    }
}
