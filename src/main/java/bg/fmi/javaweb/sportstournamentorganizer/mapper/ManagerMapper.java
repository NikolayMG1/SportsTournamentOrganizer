package bg.fmi.javaweb.sportstournamentorganizer.mapper;


import bg.fmi.javaweb.sportstournamentorganizer.dto.ManagerInputDto;
import bg.fmi.javaweb.sportstournamentorganizer.dto.ManagerOutputDto;
import bg.fmi.javaweb.sportstournamentorganizer.model.Manager;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ManagerMapper {
    @Mapping(source = "username", target = "username")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    Manager mapFromInputDto(ManagerInputDto managerInputDto);

    @Mapping(source = "username", target = "username")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "password", target = "password")
    ManagerOutputDto mapToOutputDto(Manager manager);
}
