package bg.fmi.javaweb.sportstournamentorganizer.service;

import bg.fmi.javaweb.sportstournamentorganizer.model.Match;
import bg.fmi.javaweb.sportstournamentorganizer.repository.MatchRepository;
import org.springframework.stereotype.Service;

@Service
public class MatchService {
    private MatchRepository matchRepository = new MatchRepository();

    public void addMatch(Match match) {
        matchRepository.addMatch(match);
    }

    public boolean removeMatch(Integer id) {
        return matchRepository.removeMatch(id);
    }

    public Match getMatch(Integer id) {
        return matchRepository.getMatch(id);
    }

    public void updateMatch(Match match) {
        matchRepository.updateMatch(match);
    }


}

