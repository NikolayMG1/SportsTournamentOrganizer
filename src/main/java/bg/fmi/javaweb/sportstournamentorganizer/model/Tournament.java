package bg.fmi.javaweb.sportstournamentorganizer.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity(name = "tournaments")
@NoArgsConstructor
public class Tournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tournamentId;

    private String tournamentName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="moderator_id", referencedColumnName = "userId")
    private Moderator tournamentModerator;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime tournamentStart;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
    private LocalDateTime tournamentEnd;
    private String tournamentLocation;

    @Enumerated(EnumType.STRING)
    private SportType tournamentSportType;

    @Enumerated(EnumType.STRING)
    private SportMastery tournamentSportMastery;

    @OneToMany(mappedBy = "tournament")
    private List<Team> teamsParticipated;

    @ManyToMany(mappedBy = "followedTournaments")
    private List<Follower> tournamentFollowers ;

    @OneToMany(mappedBy = "matchTournament")
    private List<Match> matches;

    //    Team winner;
    public Tournament(Long tournamentId, String tournamentName, Moderator tournamentModerator,
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
