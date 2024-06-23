package bg.fmi.javaweb.sportstournamentorganizer.service;

import bg.fmi.javaweb.sportstournamentorganizer.model.Manager;
import bg.fmi.javaweb.sportstournamentorganizer.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {
    @Autowired
    private ManagerRepository managerRepository;

    public void addManager(Manager manager) {
        managerRepository.save(manager);
    }

    public void removeManager(Long id) {
         managerRepository.deleteById(id);
    }

    public Manager getManager(Long id) {
        return managerRepository.getReferenceById(id);
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

