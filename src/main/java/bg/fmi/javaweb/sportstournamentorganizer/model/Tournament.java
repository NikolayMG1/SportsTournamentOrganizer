package bg.fmi.javaweb.sportstournamentorganizer.model;


import java.time.LocalDateTime;
import java.util.List;

public class Tournament {
    private Integer tournamentId;
    private String tournamentName;
    private Moderator tournamentModerator;
    private LocalDateTime tournamentStart;
    private LocalDateTime tournamentEnd;
    private String tournamentLocation;
    private SportType tournamentSportType;
    private SportMastery tournamentSportMastery;
    private List<Team> teamsParticipated = List.of();
    private List<Follower> tournamentFollowers = List.of();
//    Team winner;

    public Tournament(Integer tournamentId, String tournamentName, Moderator tournamentModerator,
                      LocalDateTime tournamentStart, LocalDateTime tournamentEnd, String tournamentLocation,
                      SportType tournamentSportType, SportMastery tournamentSportMastery,
                      List<Team> teamsParticipated, List<Follower> tournamentFollowers) {
        this.tournamentId = tournamentId;
        this.tournamentModerator = tournamentModerator;
        this.tournamentStart = tournamentStart;
        this.tournamentEnd = tournamentEnd;
        this.tournamentLocation = tournamentLocation;
        this.tournamentSportType = tournamentSportType;
        this.tournamentSportMastery = tournamentSportMastery;
        this.teamsParticipated = teamsParticipated;
        this.tournamentFollowers = tournamentFollowers;
    }

    public Integer getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(Integer tournamentId) {
        this.tournamentId = tournamentId;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public Moderator getTournamentModerator() {
        return tournamentModerator;
    }

    public void setTournamentModerator(Moderator tournamentModerator) {
        this.tournamentModerator = tournamentModerator;
    }

    public LocalDateTime getTournamentStart() {
        return tournamentStart;
    }

    public void setTournamentStart(LocalDateTime tournamentStart) {
        this.tournamentStart = tournamentStart;
    }

    public LocalDateTime getTournamentEnd() {
        return tournamentEnd;
    }

    public void setTournamentEnd(LocalDateTime tournamentEnd) {
        this.tournamentEnd = tournamentEnd;
    }

    public String getTournamentLocation() {
        return tournamentLocation;
    }

    public void setTournamentLocation(String tournamentLocation) {
        this.tournamentLocation = tournamentLocation;
    }

    public SportType getTournamentSportType() {
        return tournamentSportType;
    }

    public void setTournamentSportType(SportType tournamentSportType) {
        this.tournamentSportType = tournamentSportType;
    }

    public SportMastery getTournamentSportMastery() {
        return tournamentSportMastery;
    }

    public void setTournamentSportMastery(SportMastery tournamentSportMastery) {
        this.tournamentSportMastery = tournamentSportMastery;
    }







    @Override
    public int hashCode() {
        return tournamentId.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return tournamentId.equals(((Tournament) o).tournamentId);
    }
}
