/**
 * A class to represent a candidate in an election.
 */
public class Candidate {
    private String name;
    private int numOfFirstChoice;
    private int numOfSecondChoice;
    private int numOfThirdChoice;

//    when created a candidate does not have any votes.
    public Candidate(String name) {
        this.name = name;
        this.numOfFirstChoice = 0;
        this.numOfSecondChoice = 0;
        this.numOfThirdChoice = 0;
    }

    //the reason as to why I have made all fields private and a getter and setter for
    //each field is so that the user cannot alter the values.
    // the only thing any one can do is access or mutate the votes by one.

    public int addNumOfFirstChoice() {
        this.numOfFirstChoice = this.numOfFirstChoice + 1;
        return this.numOfFirstChoice;
    }

    public int addNumOfSecondChoice() {
        this.numOfSecondChoice = this.numOfSecondChoice + 1;
        return this.numOfSecondChoice;
    }

    public int addNumOfThirdChoice() {
        this.numOfThirdChoice = numOfThirdChoice + 1;
        return this.numOfThirdChoice;
    }

    public int getNumOfFirstChoice() {
        return this.numOfFirstChoice;
    }

//    these last two getters might not be necessary. they are never called in code.
//    maybe I should leave it since "the voters" might want to change how
//    candidates are chosen (elected)

    public int getNumOfSecondChoice() {
        return this.numOfSecondChoice;
    }

    public int getNumOfThirdChoice() {
        return this.numOfThirdChoice;
    }

    public String getName() {
        return this.name;
    }

    public int totalPoints() {
        return (this.numOfFirstChoice * 3) + (this.numOfSecondChoice * 2) + (this.numOfThirdChoice);
    }

}
