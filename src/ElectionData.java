import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * ElectionData for the ballot and votes information.
 */
public class ElectionData {
    private HashMap<String, Candidate> candidates =
            new HashMap<String, Candidate>();

    public ElectionData() { }

//  helper function to determine if a vote is valid
//  A vote is only valid if the voter enters three different names, each of which is a candidate on the ballot.
    private boolean isValid(String firstChoice,String secondChoice,String thirdChoice) {
        return ((firstChoice != secondChoice) &&
                (firstChoice != thirdChoice) &&
                (secondChoice  != thirdChoice))
                && (candidates.containsKey(firstChoice) &&
                candidates.containsKey(secondChoice) &&
                candidates.containsKey(thirdChoice));
    }

    //  TODO helper function to determine xyz (add later)
    private double calculateHalf() {
        double total = 0;

        for (Map.Entry<String, Candidate> entry : candidates.entrySet()) {
            total += entry.getValue().getNumOfFirstChoice();
        }
        return total / 2;
    }

    public LinkedList<String> getCandidates() {
        LinkedList<String>  cans = new LinkedList<>();
        for(Candidate candidate: candidates.values()) {
            cans.add(candidate.getName());
        }
        return cans;
    }

//    consumes three strings (first, second, third choices, respectfully)
//    produces void
//    this method stores a single voter's choices in your data structure
//    calling this method corresponds to someone voting in the election

    public void processVote(String firstChoice,String secondChoice,String thirdChoice)
    throws DuplicateVotesException, UnknownCandidateException {

        if (isValid(firstChoice, secondChoice, thirdChoice)) {
            Candidate first = candidates.get(firstChoice);
            Candidate second = candidates.get(secondChoice);
            Candidate third = candidates.get(thirdChoice);

//       Does this actually update the object in the Hashmap?
//       Update existing? or do i have to remove what was originally there and then
//        add them again.

//          I don't think that this is actually updating previously existing
            first.addNumOfFirstChoice();
            second.addNumOfSecondChoice();
            third.addNumOfThirdChoice();
        }

    }

//    consumes a String (the name of a candidate)
//    adds the candidate to the ballot
//    if the candidate was already on the ballot, throw a CandidateExistsException
//    whose constructor takes the name as its only argument
//    produces void
    public void addCandidate(String candidate) throws CandidateExistsException {
        if(!candidates.containsKey(candidate)) {
            Candidate aCandidate = new Candidate(candidate);
            candidates.put(candidate, aCandidate);
        } else
            throw new CandidateExistsException(candidate);
    }


    public String findWinnerMostFirstVotes() {
        double half = calculateHalf();
        LinkedList<Candidate> winningCandidates = new LinkedList<>();

        for(Map.Entry<String, Candidate> entry : candidates.entrySet()) {
            String key = entry.getKey();
            Candidate value = entry.getValue();
            if(value.getNumOfFirstChoice() > half) {
                winningCandidates.add(value);
            }
        }

        if(winningCandidates.size() > 1) {
            return "Runoff required";
        }
        return winningCandidates.get(0).getName();
    }


    public String findWinnerMostPoints() {
        String currentWinner = "";
        double currentMax = 0;

        for (Map.Entry<String, Candidate> entry : candidates.entrySet()) {
            Candidate candidate = entry.getValue();
           if(candidate.totalPoints() >= currentMax) {
               currentWinner = candidate.getName();
               currentMax = candidate.totalPoints();
           }
        }

        return currentWinner;
    }
}
