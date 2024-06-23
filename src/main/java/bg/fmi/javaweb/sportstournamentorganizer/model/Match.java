    package bg.fmi.javaweb.sportstournamentorganizer.model;


    import jakarta.persistence.*;
    import lombok.Getter;
    import lombok.NoArgsConstructor;
    import lombok.Setter;
    import org.springframework.format.annotation.DateTimeFormat;

    import java.time.LocalDateTime;
    import java.util.Map.Entry;


    @Setter
    @Getter
    @Entity(name = "matches")
    @NoArgsConstructor
    public class Match {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer matchId;

        @ManyToOne
        @JoinColumn(name = "host_team_id", referencedColumnName = "teamId")
        private Team host;

        @ManyToOne
        @JoinColumn(name = "guest_team_id", referencedColumnName = "teamId")
        private Team guest;

        @Enumerated(EnumType.STRING)
        private SportType matchSportType;

        @Enumerated(EnumType.STRING)
        private SportMastery matchSportMastery;

        @ManyToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "tournamentId", referencedColumnName = "tournamentId")
        private Tournament matchTournament;

        //private Entry<Integer, Integer> score;

        @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
        private LocalDateTime matchStartTime;

        @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS")
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
            //this.score = score;
            this.matchStartTime = matchStartTime;
            this.matchEndTime = matchEndTime;
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
