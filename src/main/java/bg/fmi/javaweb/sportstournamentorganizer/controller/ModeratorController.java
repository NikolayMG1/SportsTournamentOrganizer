package bg.fmi.javaweb.sportstournamentorganizer.controller;


import bg.fmi.javaweb.sportstournamentorganizer.dto.ModeratorInputDto;
import bg.fmi.javaweb.sportstournamentorganizer.dto.ModeratorOutputDto;
import bg.fmi.javaweb.sportstournamentorganizer.mapper.ModeratorMapper;
import bg.fmi.javaweb.sportstournamentorganizer.service.ModeratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/moderator")
public class ModeratorController {
    @Autowired
    private ModeratorService moderatorService;

    @Autowired
    private ModeratorMapper moderatorMapper;

    @PostMapping
    public ResponseEntity<ModeratorOutputDto> createModerator(@RequestBody ModeratorInputDto moderatorInputDto) {
        moderatorService.addModerator(moderatorMapper.mapFromInputDto(moderatorInputDto));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModeratorOutputDto> getModerator(@PathVariable Integer id) {
        return new ResponseEntity<>(moderatorMapper.mapToOutputDto(moderatorService.getModerator(id)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ModeratorOutputDto> deleteModerator(@PathVariable Integer id) {
        moderatorService.removeModerator(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
