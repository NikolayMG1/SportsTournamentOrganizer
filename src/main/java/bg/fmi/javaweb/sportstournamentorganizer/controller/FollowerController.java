package bg.fmi.javaweb.sportstournamentorganizer.controller;

import bg.fmi.javaweb.sportstournamentorganizer.dto.FollowerInputDto;
import bg.fmi.javaweb.sportstournamentorganizer.dto.FollowerOutputDto;
import bg.fmi.javaweb.sportstournamentorganizer.dto.TeamOutputDto;
import bg.fmi.javaweb.sportstournamentorganizer.service.FollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/follower")
public class FollowerController {

    @Autowired
    private FollowerService followerService;


    @PostMapping("/create")
    public ResponseEntity<FollowerOutputDto> createFollower(@RequestBody FollowerInputDto followerInputDto) {

        return new ResponseEntity<>(followerService.createFollower(followerInputDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FollowerOutputDto> getFollower(@PathVariable Long id) {
        return new ResponseEntity<>(followerService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FollowerOutputDto> deleteFollower(@PathVariable Long id) {
        followerService.removeFollower(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/follow")
    public ResponseEntity<FollowerOutputDto> followTeam(@RequestParam String followerName, @RequestParam String teamName) {
        return new ResponseEntity<>(followerService.follow(followerName, teamName), HttpStatus.OK);
    }

    @GetMapping("/followed-teams")
    public ResponseEntity<List<TeamOutputDto>> getFollowedTeams(@RequestParam Long id) {
        return new ResponseEntity<>(followerService.getFollowedTeams(id), HttpStatus.OK);

    }

}

