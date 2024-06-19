package bg.fmi.javaweb.sportstournamentorganizer.dto;

import bg.fmi.javaweb.sportstournamentorganizer.model.Team;
import bg.fmi.javaweb.sportstournamentorganizer.model.Tournament;
import lombok.Data;

import java.util.List;

@Data
public class FollowerOutputDto {
    String userName;
    String email;
    List<Team> followedTeams;
    List<Tournament> followedTournaments;

}

