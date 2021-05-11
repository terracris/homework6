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

//  helper method to determine if a vote is valid
//  A vote is only valid if the voter enters three different names, each of which is a candidate on the ballot.
    private boolean isValid(String firstChoice,String secondChoice,String thirdChoice) {
        return isVoteValid(firstChoice, secondChoice, thirdChoice)
                && isCandidateValid(firstChoice, secondChoice, thirdChoice);

    }

//    determines if vote is valid
    private boolean isVoteValid(String firstChoice,String secondChoice,String thirdChoice) {
        return (!firstChoice.equals(secondChoice)) &&
                (!firstChoice.equals(thirdChoice)) &&
                (!secondChoice.equals(thirdChoice));
    }

//    determines if candidate is in ballot
    private boolean isCandidateValid(String firstChoice,String secondChoice,String thirdChoice) {
        return (candidates.containsKey(firstChoice) &&
                candidates.containsKey(secondChoice) &&
                candidates.containsKey(thirdChoice));
    }

//     helper method to determine 50% of total points
    private double calculateHalf() {
        double total = 0;

        for (Map.Entry<String, Candidate> entry : candidates.entrySet()) {
            total += entry.getValue().getNumOfFirstChoice();
        }
        return total / 2;
    }

//    returns a list of candidate names
    public LinkedList<String> getCandidates() {
        LinkedList<String> cands = new LinkedList<>();
        for(Candidate candidate: candidates.values()) {
            cands.add(candidate.getName());
        }
        return cands;
    }

    /**
     * stores a single voter's 3 choices, respectfully, in your data structure
     * @param firstChoice highest rank vote
     * @param secondChoice second highest rank vote
     * @param thirdChoice third highest rank vote
     * @throws DuplicateVotesException when a vote contains the same candidate twice
     * @throws UnknownCandidateException when a  vote contains a candidate that had not been previously added
     */
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
            // TODO actually update the values. needs modification

//            for(int i = 0 ; i < contact.size(); i++) {
//                Contact thisContact = contact.get(i);
//                if(thisContact.thisAddress.equals(key)) {
//                    contact.remove(i);
//                    contact.add(aContact);
//                    contacts.put(key, contact);
//                    return;
//                }


            first.addNumOfFirstChoice();
            second.addNumOfSecondChoice();
            third.addNumOfThirdChoice();

//            update objects
            candidates.put(firstChoice, first);
            candidates.put(secondChoice, second);
            candidates.put(thirdChoice, third);


        } else if(!isCandidateValid(firstChoice, secondChoice, thirdChoice)) {
            // need to modify
            LinkedList<String> votes = new LinkedList<>();
            votes.add(firstChoice);
            votes.add(secondChoice);
            votes.add(thirdChoice);
            for(String name : votes) {
                if(!candidates.containsKey(name)) {
                    throw new UnknownCandidateException(name);
                }
            }
        } else {
            if(firstChoice.equals(secondChoice) || firstChoice.equals(thirdChoice)) {
                throw new DuplicateVotesException(firstChoice);
            } else {
                throw new DuplicateVotesException(secondChoice);
            }

        }

    }


    /**
     * Adds a Candidate to a ballot
     * @param candidate the name of the Candidate
     * @throws CandidateExistsException when a Candidate already exists in the ballot
     */
    public void addCandidate(String candidate) throws CandidateExistsException {
        if(!candidates.containsKey(candidate)) {
            Candidate aCandidate = new Candidate(candidate);
            candidates.put(candidate, aCandidate);
        } else
            throw new CandidateExistsException(candidate);
    }

    /**
     * Determines the winner of the election.
     * The winner is the candidate with more than 50% of first place votes.
     * @return the name of the candidate that won the election.
     */
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
        if(winningCandidates.size() == 0) {
            return "Runoff required";
        }
        return winningCandidates.get(0).getName();
    }

    /**
     * Determines the winner of the election.
     * The winner is the candidate with the most points.
     * If there is a tie between two or more candidates, the name of any one of the winners is returned
     * @return the name of the candidate that won the election.
     */
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
