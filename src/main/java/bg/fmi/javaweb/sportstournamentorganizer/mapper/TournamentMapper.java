package bg.fmi.javaweb.sportstournamentorganizer.mapper;

import bg.fmi.javaweb.sportstournamentorganizer.dto.TournamentInputDto;
import bg.fmi.javaweb.sportstournamentorganizer.dto.TournamentOutputDto;
import bg.fmi.javaweb.sportstournamentorganizer.model.Tournament;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TournamentMapper {

    @Mapping(source = "tournamentName", target = "tournamentName")
    @Mapping(source = "tournamentStart", target = "tournamentStart")
    @Mapping(source = "tournamentEnd", target = "tournamentEnd")
    @Mapping(source = "tournamentLocation", target = "tournamentLocation")
    @Mapping(source = "sportType", target = "sportType")
    @Mapping(source = "sportMastery", target = "sportMastery")
    Tournament mapFromInputDto(TournamentInputDto tournamentInputDto);

    @Mapping(source = "tournamentId", target = "tournamentId")
    @Mapping(source = "tournamentName", target = "tournamentName")
    @Mapping(source = "tournamentStart", target = "tournamentStart")
    @Mapping(source = "tournamentEnd", target = "tournamentEnd")
    @Mapping(source = "tournamentLocation", target = "tournamentLocation")
    @Mapping(source = "sportType", target = "sportType")
    @Mapping(source = "sportMastery", target = "sportMastery")
    TournamentOutputDto mapToOutputDto(Tournament tournament);
}
