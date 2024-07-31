package bg.fmi.javaweb.sportstournamentorganizer.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerOutputDto {
    private Long id;
    private String username;
    private String email;
    private String password;
}
