package bg.fmi.javaweb.sportstournamentorganizer.service;

import bg.fmi.javaweb.sportstournamentorganizer.dto.PlayerInputDto;
import bg.fmi.javaweb.sportstournamentorganizer.dto.TeamInputDto;
import bg.fmi.javaweb.sportstournamentorganizer.dto.TeamOutputDto;
import bg.fmi.javaweb.sportstournamentorganizer.exception.ManagerAlreadyExistsException;
import bg.fmi.javaweb.sportstournamentorganizer.exception.ManagerNotFoundException;
import bg.fmi.javaweb.sportstournamentorganizer.exception.TeamNotFoundException;
import bg.fmi.javaweb.sportstournamentorganizer.mapper.PlayerMapper;
import bg.fmi.javaweb.sportstournamentorganizer.mapper.TeamMapper;
import bg.fmi.javaweb.sportstournamentorganizer.model.Manager;
import bg.fmi.javaweb.sportstournamentorganizer.model.Player;
import bg.fmi.javaweb.sportstournamentorganizer.model.Team;
import bg.fmi.javaweb.sportstournamentorganizer.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private TeamMapper teamMapper;

    @Autowired
    private PlayerMapper playerMapper;

    public Team toTeam(TeamInputDto teamInputDto) {
        return teamMapper.mapFromInputDto(teamInputDto);
    }


    public TeamOutputDto addTeam(TeamInputDto teamInputDto) {
        Team team = teamMapper.mapFromInputDto(teamInputDto);

        return teamMapper.mapToOutputDto(teamRepository.save(team));
    }

    public void existsByManagerId(Long managerId) {
        if (teamRepository.findByManager_UserId(managerId).isPresent()) {
            throw new ManagerAlreadyExistsException(managerId);
        }

    }

    public TeamOutputDto findManagerBy_UserId(Long userId) {
        return teamMapper.mapToOutputDto(teamRepository.findByManager_UserId(userId).orElseThrow(() -> new TeamNotFoundException(userId)));
    }

    @Transactional(readOnly = true)
    public TeamOutputDto findByTeamName(String teamName) {

        return teamMapper.mapToOutputDto(teamRepository.findByTeamName(teamName).orElseThrow(() -> new TeamNotFoundException(teamName)));
    }

    @Transactional(readOnly = true)
    public TeamOutputDto findById(Long id) {
        Team team = teamRepository.findById(id).orElseThrow(() -> new TeamNotFoundException(id));

        return teamMapper.mapToOutputDto(team);
    }

    public TeamOutputDto addPlayer(Long id, PlayerInputDto playerInputDto) {
        Player player = playerMapper.mapFromInputDto(playerInputDto);

        Team team = teamRepository.findById(id).orElseThrow(() -> new TeamNotFoundException(id));

        team.getTeamPlayers().add(player);
        return teamMapper.mapToOutputDto(team);

    }


//
//    public boolean removeTeam(Integer id) {
//        return teamRepository.removeTeam(id);
//    }
//
//    public Team getTeam(Integer id) {
//        return teamRepository.getTeam(id);
//    }
//
//    public void updateTeam(Team team) {
//        teamRepository.updateTeam(team);
//    }



}

