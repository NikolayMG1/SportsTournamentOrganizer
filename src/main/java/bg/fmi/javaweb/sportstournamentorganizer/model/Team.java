package bg.fmi.javaweb.sportstournamentorganizer.model;

import java.util.List;

public class Team {
    private Integer teamId;
    private String teamName;
    private SportType participatedSport;
    private SportMastery participatedSportMastery;
    private Manager teamManager;
    private List<Player> teamPlayers;
    //    List<Tournament> tournamentsToParticipate;
    private List<Follower> teamFollowers;

    public Team(Integer teamId, String teamName, SportType participatedSport, SportMastery participatedSportMastery,
                Manager teamManager, List<Player> teamPlayers, List<Follower> teamFollowers) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.participatedSport = participatedSport;
        this.participatedSportMastery = participatedSportMastery;
        this.teamManager = teamManager;
        this.teamPlayers = teamPlayers;
        this.teamFollowers = teamFollowers;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public SportType getParticipatedSport() {
        return participatedSport;
    }

    public void setParticipatedSport(SportType participatedSport) {
        this.participatedSport = participatedSport;
    }

    public SportMastery getParticipatedSportMastery() {
        return participatedSportMastery;
    }

    public void setParticipatedSportMastery(SportMastery participatedSportMastery) {
        this.participatedSportMastery = participatedSportMastery;
    }

    public Manager getTeamManager() {
        return teamManager;
    }

    public void setTeamManager(Manager teamManager) {
        this.teamManager = teamManager;
    }




    @Override
    public int hashCode() {
        return teamId.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return teamId.equals(((Team) o).teamId);
    }

}
