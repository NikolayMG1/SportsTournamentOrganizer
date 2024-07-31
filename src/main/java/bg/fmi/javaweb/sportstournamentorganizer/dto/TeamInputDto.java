package bg.fmi.javaweb.sportstournamentorganizer.dto;

import bg.fmi.javaweb.sportstournamentorganizer.model.SportMastery;
import bg.fmi.javaweb.sportstournamentorganizer.model.SportType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamInputDto {

    private SportType sportType;
    private SportMastery sportMastery;
    private String teamName;
}
