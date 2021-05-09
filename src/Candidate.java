public class Candidate {
    private String name;
    private int numOfFirstChoice;
    private int numOfSecondChoice;
    private int numOfThirdChoice;

    Candidate(String name) {
        this.name = name;
        this.numOfFirstChoice = 0;
        this.numOfSecondChoice = 0;
        this.numOfThirdChoice = 0;
    }

    int addNumOfFirstChoice() {
        return this.numOfFirstChoice += 1;
    }

    int addNumOfSecondChoice() {
        return this.numOfFirstChoice += 1;
    }

    int addNumOfThirdChoice() {
        return this.numOfFirstChoice += 1;
    }

    int getNumOfFirstChoice() {
        return this.numOfFirstChoice;
    }

    int getNumOfSecondChoice() {
        return this.numOfSecondChoice;
    }

    int getNumOfThirdChoice() {
        return this.numOfThirdChoice;
    }

    String getName() {
        return this.name;
    }

    int totalPoints() {
        return (this.numOfFirstChoice * 3) + (this.numOfSecondChoice * 2) + (this.numOfThirdChoice);
    }

}
