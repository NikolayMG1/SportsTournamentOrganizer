package bg.fmi.javaweb.sportstournamentorganizer.mapper;

import bg.fmi.javaweb.sportstournamentorganizer.dto.MatchInputDto;
import bg.fmi.javaweb.sportstournamentorganizer.dto.MatchOutputDto;
import bg.fmi.javaweb.sportstournamentorganizer.model.*;
import org.jetbrains.annotations.NotNull;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MatchMapper {

    default Match mapFromInputDto(MatchInputDto matchInputDto, SportType sportType, Team host, Team guest) {
        return switch(sportType) {
            case FOOTBALL -> mapToFootballMatch(matchInputDto, host, guest);
            case BASKETBALL -> mapToBasketballMatch(matchInputDto, host, guest);
            case TENNIS -> mapToTennisMatch(matchInputDto, host, guest);
            case VOLLEYBALL -> mapToVolleyballMatch(matchInputDto, host, guest);
        };
    }

    @Mapping(source = "matchId", target = "matchId")
    @Mapping(source = "matchLocation", target = "matchLocation")
    @Mapping(source = "sportMastery", target = "sportMastery")
    @Mapping(source = "matchStartTime", target = "matchStartTime")
    @Mapping(source = "matchEndTime", target = "matchEndTime")
    @Mapping(source = "host", target = "host")
    @Mapping(source = "guest", target = "guest")
    @Mapping(source = "matchStatus", target = "matchStatus")
    default MatchOutputDto mapToOutputDto(Match match) {
        MatchOutputDto matchOutputDto = new MatchOutputDto();

        matchOutputDto.setMatchId(match.getMatchId());
        matchOutputDto.setMatchLocation(match.getMatchLocation());
        matchOutputDto.setSportMastery(match.getSportMastery());
        matchOutputDto.setMatchStartTime(match.getMatchStartTime());
        matchOutputDto.setMatchEndTime(match.getMatchEndTime());
        matchOutputDto.setHost(match.getHost().getTeamName());
        matchOutputDto.setGuest(match.getGuest().getTeamName());
        matchOutputDto.setMatchStatus(match.getMatchStatus());

        return matchOutputDto;
    }

    @NotNull
    private FootballMatch mapToFootballMatch(@NotNull MatchInputDto matchInputDto, Team host, Team guest) {
        FootballMatch footballMatch = new FootballMatch();
        mapFields(footballMatch, matchInputDto, host, guest);

        return footballMatch;
    }

    @NotNull
    private BasketballMatch mapToBasketballMatch(@NotNull MatchInputDto matchInputDto, Team host, Team guest) {
        BasketballMatch basketballMatch = new BasketballMatch();

        mapFields(basketballMatch, matchInputDto, host, guest);
        return basketballMatch;
    }

    @NotNull
    private TennisMatch mapToTennisMatch(@NotNull MatchInputDto matchInputDto, Team host, Team guest) {
        TennisMatch tennisMatch = new TennisMatch();

        mapFields(tennisMatch, matchInputDto, host, guest);
        return tennisMatch;
    }

    @NotNull
    private VolleyballMatch mapToVolleyballMatch(@NotNull MatchInputDto matchInputDto, Team host, Team guest) {
        VolleyballMatch volleyballMatch = new VolleyballMatch();

        mapFields(volleyballMatch, matchInputDto, host, guest);
        return volleyballMatch;
    }

    private void mapFields(@NotNull Match match, @NotNull MatchInputDto matchInputDto, Team host, Team guest) {
        match.setMatchLocation(matchInputDto.getMatchLocation());
        match.setMatchStartTime(matchInputDto.getMatchStartTime());
        match.setMatchEndTime(matchInputDto.getMatchEndTime());
        match.setHost(host);
        match.setGuest(guest);
    }




}
