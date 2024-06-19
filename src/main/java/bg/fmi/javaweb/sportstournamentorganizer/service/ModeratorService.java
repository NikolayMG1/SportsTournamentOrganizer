package bg.fmi.javaweb.sportstournamentorganizer.service;

import bg.fmi.javaweb.sportstournamentorganizer.model.Moderator;
import bg.fmi.javaweb.sportstournamentorganizer.repository.ModeratorRepository;
import org.springframework.stereotype.Service;

@Service
public class ModeratorService {
    private ModeratorRepository moderatorRepository = new ModeratorRepository();

    public void addModerator(Moderator moderator) {
        moderatorRepository.addModerator(moderator);
    }

    public boolean removeModerator(Integer id) {
        return moderatorRepository.removeModerator(id);
    }

    public Moderator getModerator(Integer id) {
        return moderatorRepository.getModerator(id);
    }

    public void updateModerator(Moderator moderator) {
        moderatorRepository.updateModerator(moderator);
    }


    public void updateModeratorName(Integer id, String userName) {
        moderatorRepository.updateModeratorName(id, userName);
    }

    public void updateModeratorEmail(Integer id, String email) {
        moderatorRepository.updateModeratorEmail(id, email);
    }

    public void updateModeratorPassword(Integer id, String password) {
        moderatorRepository.updateModeratorPassword(id, password);
    }


}

