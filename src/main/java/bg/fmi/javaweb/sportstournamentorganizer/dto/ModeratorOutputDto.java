package bg.fmi.javaweb.sportstournamentorganizer.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModeratorOutputDto {
    private Long id;
    private String username;
    private String email;
    private String password;

}

