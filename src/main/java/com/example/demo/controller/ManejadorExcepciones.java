package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.model.ErrorResponse;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ManejadorExcepciones {
	
	
	/**
	 * Este método se encarga de realizar las excepciones de validación de datos de entrada,
	 * obtiene los errores de validación, los procesa y devuelve una respuesta HTTP con 
	 * un código de estado 400 y un objeto ErrorResponse que contiene el mensaje de error
	 * general y los errores específicos.
	 * @param ex Es una expeción de Spring
	 * @return devuelve una excepción
	 */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex) {
        List<String> errores = ex.getBindingResult()
                                 .getAllErrors()
                                 .stream()
                                 .map(DefaultMessageSourceResolvable::getDefaultMessage)
                                 .collect(Collectors.toList());

        ErrorResponse respuesta = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Error de validación", errores);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);
    }
}
