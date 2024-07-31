package bg.fmi.javaweb.sportstournamentorganizer.dto;

import bg.fmi.javaweb.sportstournamentorganizer.model.Team;
import lombok.Data;

@Data
public class ManagerOutputDto {
    private Long id;
    private String username;
    private String email;
    private String password;
    private TeamOutputDto team;
}

