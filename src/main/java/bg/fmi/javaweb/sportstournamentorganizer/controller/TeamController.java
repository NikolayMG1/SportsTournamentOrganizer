package bg.fmi.javaweb.sportstournamentorganizer.controller;

import bg.fmi.javaweb.sportstournamentorganizer.dto.PlayerInputDto;
import bg.fmi.javaweb.sportstournamentorganizer.dto.TeamInputDto;
import bg.fmi.javaweb.sportstournamentorganizer.dto.TeamOutputDto;
import bg.fmi.javaweb.sportstournamentorganizer.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teams")
public class TeamController {
    @Autowired
    private TeamService teamService;

    @PostMapping("/add")
    public ResponseEntity<TeamOutputDto> addTeam(@RequestBody TeamInputDto teamInputDto) {
            return new ResponseEntity<>(teamService.addTeam(teamInputDto), HttpStatus.OK);
    }

    @GetMapping("/get-team")
    public ResponseEntity<TeamOutputDto> findById(@RequestParam Long id) {
        return new ResponseEntity<>(teamService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/teamName/{teamName}")
    public ResponseEntity<TeamOutputDto> findByTeamName(@PathVariable String teamName) {
        return new ResponseEntity<>(teamService.findByTeamNameToDto(teamName), HttpStatus.OK);
    }

    @PatchMapping("/addPlayer")
    public ResponseEntity<TeamOutputDto> addPlayer(@RequestParam Long id, @RequestBody PlayerInputDto playerInputDto) {
        return new ResponseEntity<>(teamService.addPlayer(id, playerInputDto), HttpStatus.OK);
    }

//    @GetMapping("/{id}/manager")
//    public ResponseEntity<ManagerOutputDto> getManagerById(@PathVariable Long id) {
//        return new ResponseEntity<>(teamService.findById(id), HttpStatus.OK);
//    }
}
