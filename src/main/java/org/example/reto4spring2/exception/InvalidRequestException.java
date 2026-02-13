package org.example.reto4spring2.exception;

/**
 * Excepción personalizada que se lanza cuando
 * la petición realizada por el cliente no es válida.
 *
 * Se utiliza para indicar errores como:
 * - Datos incorrectos en el body
 * - Parámetros inválidos
 * - Valores fuera de rango
 *
 * Extiende de RuntimeException para que pueda
 * ser gestionada de forma global mediante
 * un @RestControllerAdvice y devolver una
 * respuesta HTTP adecuada (por ejemplo 400 Bad Request).
 */
public class InvalidRequestException extends RuntimeException {

    /**
     * Constructor que recibe el mensaje de error
     * que describe el problema detectado en la petición.
     *
     * @param message descripción del error
     */
    public InvalidRequestException(String message) {
        super(message);
    }
}