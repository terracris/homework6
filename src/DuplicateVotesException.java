/**
 * An Exception thrown when a candidate's name appears more than once for a single vote.
 */
public class DuplicateVotesException extends Exception {
    private String name;

    public DuplicateVotesException(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
