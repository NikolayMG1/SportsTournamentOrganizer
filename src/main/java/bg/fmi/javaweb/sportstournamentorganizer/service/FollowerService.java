package bg.fmi.javaweb.sportstournamentorganizer.service;

import bg.fmi.javaweb.sportstournamentorganizer.dto.FollowerInputDto;
import bg.fmi.javaweb.sportstournamentorganizer.dto.FollowerOutputDto;
import bg.fmi.javaweb.sportstournamentorganizer.exception.FollowerAlreadyExistsException;
import bg.fmi.javaweb.sportstournamentorganizer.exception.FollowerNotFoundException;
import bg.fmi.javaweb.sportstournamentorganizer.mapper.FollowerMapper;
import bg.fmi.javaweb.sportstournamentorganizer.model.Follower;
import bg.fmi.javaweb.sportstournamentorganizer.repository.FollowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FollowerService {
    @Autowired
    private FollowerRepository followerRepository;

    @Autowired
    private FollowerMapper followerMapper;

    public FollowerOutputDto createFollower(FollowerInputDto followerInputDto) {
        Follower follower = followerMapper.mapFromInputDto(followerInputDto);

        if(existsByEmail(follower.getEmail())) {
            throw new FollowerAlreadyExistsException(follower.getEmail());
        }

        if(existsByUsername(followerInputDto.getUsername())) {
            throw new FollowerAlreadyExistsException(followerInputDto.getUsername());
        }

        return followerMapper.mapToOutputDto(followerRepository.save(follower));
    }

    public void removeFollower(Long id) {
        followerRepository.deleteById(id);
    }
    public FollowerOutputDto findById(Long id) {

        Follower follower = followerRepository.findById(id).orElseThrow(() -> new FollowerNotFoundException(id));

        return followerMapper.mapToOutputDto(follower);
    }

    public boolean existsByEmail(String email) {
        return followerRepository.existsByEmail(email);
    }

    public boolean existsByUsername(String username) {
        return followerRepository.existsByUsername(username);
    }
//
//    public void updateFollower(Follower follower) {
//        followerRepository.updateFollower(follower);
//    }
//
//    public void updateFollowerName(Integer id, String userName) {
//        followerRepository.updateFollowerName(id, userName);
//    }
//
//    public void updateFollowerEmail(Integer id, String email) {
//        followerRepository.updateFollowerEmail(id, email);
//    }

//    public void updateFollowerPassword(Integer id, String password) {
//        followerRepository.updateFollowerPassword(id, password);
//    }

}

