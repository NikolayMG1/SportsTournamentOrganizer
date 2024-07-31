package bg.fmi.javaweb.sportstournamentorganizer.service;

import bg.fmi.javaweb.sportstournamentorganizer.dto.TournamentInputDto;
import bg.fmi.javaweb.sportstournamentorganizer.dto.TournamentOutputDto;
import bg.fmi.javaweb.sportstournamentorganizer.mapper.TournamentMapper;
import bg.fmi.javaweb.sportstournamentorganizer.model.Tournament;
import bg.fmi.javaweb.sportstournamentorganizer.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TournamentService {
    @Autowired
    private TournamentRepository tournamentRepository;

    @Autowired
    private TournamentMapper tournamentMapper;

    @Transactional
    public TournamentOutputDto create(TournamentInputDto tournamentInputDto) {
        Tournament tournament = tournamentMapper.mapFromInputDto(tournamentInputDto);

        return tournamentMapper.mapToOutputDto(tournamentRepository.save(tournament));
    }
//    public void addTournament(Tournament tournament) {
//        tournamentRepository.addTournament(tournament);
//    }

//    public boolean removeTournament(Integer id) {
//        return tournamentRepository.removeTournament(id);
//    }
//
//    public Tournament getTournament(Integer id) {
//        return tournamentRepository.getTournament(id);
//    }
//
//    public void updateTournament(Tournament tournament) {
//        tournamentRepository.updateTournament(tournament);
//    }

}

