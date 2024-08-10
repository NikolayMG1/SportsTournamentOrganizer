package bg.fmi.javaweb.sportstournamentorganizer.dto;

import bg.fmi.javaweb.sportstournamentorganizer.model.MatchStatus;
import bg.fmi.javaweb.sportstournamentorganizer.model.SportMastery;
import bg.fmi.javaweb.sportstournamentorganizer.model.SportType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MatchOutputDto {
    private Long matchId;
    private String matchLocation;
    private SportMastery sportMastery;
    private LocalDateTime matchStartTime;
    private LocalDateTime matchEndTime;
    private String host;
    private String guest;
    private MatchStatus matchStatus;
}
