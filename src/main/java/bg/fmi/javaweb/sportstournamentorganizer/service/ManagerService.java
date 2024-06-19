package bg.fmi.javaweb.sportstournamentorganizer.service;

import bg.fmi.javaweb.sportstournamentorganizer.model.Manager;
import bg.fmi.javaweb.sportstournamentorganizer.repository.ManagerRepository;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {
    private ManagerRepository managerRepository = new ManagerRepository();

    public void addManager(Manager manager) {
        managerRepository.addManager(manager);
    }

    public boolean removeManager(Integer id) {
        return managerRepository.removeManager(id);
    }

    public Manager getManager(Integer id) {
        return managerRepository.getManager(id);
    }

    public void updateManager(Manager manager) {
        managerRepository.updateManager(manager);
    }

    public void updateManagerName(Integer id, String userName) {
        managerRepository.updateManagerName(id, userName);
    }

    public void updateManagerEmail(Integer id, String email) {
        managerRepository.updateManagerEmail(id, email);
    }

    public void updateManagerPassword(Integer id, String password) {
        managerRepository.updateManagerPassword(id, password);
    }

}

