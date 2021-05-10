import static org.junit.Assert.*;
import org.junit.Test;

public class Examples {


    @Test
    public void testWinnerByPoints() {
        ElectionData electionData = new ElectionData();
        try {
            electionData.addCandidate("JositoPocitoSuavcito");
            electionData.addCandidate("Meanjew");
            electionData.addCandidate("Bukuria");
        } catch(CandidateExistsException e) {
            System.out.println("oops");

        }
        try {
            electionData.processVote("Bukuria", "Gompei", "Husky");
            electionData.processVote("Bukuria", "Husky", "Gompei");
            electionData.processVote("Bukuria", "Bukuria", "Bukuria");
            electionData.processVote("Husky", "Bukuria", "Seth");
            electionData.processVote("Bukuria", "Gompei", "Husky");
            electionData.processVote("JositoPocitoSuavcito", "Gompei", "Husky");
            electionData.processVote("Bukuria" , "JositoPocitoSuavcito", "Meanjew");
        } catch (UnknownCandidateException | DuplicateVotesException e) {
            System.out.println("oops");
        }

        assertEquals(electionData.findWinnerMostPoints(), "Bukuria");
    }

    @Test
    public void testWinnerByTier1() {

        ElectionData electionData = new ElectionData();
        try {
            electionData.addCandidate("JositoPocitoSuavcito");
            electionData.addCandidate("Meanjew");
            electionData.addCandidate("Bukuria");
        } catch(CandidateExistsException e) {
            System.out.println("oops");

        }
        try {
            electionData.processVote("Bukuria", "Gompei", "Husky");
            electionData.processVote("Bukuria", "Husky", "Gompei");
            electionData.processVote("Bukuria", "Bukuria", "Bukuria");
            electionData.processVote("Husky", "Bukuria", "Seth");
            electionData.processVote("Bukuria", "Gompei", "Husky");
            electionData.processVote("JositoPocitoSuavcito", "Gompei", "Husky");
            electionData.processVote("Bukuria" , "JositoPocitoSuavcito", "Meanjew");
        } catch (UnknownCandidateException | DuplicateVotesException e) {
            System.out.println("oops");
        }

        assertEquals(electionData.findWinnerMostFirstVotes(), "Bukuria");
    }

    @Test
    public void testWinnerByTier1RunoffRequired() {

        ElectionData electionData = new ElectionData();
        try {
            electionData.processVote("Bukuria", "Gompei", "Husky");
            electionData.processVote("Gompei", "Bukuria", "Husky");
            electionData.processVote("Husky", "Bukuria", "Gompei");
        } catch (UnknownCandidateException | DuplicateVotesException e) {
            System.out.println("oops");
        }

        assertEquals(electionData.findWinnerMostFirstVotes(), "Runoff required");
    }

    @Test
    public void testWinnerByTier1RunoffRequired2() {
        ElectionData electionData = new ElectionData();
        assertEquals(electionData.findWinnerMostFirstVotes(), "Runoff required");
    }


}
