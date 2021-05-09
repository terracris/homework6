import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

// I actually don't think it is required to implement an interface?
// or is this just good encapsulation practice?
public class ElectionData implements IElectionData {
    private HashMap<String, Candidate> candidates =
            new HashMap<String, Candidate>();
    // Edit the code to use hash tables to store the number of
    // first, second, and third choice votes for each candidate on a ballot.
    ElectionData() { }

//    consumes three strings (first, second, third choices, respectfully)
//    definition respectfully : separately or individually and in the order
//    already mentioned (used when enumerating two or more items or facts that refer back to a previous statement).

//    produces void

//    this method stores a single voter's choices in your data structure
//    calling this method corresponds to someone voting in the election

    private boolean isValid(String firstChoice,String secondChoice,String thirdChoice) {
        return ((firstChoice != secondChoice) &&
                (firstChoice != thirdChoice) &&
                (secondChoice  != thirdChoice))
                && (candidates.containsKey(firstChoice) &&
                candidates.containsKey(secondChoice) &&
                candidates.containsKey(thirdChoice));
    }
    public void processVote(String firstChoice,String secondChoice,String thirdChoice)
    throws DuplicateVotesException, UnknownCandidateException {
        // gets the first choice winner
        if (isValid(firstChoice, secondChoice, thirdChoice)) {
            Candidate first = candidates.get(firstChoice);
            Candidate second = candidates.get(secondChoice);
            Candidate third = candidates.get(thirdChoice);

//       Does this actually update the object in the Hashmap?
//       Update existing? or do i have to remove what was originally there and then
//        add them again.
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

    private double calculateHalf() {
        double total = 0;

        for (Map.Entry<String, Candidate> entry : candidates.entrySet()) {
            total += entry.getValue().getNumOfFirstChoice();
        }
        return total / 2;
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
