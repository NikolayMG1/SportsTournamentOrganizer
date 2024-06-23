package bg.fmi.javaweb.sportstournamentorganizer.controller;

import bg.fmi.javaweb.sportstournamentorganizer.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatchController {
    @Autowired
    private MatchService matchService;
}
