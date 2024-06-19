package bg.fmi.javaweb.sportstournamentorganizer.model;

public class Moderator extends User{
    private Tournament tournamentToCreateAndManage = null;


    public Tournament getTournamentToCreateAndManage() {
        return tournamentToCreateAndManage;
    }

    public void setTournamentToCreateAndManage(Tournament tournamentToCreateAndManage) {
        this.tournamentToCreateAndManage = tournamentToCreateAndManage;
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
