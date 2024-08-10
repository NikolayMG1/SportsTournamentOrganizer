package bg.fmi.javaweb.sportstournamentorganizer.controller;


import bg.fmi.javaweb.sportstournamentorganizer.dto.*;
import bg.fmi.javaweb.sportstournamentorganizer.service.ModeratorService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moderator")
public class ModeratorController {
    @Autowired
    private ModeratorService moderatorService;

    @PostMapping("/create")
    public ResponseEntity<ModeratorOutputDto> createModerator(@RequestBody ModeratorInputDto moderatorInputDto) {
        ModeratorOutputDto moderatorOutputDto = moderatorService.addModerator(moderatorInputDto);
        return new ResponseEntity<>(moderatorOutputDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ModeratorOutputDto> getModerator(@RequestParam Long id) {
        return new ResponseEntity<>(moderatorService.getModeratorById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ModeratorOutputDto> deleteModerator(@RequestParam Long id) {
       try {
           moderatorService.removeModerator(id);
           return new ResponseEntity<>(HttpStatus.OK);
       }catch (Exception e) {
           return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
       }

    }

    @PostMapping("/add-tournament")
    public ResponseEntity<TournamentOutputDto> createTournament(@RequestParam Long id, @RequestBody TournamentInputDto tournamentInputDto) {
        return new ResponseEntity<>(moderatorService.createTournament(id, tournamentInputDto), HttpStatus.OK);
    }

    @GetMapping("/all-tournaments")
    public ResponseEntity<List<TournamentOutputDto>> getAllTournaments(@RequestParam Long id) {
        return new ResponseEntity<>(moderatorService.getAllTournaments(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete-tournament/{tournamentName}")
    public ResponseEntity<List<TournamentOutputDto>> deleteTournament(@RequestParam Long moderatorId, @PathVariable String tournamentName) {
        return new ResponseEntity<>(moderatorService.deleteTournament(moderatorId, tournamentName), HttpStatus.OK);
    }

    @PatchMapping("/add-match")
    public ResponseEntity<TournamentOutputDto> addMatch(@RequestParam Long moderatorId,
                                                        @RequestParam Long tournamentId,
                                                        @RequestBody MatchInputDto matchInputDto) {
        return new ResponseEntity<>(moderatorService.addMatch(moderatorId, tournamentId, matchInputDto), HttpStatus.OK);
    }
//    @PatchMapping("/add-match")
//    public ResponseEntity<TournamentOutputDto> addMatch(@RequestParam Long moderatorId, @RequestBody MatchIn)
}
