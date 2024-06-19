package bg.fmi.javaweb.sportstournamentorganizer.service;

import bg.fmi.javaweb.sportstournamentorganizer.model.Player;
import bg.fmi.javaweb.sportstournamentorganizer.repository.PlayerRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    private PlayerRepository playerRepository = new PlayerRepository();

    public void addPlayer(Player player) {
        playerRepository.addPlayer(player);
    }

    public boolean removePlayer(Integer id) {
        return playerRepository.removePlayer(id);
    }

    public Player getPlayer(Integer id) {
        return playerRepository.getPlayer(id);
    }

    public void updatePlayer(Player player) {
        playerRepository.updatePlayer(player);
    }

    public void updatePlayerName(Integer id, String userName) {
        playerRepository.updatePlayerName(id, userName);
    }

    public void updatePlayerEmail(Integer id, String email) {
        playerRepository.updatePlayerEmail(id, email);
    }

    public void updatePlayerPassword(Integer id, String password) {
        playerRepository.updatePlayerPassword(id, password);
    }



}

