package com.example.springpractice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

/**
 * En esta clase capturo de forma global las excepciones de la aplicacion
 * para devolver una respuesta JSON mas clara y controlada.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * En este metodo capturo los errores de validacion y devuelvo
     * un JSON con el codigo, el mensaje y la fecha.
     *
     * @param exception excepcion de validacion
     * @return respuesta de error en formato JSON
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException exception) {

        String message = exception.getBindingResult()
                .getFieldErrors()
                .get(0)
                .getDefaultMessage();

        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                message,
                LocalDateTime.now().toString()
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    /**
     * En este metodo capturo la excepcion cuando una persona no existe.
     *
     * @param exception excepcion controlada
     * @return respuesta de error en formato JSON
     */
    @ExceptionHandler(PersonNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlePersonNotFoundException(PersonNotFoundException exception) {

        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage(),
                LocalDateTime.now().toString()
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    /**
     * En este metodo capturo cualquier otro error no controlado.
     *
     * @param exception excepcion generica
     * @return respuesta de error en formato JSON
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception exception) {

        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Se ha producido un error interno en la aplicacion",
                LocalDateTime.now().toString()
        );

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
