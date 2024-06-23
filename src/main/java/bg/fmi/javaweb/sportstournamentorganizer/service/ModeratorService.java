package bg.fmi.javaweb.sportstournamentorganizer.service;

import bg.fmi.javaweb.sportstournamentorganizer.model.Moderator;
import bg.fmi.javaweb.sportstournamentorganizer.repository.ModeratorRepository;
import org.mapstruct.ap.internal.model.common.ModelElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModeratorService {
    @Autowired
   private ModeratorRepository moderatorRepository;
//
    public Moderator addModerator(Moderator moderator) {
        return moderatorRepository.save(moderator);
    }

    public void removeModerator(Long id) {
        moderatorRepository.deleteById(id);
    }

    public Moderator getModerator(Long id) {
        return moderatorRepository.getReferenceById(id);
    }

//    public void updateModerator(Moderator moderator) {
//        moderatorRepository.updateModerator(moderator);
//    }
//
//
//    public void updateModeratorName(Integer id, String userName) {
//        moderatorRepository.updateModeratorName(id, userName);
//    }
//
//    public void updateModeratorEmail(Integer id, String email) {
//        moderatorRepository.updateModeratorEmail(id, email);
//    }
//
//    public void updateModeratorPassword(Integer id, String password) {
//        moderatorRepository.updateModeratorPassword(id, password);
//    }


}

