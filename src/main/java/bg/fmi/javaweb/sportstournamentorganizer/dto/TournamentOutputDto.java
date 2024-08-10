package bg.fmi.javaweb.sportstournamentorganizer.dto;

import bg.fmi.javaweb.sportstournamentorganizer.model.SportMastery;
import bg.fmi.javaweb.sportstournamentorganizer.model.SportType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

//TODO: Add List<TeamOutputDto> to see the teams
@Getter
@Setter
public class TournamentOutputDto {

    private Long tournamentId;
    private String tournamentName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime tournamentStart;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime tournamentEnd;

    private String tournamentLocation;
    private SportType sportType;
    private SportMastery sportMastery;
    //private List<MatchOutputDto> matches;
}
