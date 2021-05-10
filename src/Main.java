public class Main {
    public static void main(String[] args) {
        ElectionData electionData = new ElectionData();
        VotingMachine votingMachine = new VotingMachine(electionData);
        votingMachine.screen();
    }
}
