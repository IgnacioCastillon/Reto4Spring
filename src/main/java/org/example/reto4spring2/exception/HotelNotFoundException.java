package org.example.reto4spring2.exception;

/**
 * Excepción personalizada que se lanza cuando
 * no se encuentra un hotel en la base de datos.
 *
 * Extiende de RuntimeException para no obligar
 * a capturarla de forma explícita y permitir que
 * sea gestionada globalmente mediante
 * @RestControllerAdvice.
 *
 * Se utiliza junto con HotelControllerAdvice
 * para devolver una respuesta JSON personalizada
 * con código HTTP 404.
 */
public class HotelNotFoundException extends RuntimeException {

    /**
     * Constructor que recibe el mensaje de error.
     *
     * @param message descripción del error producido
     */
    public HotelNotFoundException(String message) {
        super(message);
    }
}