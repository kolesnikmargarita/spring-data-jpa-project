package by.kolesnik.course.students.controller;

import by.kolesnik.course.students.dto.ErrorResponse;
import by.kolesnik.course.students.exception.EntityNotFoundException;
import by.kolesnik.course.students.exception.StudentNotFromTheGroupException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(EntityNotFoundException exception) {
        final ErrorResponse response = new ErrorResponse(exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(StudentNotFromTheGroupException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(StudentNotFromTheGroupException exception) {
        final ErrorResponse response = new ErrorResponse(exception.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
