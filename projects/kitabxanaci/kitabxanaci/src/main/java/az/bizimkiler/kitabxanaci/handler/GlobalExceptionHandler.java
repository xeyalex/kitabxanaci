package az.bizimkiler.kitabxanaci.handler;

import az.bizimkiler.kitabxanaci.dto.ErrorResponse;
import az.bizimkiler.kitabxanaci.exception.KitabNotFoundException;
import az.bizimkiler.kitabxanaci.exception.KitabxanaciNotFoundException;
import az.bizimkiler.kitabxanaci.exception.TelebeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(KitabNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleBookNotFoundException(KitabNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TelebeNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleStudentNotFoundException(TelebeNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(KitabxanaciNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleLibrarianNotFoundException(KitabxanaciNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse("Sistemdə gözlənilməyən bir səhv baş verdi: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
