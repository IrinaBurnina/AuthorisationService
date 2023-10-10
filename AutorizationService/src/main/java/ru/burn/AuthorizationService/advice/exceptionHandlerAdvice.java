package ru.burn.AuthorizationService.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.burn.AuthorizationService.exception.InvalidCredentials;
import ru.burn.AuthorizationService.exception.UnauthorizedUser;

@RestControllerAdvice
public class exceptionHandlerAdvice {
    @ExceptionHandler(InvalidCredentials.class)
    public ResponseEntity<String> invalidCredHandler(InvalidCredentials e) {
        return new ResponseEntity<>("InvalidCredentials in throwException method", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedUser.class)
    public ResponseEntity<String> unAuthorizUserHandler(UnauthorizedUser e) {
        e.printStackTrace();
        return new ResponseEntity<>("UnauthorizedUser in throwException method", HttpStatus.UNAUTHORIZED);
    }
}
