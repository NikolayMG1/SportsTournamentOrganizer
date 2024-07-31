package bg.fmi.javaweb.sportstournamentorganizer.dto;

import bg.fmi.javaweb.sportstournamentorganizer.model.SportMastery;
import bg.fmi.javaweb.sportstournamentorganizer.model.SportType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TournamentOutputDto {

    private Long tournamentId;
    private String tournamentName;
    private LocalDateTime tournamentStart;
    private LocalDateTime tournamentEnd;
    private String tournamentLocation;
    private SportType sportType;
    private SportMastery sportMastery;

}
