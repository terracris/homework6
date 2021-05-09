public class CandidateExistsException extends Exception {
    String alreadyExistingCandidate;
    CandidateExistsException(String name) {
        this.alreadyExistingCandidate = name;
    }
}
