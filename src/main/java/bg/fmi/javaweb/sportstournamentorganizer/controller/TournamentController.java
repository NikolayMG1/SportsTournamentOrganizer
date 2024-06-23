package bg.fmi.javaweb.sportstournamentorganizer.controller;

import bg.fmi.javaweb.sportstournamentorganizer.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TournamentController {
    @Autowired
    private TournamentService tournamentService;
}
