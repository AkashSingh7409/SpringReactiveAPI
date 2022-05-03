package com.lp.advice;

import com.lp.exception.DataNotFoundException;
import com.lp.exception.EmptyInputException;
import com.lp.exception.ListEmptyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(EmptyInputException.class)
    public ResponseEntity<String> handleEmptyInput(EmptyInputException emptyInputException) {
        return new ResponseEntity<String>("Input field is empty, Please look into it", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ListEmptyException.class)
    public ResponseEntity<String> handleListEmptyException(ListEmptyException listEmptyException) {
        return new ResponseEntity<String>("List is empty, Try again later", HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(DataNotFoundException.class)
    public  ResponseEntity<String> handleDataNotFoundException(DataNotFoundException dataNotFoundException) {
        return new ResponseEntity<String>("Data not found in DB, Please enter valid input", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException noSuchElementException) {
        return new ResponseEntity<String>("No such value present in DB, Please enter valid input", HttpStatus.NOT_FOUND);
    }

}
