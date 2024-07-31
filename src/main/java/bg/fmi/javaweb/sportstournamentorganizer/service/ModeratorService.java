package bg.fmi.javaweb.sportstournamentorganizer.service;

import bg.fmi.javaweb.sportstournamentorganizer.dto.ModeratorInputDto;
import bg.fmi.javaweb.sportstournamentorganizer.dto.ModeratorOutputDto;
import bg.fmi.javaweb.sportstournamentorganizer.exception.ModeratorNotFoundException;
import bg.fmi.javaweb.sportstournamentorganizer.mapper.ModeratorMapper;
import bg.fmi.javaweb.sportstournamentorganizer.model.Moderator;
import bg.fmi.javaweb.sportstournamentorganizer.repository.ModeratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModeratorService {
    @Autowired
   private ModeratorRepository moderatorRepository;
    @Autowired
    private ModeratorMapper moderatorMapper;

    public ModeratorOutputDto addModerator(ModeratorInputDto moderatorInputDto) {
        Moderator moderator = moderatorMapper.mapFromInputDto(moderatorInputDto);

        return moderatorMapper.mapToOutputDto(moderatorRepository.save(moderator));
    }

    public void removeModerator(Long id) {

        moderatorRepository.deleteById(id);
    }

    public ModeratorOutputDto getModeratorById(Long id) {

        return moderatorMapper.mapToOutputDto(moderatorRepository.findById(id).orElseThrow(() -> new ModeratorNotFoundException(id)));
    }


    //TODO
    public ModeratorOutputDto getModeratorbyUsername(String username) {
        return moderatorMapper.mapToOutputDto(moderatorRepository.findByUsername(username).orElseThrow());
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

