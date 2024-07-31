package bg.fmi.javaweb.sportstournamentorganizer.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PlayerInputDto {
    private String username;
    private String email;
    private String password;
}
