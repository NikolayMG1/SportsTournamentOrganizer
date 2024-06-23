package bg.fmi.javaweb.sportstournamentorganizer.controller;


import bg.fmi.javaweb.sportstournamentorganizer.dto.ManagerInputDto;
import bg.fmi.javaweb.sportstournamentorganizer.dto.ManagerOutputDto;
import bg.fmi.javaweb.sportstournamentorganizer.mapper.ManagerMapper;
import bg.fmi.javaweb.sportstournamentorganizer.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @Autowired
    private ManagerMapper managerMapper;

    @PostMapping
    public ResponseEntity<ManagerOutputDto> createManager(@RequestBody ManagerInputDto managerInputDto) {
        managerService.addManager(managerMapper.mapFromInputDto(managerInputDto));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ManagerOutputDto> getManager(@PathVariable Long id) {
        return new ResponseEntity<>(managerMapper.mapToOutputDto(managerService.getManager(id)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ManagerOutputDto> deleteManager(@PathVariable Long id) {
        managerService.removeManager(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
