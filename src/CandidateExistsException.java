/**
 *
 */
public class CandidateExistsException extends Exception {
    private String alreadyExistingCandidate;

    public CandidateExistsException(String name) {
        this.alreadyExistingCandidate = name;
    }
}
