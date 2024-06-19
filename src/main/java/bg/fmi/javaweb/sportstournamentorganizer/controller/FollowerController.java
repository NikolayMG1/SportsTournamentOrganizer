package bg.fmi.javaweb.sportstournamentorganizer.controller;

import bg.fmi.javaweb.sportstournamentorganizer.dto.FollowerInputDto;
import bg.fmi.javaweb.sportstournamentorganizer.dto.FollowerOutputDto;
import bg.fmi.javaweb.sportstournamentorganizer.mapper.FollowerMapper;
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

    @Autowired
    private FollowerMapper followerMapper;


    @PostMapping
    public ResponseEntity<FollowerOutputDto> createFollower(@RequestBody FollowerInputDto followerInputDto) {
        followerService.createFollower(followerMapper.mapFromInputDto(followerInputDto));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FollowerOutputDto> getFollower(@PathVariable Integer id) {
        return new ResponseEntity<>(followerMapper.mapToOutputDto(followerService.getFollower(id)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FollowerOutputDto> deleteFollower(@PathVariable Integer id) {
        followerService.removeFollower(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}

