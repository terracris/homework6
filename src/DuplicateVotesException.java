public class DuplicateVotesException extends Exception {
    private String name;
//    takes in a string

    DuplicateVotesException(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
