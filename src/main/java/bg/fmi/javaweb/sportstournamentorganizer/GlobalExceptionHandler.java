package bg.fmi.javaweb.sportstournamentorganizer;

import bg.fmi.javaweb.sportstournamentorganizer.exception.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<String> handleAlreadyExistsException(@NotNull AlreadyExistsException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handleNotFoundException(@NotNull NotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

//    @ExceptionHandler(FollowerNotFoundException.class)
//    public ResponseEntity<String> handleNotFoundException(@NotNull FollowerNotFoundException e) {
//        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler(ManagerNotFoundException.class)
//    public ResponseEntity<String> handleManagerNotFoundException(@NotNull ManagerNotFoundException e) {
//        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//    }
//    @ExceptionHandler(ManagerAlreadyExistsException.class)
//    public ResponseEntity<String> handleAlreadyExists(@NotNull ManagerAlreadyExistsException e) {
//        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler(PlayerNotFoundException.class)
//    public ResponseEntity<String> handlePLayerNotFound(@NotNull PlayerNotFoundException e) {
//        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler(TeamNotFoundException.class)
//    public ResponseEntity<String> handleTeamNotFound(@NotNull TeamNotFoundException e) {
//        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler(FollowerAlreadyExistsException.class)
//    public ResponseEntity<String> handleFollowerAlreadyExists(@NotNull FollowerAlreadyExistsException e) {
//        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//    }
}
