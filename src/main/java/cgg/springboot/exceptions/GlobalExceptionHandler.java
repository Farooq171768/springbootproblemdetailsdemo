package cgg.springboot.exceptions;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    //handler for AgeNOtValidException
    @ExceptionHandler(AgeNotValidException.class)
    public ResponseEntity<ProblemDetail> handleAgeNotValidException(AgeNotValidException e){

         ProblemDetail problemDetail=ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR);
            problemDetail.setTitle(e.getMessage());
            problemDetail.setDetail("Age is not valid to cast vote");
            problemDetail.setType(URI.create("http://localhost/errors"));
            problemDetail.setProperty("host", "localhost");
            problemDetail.setProperty("port", 8080);

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(problemDetail);
            
    }
}
