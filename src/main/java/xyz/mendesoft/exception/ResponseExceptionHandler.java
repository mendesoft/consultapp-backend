package xyz.mendesoft.exception;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomerErrorResponse> handelrAllException(Exception ex, WebRequest request){

        CustomerErrorResponse err = new CustomerErrorResponse(LocalDateTime.now(), ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(err, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatusCode status,
                                                                  WebRequest request) {

        String msg = ex.getBindingResult().getFieldErrors().stream().map(
                e -> e.getField().concat(" : ").concat(e.getDefaultMessage().concat(", "))
        ).collect(Collectors.joining());

        CustomerErrorResponse err = new CustomerErrorResponse(LocalDateTime.now(), msg,
                request.getDescription(false));

        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ModelNotFoundException.class)
    public ResponseEntity<CustomerErrorResponse> handlerModelNotFoundException(ModelNotFoundException ex,
                                                                               WebRequest request){

        CustomerErrorResponse err = new CustomerErrorResponse(LocalDateTime.now(), ex.getMessage(),
                request.getDescription(false));

        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }


}
