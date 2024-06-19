package bg.fmi.javaweb.sportstournamentorganizer.service;

import bg.fmi.javaweb.sportstournamentorganizer.model.Follower;
import bg.fmi.javaweb.sportstournamentorganizer.repository.FollowerRepository;
import org.springframework.stereotype.Service;

@Service
public class FollowerService {
    private FollowerRepository followerRepository = new FollowerRepository();

    public void createFollower(Follower follower) {
        followerRepository.addFollower(follower);
    }

    public boolean removeFollower(Integer id) {
        return followerRepository.removeFollower(id);
    }

    public Follower getFollower(Integer id) {
        return followerRepository.getFollower(id);
    }

    public void updateFollower(Follower follower) {
        followerRepository.updateFollower(follower);
    }

    public void updateFollowerName(Integer id, String userName) {
        followerRepository.updateFollowerName(id, userName);
    }

    public void updateFollowerEmail(Integer id, String email) {
        followerRepository.updateFollowerEmail(id, email);
    }

    public void updateFollowerPassword(Integer id, String password) {
        followerRepository.updateFollowerPassword(id, password);
    }



}

