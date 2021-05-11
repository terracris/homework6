/**
 * An Exception thrown when a candidate does not exist on the ballot.
 */
public class UnknownCandidateException extends Exception {
    private String unknownCandidate;

    public UnknownCandidateException(String name) {
        this.unknownCandidate = name;
    }

    public String getName() {
        return this.unknownCandidate;
    }
}
