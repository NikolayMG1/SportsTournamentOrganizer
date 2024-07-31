package bg.fmi.javaweb.sportstournamentorganizer.controller;

import bg.fmi.javaweb.sportstournamentorganizer.dto.TournamentInputDto;
import bg.fmi.javaweb.sportstournamentorganizer.dto.TournamentOutputDto;
import bg.fmi.javaweb.sportstournamentorganizer.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tournament")
public class TournamentController {
    @Autowired
    private TournamentService tournamentService;

    @PostMapping("/create")
    public ResponseEntity<TournamentOutputDto> createTournament(@RequestBody TournamentInputDto tournamentInputDto) {
        return new ResponseEntity<>(tournamentService.create(tournamentInputDto), HttpStatus.OK);
    }
}
