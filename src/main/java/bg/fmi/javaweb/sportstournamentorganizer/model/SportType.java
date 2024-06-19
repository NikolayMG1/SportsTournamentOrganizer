package bg.fmi.javaweb.sportstournamentorganizer.model;

public enum SportType {
    FOOTBALL("Football"),
    BASKETBALL("Basketball"),
    TENNIS("Tennis"),
    VOLLEYBALL("Volleyball"),
    RUGBY("Rugby");

    private String sportType;

    SportType(String sportType) {
        this.sportType = sportType;
    }

    public String getSportType() {
        return sportType;
    }

}
