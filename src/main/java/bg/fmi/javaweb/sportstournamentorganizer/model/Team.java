package bg.fmi.javaweb.sportstournamentorganizer.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "teams")
@Getter
@Setter
@NoArgsConstructor
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teamId;

    private String teamName;

    @Enumerated(EnumType.STRING)
    private SportType participatedSport;

    @Enumerated(EnumType.STRING)
    private SportMastery participatedSportMastery;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "managerId", referencedColumnName = "userId")
    private Manager manager;

    @OneToMany(mappedBy = "playerTeam")
    private List<Player> teamPlayers;
    //    List<Tournament> tournamentsToParticipate;

    @ManyToMany(mappedBy = "followedTeams")
    private List<Follower> teamFollowers;

    @OneToMany(mappedBy = "host")
    List<Match> homeMatches;

    @OneToMany(mappedBy = "guest")
    List<Match> anyMatches;

    @ManyToOne
    @JoinColumn(name = "tournamentId", referencedColumnName = "tournamentId")
    private Tournament tournament;

    public Team(Long teamId, String teamName, SportType participatedSport, SportMastery participatedSportMastery,
                Manager manager, List<Player> teamPlayers, List<Follower> teamFollowers) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.participatedSport = participatedSport;
        this.participatedSportMastery = participatedSportMastery;
        this.manager = manager;
        this.teamPlayers = teamPlayers;
        this.teamFollowers = teamFollowers;
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
