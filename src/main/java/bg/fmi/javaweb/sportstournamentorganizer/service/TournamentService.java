package bg.fmi.javaweb.sportstournamentorganizer.service;

import bg.fmi.javaweb.sportstournamentorganizer.model.Tournament;
import bg.fmi.javaweb.sportstournamentorganizer.repository.TournamentRepository;
import org.springframework.stereotype.Service;

@Service
public class TournamentService {
    private TournamentRepository tournamentRepository = new TournamentRepository();


    public void addTournament(Tournament tournament) {
        tournamentRepository.addTournament(tournament);
    }

    public boolean removeTournament(Integer id) {
        return tournamentRepository.removeTournament(id);
    }

    public Tournament getTournament(Integer id) {
        return tournamentRepository.getTournament(id);
    }

    public void updateTournament(Tournament tournament) {
        tournamentRepository.updateTournament(tournament);
    }




}

