package bg.fmi.javaweb.sportstournamentorganizer.repository.sequence;

public class MatchSequence {
    private static Integer current = 1;

    public static Integer getNext() {
        return current++;
    }
}
