package bg.fmi.javaweb.sportstournamentorganizer.service;

import bg.fmi.javaweb.sportstournamentorganizer.dto.PlayerInputDto;
import bg.fmi.javaweb.sportstournamentorganizer.dto.PlayerOutputDto;
import bg.fmi.javaweb.sportstournamentorganizer.exception.PlayerNotFoundException;
import bg.fmi.javaweb.sportstournamentorganizer.mapper.PlayerMapper;
import bg.fmi.javaweb.sportstournamentorganizer.model.Player;
import bg.fmi.javaweb.sportstournamentorganizer.model.Team;
import bg.fmi.javaweb.sportstournamentorganizer.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PlayerMapper playerMapper;

    @Autowired
    private TeamService teamService;

    public PlayerOutputDto findById(Long id) {
        return playerMapper.mapToOutputDto(playerRepository.findById(id).orElseThrow(() -> new PlayerNotFoundException(id)));
    }

    public PlayerOutputDto findByUsername(String username) {
        return playerMapper.mapToOutputDto(playerRepository.findByUsername(username).orElseThrow(() -> new PlayerNotFoundException(username)));
    }

    public List<PlayerOutputDto> findAll() {
        return playerRepository.findAll().stream().map(player -> playerMapper.mapToOutputDto(player)).toList();
    }

    public PlayerOutputDto createPlayer(PlayerInputDto playerInputDto) {
        Player player = playerMapper.mapFromInputDto(playerInputDto);
        return playerMapper.mapToOutputDto(playerRepository.save(player));
    }

    @Transactional(readOnly = true)
    public PlayerOutputDto updateUsername(Long id, String username) {
        Player player = playerRepository.findById(id).orElseThrow(() -> new PlayerNotFoundException(id));

        player.setUsername(username);

        return playerMapper.mapToOutputDto(playerRepository.save(player));
    }


//    private PlayerRepository playerRepository = new PlayerRepository();
//
//    public void addPlayer(Player player) {
//        playerRepository.addPlayer(player);
//    }
//
//    public boolean removePlayer(Integer id) {
//        return playerRepository.removePlayer(id);
//    }
//
//    public Player getPlayer(Integer id) {
//        return playerRepository.getPlayer(id);
//    }
//
//    public void updatePlayer(Player player) {
//        playerRepository.updatePlayer(player);
//    }
//
//    public void updatePlayerName(Integer id, String userName) {
//        playerRepository.updatePlayerName(id, userName);
//    }
//
//    public void updatePlayerEmail(Integer id, String email) {
//        playerRepository.updatePlayerEmail(id, email);
//    }
//
//    public void updatePlayerPassword(Integer id, String password) {
//        playerRepository.updatePlayerPassword(id, password);
//    }



}

