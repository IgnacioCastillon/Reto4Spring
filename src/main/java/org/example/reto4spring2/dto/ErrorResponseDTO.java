package org.example.reto4spring2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * DTO utilizado para representar las respuestas de error
 * personalizadas en la API.
 *
 * Esta clase se usa cuando ocurre una excepción controlada,
 * como por ejemplo cuando no se encuentra un hotel.
 *
 * Se devuelve como respuesta en formato JSON al cliente,
 * incluyendo información clara sobre el error producido.
 */
@AllArgsConstructor
@Getter
public class ErrorResponseDTO {

    /**
     * Tipo de error producido.
     * Ejemplo: "Hotel not found"
     */
    private String error;

    /**
     * Mensaje descriptivo del error.
     * Explica de forma más detallada qué ha ocurrido.
     */
    private String message;

    /**
     * Código de error asociado.
     * Normalmente coincide con el código HTTP (ej: 404).
     */
    Integer errorCode;
}