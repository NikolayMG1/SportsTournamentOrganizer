package bg.fmi.javaweb.sportstournamentorganizer.dto;

import bg.fmi.javaweb.sportstournamentorganizer.model.SportMastery;
import bg.fmi.javaweb.sportstournamentorganizer.model.SportType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TeamOutputDto {
    private Long id;
    private SportMastery sportMastery;
    private SportType sportType;
    private String teamName;
    private List<PlayerOutputDto> players;
}