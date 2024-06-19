package bg.fmi.javaweb.sportstournamentorganizer.mapper;

import bg.fmi.javaweb.sportstournamentorganizer.dto.FollowerInputDto;
import bg.fmi.javaweb.sportstournamentorganizer.dto.FollowerOutputDto;
import bg.fmi.javaweb.sportstournamentorganizer.model.Follower;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FollowerMapper {

    @Mapping(source = "userName", target = "userName")
    Follower mapFromInputDto(FollowerInputDto followerInputDto);

    @Mapping(source = "userName", target = "userName")
    FollowerOutputDto mapToOutputDto(Follower follower);

}

