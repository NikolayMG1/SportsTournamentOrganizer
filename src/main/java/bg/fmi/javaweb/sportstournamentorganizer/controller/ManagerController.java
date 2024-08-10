package bg.fmi.javaweb.sportstournamentorganizer.controller;


import bg.fmi.javaweb.sportstournamentorganizer.dto.*;
import bg.fmi.javaweb.sportstournamentorganizer.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @PostMapping
    public ResponseEntity<ManagerOutputDto> createManager(@RequestBody ManagerInputDto managerInputDto) {

        return new ResponseEntity<>(managerService.addManager(managerInputDto), HttpStatus.CREATED);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ManagerOutputDto> getManager(@PathVariable Long id) {
        ManagerOutputDto managerOutputDto = managerService.findById(id);

        return new ResponseEntity<>(managerOutputDto, HttpStatus.OK);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<ManagerOutputDto> getManagerByUsername(@PathVariable String username) {
        ManagerOutputDto managerOutputDto = managerService.getManagerByUsername(username);

        return new ResponseEntity<>(managerOutputDto, HttpStatus.OK);
    }

    @GetMapping("/{id}/team")
    public ResponseEntity<TeamOutputDto> findTeamByManagerId(@PathVariable Long id) {
        return new ResponseEntity<>(managerService.findTeamByManagerId(id), HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteManager(@PathVariable Long id) {
        managerService.removeManager(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping("/add-team")
    public ResponseEntity<ManagerOutputDto> addTeam(@RequestParam Long id, @RequestBody TeamInputDto teamInputDto) {

        return new ResponseEntity<>(managerService.addTeam(id, teamInputDto), HttpStatus.OK);
    }

    @PatchMapping("/add-player")
    public ResponseEntity<TeamOutputDto> addPlayerToTeam(@RequestParam Long id, @RequestParam String player) {
        return new ResponseEntity<>(managerService.addPlayerToTeam(id, player), HttpStatus.OK);
    }

    @PatchMapping("/add-team-to-tournament")
    public ResponseEntity<TournamentOutputDto> addTeamToTournament(@RequestParam Long managerId, @RequestParam String tournamentName) {
        return new ResponseEntity<>(managerService.addTeamToTournament(managerId, tournamentName), HttpStatus.OK);
    }
}
