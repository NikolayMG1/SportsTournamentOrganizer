package bg.fmi.javaweb.sportstournamentorganizer.controller;


import bg.fmi.javaweb.sportstournamentorganizer.dto.PlayerInputDto;
import bg.fmi.javaweb.sportstournamentorganizer.dto.PlayerOutputDto;
import bg.fmi.javaweb.sportstournamentorganizer.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {
    @Autowired
    private PlayerService playerService;


    @GetMapping("/id/{id}")
    public ResponseEntity<PlayerOutputDto> getPlayerById(@PathVariable Long id) {
        return new ResponseEntity<>(playerService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/username")
    public ResponseEntity<PlayerOutputDto> getPLayerByUsername(@RequestParam  String username) {
        return new ResponseEntity<>(playerService.findByUsernameAsDto(username), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PlayerOutputDto>> findAll() {

        return new ResponseEntity<>(playerService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<PlayerOutputDto> createFollower(@RequestBody PlayerInputDto playerInputDto) {

        return new ResponseEntity<>(playerService.createPlayer(playerInputDto), HttpStatus.OK);
    }

    @PatchMapping("/{id}/change-name/{username}")
    public ResponseEntity<PlayerOutputDto> updateTeam(@PathVariable Long id, @PathVariable String username) {
        return new ResponseEntity<>(playerService.updateUsername(id, username), HttpStatus.OK);
    }


}
