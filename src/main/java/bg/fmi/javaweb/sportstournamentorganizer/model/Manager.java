package bg.fmi.javaweb.sportstournamentorganizer.model;



public class Manager extends User{
    private Team teamToManage = null;

    public Team getTeamToManage() {
        return teamToManage;
    }

    public void setTeamToManage(Team teamToManage) {
        this.teamToManage = teamToManage;
    }



    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }
}
