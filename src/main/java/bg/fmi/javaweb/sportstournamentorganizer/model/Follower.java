package bg.fmi.javaweb.sportstournamentorganizer.model;

import java.util.List;

public class Follower extends User{
    private List<Team> followedTeams = List.of();
    private List<Tournament> followedTournaments = List.of();

    public List<Team> getFollowedTeams() {
        return followedTeams;
    }

    public List<Tournament> getFollowedTournaments() {
        return followedTournaments;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

}
