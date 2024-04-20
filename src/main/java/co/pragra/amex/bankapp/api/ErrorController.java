package co.pragra.amex.bankapp.api;

import co.pragra.amex.bankapp.exceptions.CustomerDataException;
import co.pragra.amex.bankapp.exceptions.NoDataFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler(CustomerDataException.class)
    public ResponseEntity<ErrorResponse> handleInvalidData(Exception exception){
        ErrorResponse response = new ErrorResponse("ERR01",new Date(), exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(NoDataFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoData(Exception exception){
        ErrorResponse response = new ErrorResponse("ERR04",new Date(), exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleAll(Exception exception){
        ErrorResponse response = new ErrorResponse("ERR05",new Date(), exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(response);
    }

}
