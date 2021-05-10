public class UnknownCandidateException extends Exception {
    private String unknownCandidate;

    public UnknownCandidateException(String name) {
        this.unknownCandidate = name;
    }

    public String getName() {
        return this.unknownCandidate;
    }
}
