package bg.fmi.javaweb.sportstournamentorganizer.service;

import bg.fmi.javaweb.sportstournamentorganizer.dto.*;
import bg.fmi.javaweb.sportstournamentorganizer.exception.ModeratorNotFoundException;
import bg.fmi.javaweb.sportstournamentorganizer.mapper.MatchMapper;
import bg.fmi.javaweb.sportstournamentorganizer.mapper.ModeratorMapper;
import bg.fmi.javaweb.sportstournamentorganizer.mapper.TournamentMapper;
import bg.fmi.javaweb.sportstournamentorganizer.model.*;
import bg.fmi.javaweb.sportstournamentorganizer.repository.ModeratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class ModeratorService {
    @Autowired
    private ModeratorRepository moderatorRepository;

    @Autowired
    private ModeratorMapper moderatorMapper;

    @Autowired
    private TournamentMapper tournamentMapper;

    @Autowired
    private TournamentService tournamentService;

    @Autowired
    private MatchService matchService;

    @Autowired
    private MatchMapper matchMapper;

    @Autowired
    private TeamService teamService;

    public ModeratorOutputDto addModerator(ModeratorInputDto moderatorInputDto) {
        Moderator moderator = moderatorMapper.mapFromInputDto(moderatorInputDto);

        return moderatorMapper.mapToOutputDto(moderatorRepository.save(moderator));
    }

    public void removeModerator(Long id) {

        moderatorRepository.deleteById(id);
    }

    public ModeratorOutputDto getModeratorById(Long id) {

        return moderatorMapper.mapToOutputDto(moderatorRepository.findById(id).orElseThrow(() -> new ModeratorNotFoundException(id)));
    }

    public TournamentOutputDto createTournament(Long moderatorId, TournamentInputDto tournamentInputDto) {
        Moderator moderator = moderatorRepository.findById(moderatorId)
                .orElseThrow(() -> new ModeratorNotFoundException(moderatorId));

        return tournamentService.create(moderator, tournamentInputDto);
    }

                                                //TODO
    public ModeratorOutputDto getModeratorbyUsername(String username) {
        return moderatorMapper.mapToOutputDto(moderatorRepository.findByUsername(username)
                .orElseThrow(() -> new ModeratorNotFoundException(username)));
    }

    public List<TournamentOutputDto> getAllTournaments(Long id) {
        Moderator moderator = moderatorRepository.findById(id)
                .orElseThrow(() -> new ModeratorNotFoundException(id));

        return moderator.getTournaments().stream().map(tournament -> tournamentMapper.mapToOutputDto(tournament)).toList();
    }

    @Transactional
    public List<TournamentOutputDto> deleteTournament(Long moderatorId, String tournamentName) {
        Moderator moderator = moderatorRepository.findById(moderatorId)
                .orElseThrow(() -> new ModeratorNotFoundException(moderatorId));

        Tournament removed = tournamentService.deleteTournament(tournamentName);

        Set<Tournament> tournaments = moderator.getTournaments();
        tournaments.remove(removed);

        return tournaments.stream().
                map(tournament -> tournamentMapper.mapToOutputDto(tournament)).toList();
    }

    //TODO: fix the match result
    public TournamentOutputDto addMatch(Long moderatorId, Long tournamentId, MatchInputDto inputDto) {
        Tournament tournament = tournamentService.findById(tournamentId);

        Team host = teamService.findByTeamName(inputDto.getHost());
        Team guest = teamService.findByTeamName(inputDto.getGuest());

        Match match = matchService.createMatch(inputDto, tournament.getSportType(), host, guest);

        matchService.setMatchStatus(match);
        matchService.save(match);
        match.setTournament(tournament);
        match.setSportMastery(tournament.getSportMastery());

        tournament.getMatches().add(match);

        return tournamentService.save(tournament);
    }

//    public void updateModerator(Moderator moderator) {
//        moderatorRepository.updateModerator(moderator);
//    }
//
//
//    public void updateModeratorName(Integer id, String userName) {
//        moderatorRepository.updateModeratorName(id, userName);
//    }
//
//    public void updateModeratorEmail(Integer id, String email) {
//        moderatorRepository.updateModeratorEmail(id, email);
//    }
//
//    public void updateModeratorPassword(Integer id, String password) {
//        moderatorRepository.updateModeratorPassword(id, password);
//    }


}

