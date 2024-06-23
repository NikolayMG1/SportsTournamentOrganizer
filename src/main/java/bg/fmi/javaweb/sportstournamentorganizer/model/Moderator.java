package bg.fmi.javaweb.sportstournamentorganizer.model;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "moderators")
@NoArgsConstructor
public class Moderator extends User{

    @OneToOne(mappedBy = "tournamentModerator")
    private Tournament tournament;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

}
