/**
 * An Exception thrown when a candidate already exists.
 */
public class CandidateExistsException extends Exception {
    private String alreadyExistingCandidate;

    public CandidateExistsException(String name) {
        this.alreadyExistingCandidate = name;
    }
}
