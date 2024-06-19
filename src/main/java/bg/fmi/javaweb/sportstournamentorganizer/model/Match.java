package bg.fmi.javaweb.sportstournamentorganizer.model;


import java.time.LocalDateTime;
import java.util.Map.Entry;


public class Match {
    private Integer matchId;
    private Team host;
    private Team guest;
    private SportType matchSportType;
    private SportMastery matchSportMastery;
    private Tournament matchTournament;
    private Entry<Integer, Integer> score;
    private LocalDateTime matchStartTime;
    private LocalDateTime matchEndTime;
    private String matchLocation;

    public Match(Integer matchId, Team host, Team guest, SportType matchSportType, SportMastery matchSportMastery,
                 Tournament matchTournament, Entry<Integer, Integer> score, LocalDateTime matchStartTime,
                 LocalDateTime matchEndTime, String matchLocation) {
        this.matchId = matchId;
        this.host = host;
        this.guest = guest;
        this.matchSportType = matchSportType;
        this.matchSportMastery = matchSportMastery;
        this.matchTournament = matchTournament;
        this.score = score;
        this.matchStartTime = matchStartTime;
        this.matchEndTime = matchEndTime;
        this.matchLocation = matchLocation;
    }

    public Integer getMatchId() {
        return matchId;
    }

    public void setMatchId(Integer matchId) {
        this.matchId = matchId;
    }

    public Team getHost() {
        return host;
    }

    public void setHost(Team host) {
        this.host = host;
    }

    public Team getGuest() {
        return guest;
    }

    public void setGuest(Team guest) {
        this.guest = guest;
    }

    public SportType getMatchSportType() {
        return matchSportType;
    }

    public void setMatchSportType(SportType matchSportType) {
        this.matchSportType = matchSportType;
    }

    public SportMastery getMatchSportMastery() {
        return matchSportMastery;
    }

    public void setMatchSportMastery(SportMastery matchSportMastery) {
        this.matchSportMastery = matchSportMastery;
    }

    public Tournament getMatchTournament() {
        return matchTournament;
    }

    public void setMatchTournament(Tournament matchTournament) {
        this.matchTournament = matchTournament;
    }

    public Entry<Integer, Integer> getScore() {
        return score;
    }

    public void setScore(Entry<Integer, Integer> score) {
        this.score = score;
    }

    public LocalDateTime getMatchStartTime() {
        return matchStartTime;
    }

    public void setMatchStartTime(LocalDateTime matchStartTime) {
        this.matchStartTime = matchStartTime;
    }

    public LocalDateTime getMatchEndTime() {
        return matchEndTime;
    }

    public void setMatchEndTime(LocalDateTime matchEndTime) {
        this.matchEndTime = matchEndTime;
    }

    public String getMatchLocation() {
        return matchLocation;
    }

    public void setMatchLocation(String matchLocation) {
        this.matchLocation = matchLocation;
    }



    @Override
    public int hashCode() {
        return matchId.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return matchId.equals( ((Match) o).matchId );
    }
}
