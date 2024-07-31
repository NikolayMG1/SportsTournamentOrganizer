package bg.fmi.javaweb.sportstournamentorganizer.controller;

import bg.fmi.javaweb.sportstournamentorganizer.dto.FollowerInputDto;
import bg.fmi.javaweb.sportstournamentorganizer.dto.FollowerOutputDto;
import bg.fmi.javaweb.sportstournamentorganizer.service.FollowerService;
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

}

