package bg.fmi.javaweb.sportstournamentorganizer.service;

import bg.fmi.javaweb.sportstournamentorganizer.model.Team;
import bg.fmi.javaweb.sportstournamentorganizer.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;


//    public void addTeam(Team team) {
//        teamRepository.addTeam(team);
//    }
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

