package bg.fmi.javaweb.sportstournamentorganizer.exception;

import bg.fmi.javaweb.sportstournamentorganizer.model.Match;

public class MatchAlreadyExistsException extends AlreadyExistsException{
    public MatchAlreadyExistsException(Long id) {
        super("Match already exists with id: ", id);
    }

    public MatchAlreadyExistsException(String name) {
        super("Match already exists with name: ", name);
    }
}
