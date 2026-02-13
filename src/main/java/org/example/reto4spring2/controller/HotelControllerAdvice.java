package org.example.reto4spring2.controller;

import org.example.reto4spring2.dto.ErrorResponseDTO;
import org.example.reto4spring2.exception.HotelNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Clase encargada de gestionar las excepciones globales
 * relacionadas con la entidad Hotel.
 *
 * Se utiliza @RestControllerAdvice para interceptar
 * excepciones lanzadas desde los controladores y devolver
 * una respuesta personalizada en formato JSON.
 *
 * En este caso se controla la excepción HotelNotFoundException,
 * devolviendo un código 404 con un cuerpo de error estructurado.
 */
@RestControllerAdvice
class HotelControllerAdvice {

    /**
     * Maneja la excepción HotelNotFoundException.
     *
     * Cuando no se encuentra un hotel en la base de datos,
     * se construye un objeto ErrorResponseDTO con información
     * detallada del error y se devuelve con estado 404.
     *
     * @param ex excepción lanzada cuando el hotel no existe
     * @return ResponseEntity con información del error en formato JSON
     */
    @ExceptionHandler(HotelNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleHotelNotFound(HotelNotFoundException ex) {

        ErrorResponseDTO err = new ErrorResponseDTO(
                "Hotel not found",
                "El hotel solicitado no existe",
                404
        );

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(err);
    }
}