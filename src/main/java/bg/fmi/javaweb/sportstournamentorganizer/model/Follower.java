package bg.fmi.javaweb.sportstournamentorganizer.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Entity(name = "followers")
@NoArgsConstructor
public class Follower extends User{

    @ManyToMany
    @JoinTable(name = "follower_team",
                joinColumns = @JoinColumn(name = "userId"),
                inverseJoinColumns = @JoinColumn(name = "teamId"))
    private List<Team> followedTeams;

    @ManyToMany
    @JoinTable(name = "follower_tournament",
                joinColumns = @JoinColumn(name = "userId"),
                inverseJoinColumns = @JoinColumn(name = "tournamentId"))
    private List<Tournament> followedTournaments;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

}
