package bg.fmi.javaweb.sportstournamentorganizer.service;

import bg.fmi.javaweb.sportstournamentorganizer.dto.ManagerInputDto;
import bg.fmi.javaweb.sportstournamentorganizer.dto.ManagerOutputDto;
import bg.fmi.javaweb.sportstournamentorganizer.dto.TeamInputDto;
import bg.fmi.javaweb.sportstournamentorganizer.dto.TeamOutputDto;
import bg.fmi.javaweb.sportstournamentorganizer.exception.ManagerAlreadyExistsException;
import bg.fmi.javaweb.sportstournamentorganizer.exception.ManagerNotFoundException;
import bg.fmi.javaweb.sportstournamentorganizer.mapper.ManagerMapper;
import bg.fmi.javaweb.sportstournamentorganizer.model.Manager;
import bg.fmi.javaweb.sportstournamentorganizer.model.Team;
import bg.fmi.javaweb.sportstournamentorganizer.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ManagerService {
    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private ManagerMapper managerMapper;

    @Autowired
    private TeamService teamService;

    public ManagerOutputDto addManager(ManagerInputDto manager) {


        if(managerRepository.existsByUsername(manager.getUsername())) {
            throw new ManagerAlreadyExistsException(manager.getUsername());
        }

        Manager newManager = managerRepository.save(managerMapper.mapFromInputDto(manager));

        return managerMapper.mapToOutputDto(newManager);
    }


    public void removeManager(Long id) {
         managerRepository.deleteById(id);
    }

    public ManagerOutputDto getManagerByUsername(String username) {
        ManagerOutputDto managerOutputDto =  managerMapper.mapToOutputDto(managerRepository.findByUsername(username).orElseThrow(() -> new ManagerNotFoundException(username)));

        return managerOutputDto;
    }

    @Transactional(readOnly = true)
    public ManagerOutputDto findById(Long id) {
        Manager manager = managerRepository.findById(id).orElseThrow(() -> new ManagerNotFoundException(id));

        return managerMapper.mapToOutputDto(manager);
    }

    //TODO
    //Fix
    @Transactional(readOnly = false)
    public ManagerOutputDto addTeam(Long id, TeamInputDto teamInputDto) {

        teamService.addTeam(teamInputDto);

        Team team = teamService.toTeam(teamInputDto);

        Manager manager = findByIdHelper(id);

        team.setManager(manager);

        manager = managerRepository.save(manager);

        teamService.addTeam(teamInputDto);

        return managerMapper.mapToOutputDto(manager);
    }

    public TeamOutputDto findTeamByManagerId(Long id) {
        return teamService.findManagerBy_UserId(id);
    }

    private Manager findByIdHelper(Long id) {
        return managerRepository.findById(id).orElseThrow(() -> new ManagerNotFoundException(id));
    }


//    public void updateManager(Manager manager) {
//        managerRepository.updateManager(manager);
//    }
//
//    public void updateManagerName(Integer id, String userName) {
//        managerRepository.updateManagerName(id, userName);
//    }
//
//    public void updateManagerEmail(Integer id, String email) {
//        managerRepository.updateManagerEmail(id, email);
//    }
//
//    public void updateManagerPassword(Integer id, String password) {
//        managerRepository.updateManagerPassword(id, password);
//    }

}

