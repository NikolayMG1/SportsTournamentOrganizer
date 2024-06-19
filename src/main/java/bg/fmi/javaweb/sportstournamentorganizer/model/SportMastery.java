package bg.fmi.javaweb.sportstournamentorganizer.model;

public enum SportMastery {
    AMATEUR("Amateur"),
    PROFESSIONAL("Professional"),
    YOUTH("Youth"),
    KIDS("Kids");

    private String sportMastery;

    SportMastery(String sportMastery) {
        this.sportMastery = sportMastery;
    }

    public String getSportMastery() {
        return sportMastery;
    }
}
