public class UnknownCandidateException extends Exception {
    private String unknownCandidate;
    //    The constructor for each method should take a String for
//    If the user specifies multiple names not on the ballot, report the first one
//     make the name field private and write a public getter to get the name value.
    UnknownCandidateException(String name) {
        this.unknownCandidate = name;
    }

    public String getName() {
        return this.unknownCandidate;
    }
}
