package bg.fmi.javaweb.sportstournamentorganizer.mapper;


import bg.fmi.javaweb.sportstournamentorganizer.dto.ModeratorInputDto;
import bg.fmi.javaweb.sportstournamentorganizer.dto.ModeratorOutputDto;
import bg.fmi.javaweb.sportstournamentorganizer.model.Moderator;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ModeratorMapper {
    @Mapping(source = "userName", target = "userName")
    Moderator mapFromInputDto(ModeratorInputDto moderatorInputDto);

    @Mapping(source = "userName", target = "userName")
    ModeratorOutputDto mapToOutputDto(Moderator moderator);
}
