package bg.fmi.javaweb.sportstournamentorganizer.service;

import bg.fmi.javaweb.sportstournamentorganizer.model.Follower;
import bg.fmi.javaweb.sportstournamentorganizer.repository.FollowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowerService {
    @Autowired
    private FollowerRepository followerRepository;

    public Follower createFollower(Follower follower) {
        return followerRepository.save(follower);
    }

    public void removeFollower(Long id) {
        followerRepository.deleteById(id);
    }
    public Follower getFollower(Long id) {
        return followerRepository.getReferenceById(id);
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

