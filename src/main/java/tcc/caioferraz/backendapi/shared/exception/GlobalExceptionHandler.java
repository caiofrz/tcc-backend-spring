package tcc.caioferraz.backendapi.shared.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tcc.caioferraz.backendapi.domain.rooms.exceptions.RoomAlreadyCreatedException;
import tcc.caioferraz.backendapi.domain.rooms.exceptions.RoomNotFoundException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(RoomAlreadyCreatedException.class)
  public ResponseEntity<ErrorResponse> handleException(RoomAlreadyCreatedException ex,
                                                       HttpServletRequest request) {
    return response(LocalDateTime.now(), HttpStatus.CONFLICT,
            ex.getMessage(), HttpStatus.CONFLICT.getReasonPhrase(), request);
  }

  @ExceptionHandler(RoomNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleException(RoomNotFoundException ex,
                                                       HttpServletRequest request) {
    return response(LocalDateTime.now(), HttpStatus.NOT_FOUND,
            ex.getMessage(), HttpStatus.NOT_FOUND.getReasonPhrase(), request);
  }

  @ExceptionHandler(IllegalArgumentException.class)
  public ResponseEntity<ErrorResponse> handleException(IllegalArgumentException ex,
                                                       HttpServletRequest request) {
    return response(LocalDateTime.now(), HttpStatus.BAD_REQUEST,
            ex.getMessage(), HttpStatus.BAD_REQUEST.getReasonPhrase(), request);
  }

  @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
  public ResponseEntity<ErrorResponse> handleException(HttpRequestMethodNotSupportedException ex,
                                                       HttpServletRequest request) {
    return response(LocalDateTime.now(), HttpStatus.METHOD_NOT_ALLOWED,
            ex.getMessage(), HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase(), request);
  }

  @ExceptionHandler(DataIntegrityViolationException.class)
  public ResponseEntity<ErrorResponse> handleException(DataIntegrityViolationException ex,
                                                       HttpServletRequest request) {
    return response(LocalDateTime.now(), HttpStatus.CONFLICT,
            ex.getMessage(), HttpStatus.CONFLICT.getReasonPhrase(), request);
  }

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<ErrorResponse> handleException(ConstraintViolationException ex,
                                                       HttpServletRequest request) {
    return response(LocalDateTime.now(), HttpStatus.BAD_REQUEST,
            ex.getMessage(), HttpStatus.BAD_REQUEST.getReasonPhrase(), request);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorResponse> handleException(MethodArgumentNotValidException ex,
                                                       HttpServletRequest request) {
    Map<String, String> errors = new HashMap<>();
    for (FieldError error : ex.getBindingResult().getFieldErrors()) {
      errors.put(error.getField(), error.getDefaultMessage());
    }
    return response(LocalDateTime.now(), HttpStatus.BAD_REQUEST,
            errors.toString(), HttpStatus.BAD_REQUEST.getReasonPhrase(), request);
  }

  private ResponseEntity<ErrorResponse> response(final LocalDateTime timestamp,
                                                 final HttpStatus status,
                                                 final String error,
                                                 final String message,
                                                 final HttpServletRequest request) {
    return ResponseEntity
            .status(status)
            .body(new ErrorResponse(timestamp, status.value(), message, error, request.getRequestURI()));
  }
}
