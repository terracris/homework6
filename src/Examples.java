import static org.junit.Assert.*;
import org.junit.Test;

public class Examples {


    @Test
    public void testWinnerByPoints() {
        ElectionData electionData = new ElectionData();
        try {
            electionData.addCandidate("James");
            electionData.addCandidate("Kleo");
            electionData.addCandidate("Chris");
            electionData.addCandidate("Seth");
            electionData.addCandidate("Alex");
            electionData.addCandidate("Deah");
            electionData.addCandidate("Husky");


        } catch(CandidateExistsException e) {
            System.out.println("oops1");

        }
        try {
            electionData.processVote("Chris", "Alex", "Husky");
            electionData.processVote("Chris", "Husky", "Alex");
            electionData.processVote("Chris", "Husky", "Alex");
            electionData.processVote("Husky", "Chris", "Seth");
            electionData.processVote("Chris", "Alex", "Husky");
            electionData.processVote("James", "Alex", "Husky");
            electionData.processVote("Chris" , "Deah", "Kleo");
        } catch (UnknownCandidateException | DuplicateVotesException e) {
            System.out.println("oopsxx");
        }

        assertEquals(electionData.findWinnerMostPoints(), "Chris");
    }

    @Test
    public void testWinnerByTier1() {

        ElectionData electionData = new ElectionData();
        try {
            electionData.addCandidate("James");
            electionData.addCandidate("Kleo");
            electionData.addCandidate("Chris");
            electionData.addCandidate("Seth");
            electionData.addCandidate("Alex");
            electionData.addCandidate("Deah");
            electionData.addCandidate("Husky");
        } catch(CandidateExistsException e) {
            System.out.println("oops2");
        }
        try {
            electionData.processVote("Chris", "Alex", "Husky");
            electionData.processVote("Chris", "Husky", "Alex");
            electionData.processVote("Husky", "Chris", "Seth");
            electionData.processVote("Chris", "Alex", "Husky");
            electionData.processVote("Deah", "Alex", "Husky");
            electionData.processVote("Chris" , "Deah", "Kleo");
        } catch (UnknownCandidateException | DuplicateVotesException e) {
            System.out.println("oopsyy");
        }

        assertEquals("Chris", electionData.findWinnerMostFirstVotes());
    }

    @Test
    public void testWinnerByTier1RunoffRequired() {
        ElectionData electionData = new ElectionData();
        try {
            electionData.addCandidate("James");
            electionData.addCandidate("Kleo");
            electionData.addCandidate("Chris");
            electionData.addCandidate("Seth");
            electionData.addCandidate("Alex");
            electionData.addCandidate("Deah");
            electionData.addCandidate("Husky");
        } catch(CandidateExistsException e) {
            System.out.println("oops1w1");

        }

        try {
            electionData.processVote("Chris", "Alex", "Husky");
            electionData.processVote("Alex", "Chris", "Husky");
            electionData.processVote("Husky", "Chris", "Alex");
        } catch (UnknownCandidateException | DuplicateVotesException e) {
            System.out.println("oops1223333");
        }

        assertEquals("Runoff required", electionData.findWinnerMostFirstVotes());
    }

    @Test
    public void testWinnerByTier1RunoffRequired2() {
        ElectionData electionData = new ElectionData();
        assertEquals("Runoff required", electionData.findWinnerMostFirstVotes());
    }


}
