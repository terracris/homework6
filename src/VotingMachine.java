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
    System.out.println("Who do you want to vote for?");
    String candidate1 = keyboard.next();
    String candidate2 = keyboard.next();
    String candidate3 = keyboard.next();


    try {
    electionData.processVote(candidate1, candidate2, candidate3);
    } catch (UnknownCandidateException e) {
        System.out.println("my name jeff");
        screen();
    } catch (DuplicateVotesException e) {
            System.out.println("oopsies");
            screen();
        }
  }



}
