package org.example.reto4spring2.entities;

import jakarta.persistence.*;
import lombok.*;

/**
 * Entidad que representa la tabla "hoteles" en la base de datos.
 *
 * Esta clase se mapea mediante JPA y contiene los atributos
 * principales de un hotel, como nombre, ciudad, número de estrellas
 * y precio por noche.
 *
 * Se utilizan anotaciones de Lombok para generar automáticamente
 * getters, setters, constructores y métodos como toString, equals y hashCode.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hoteles")
public class Hotel {

    /**
     * Identificador único del hotel.
     * Se genera automáticamente con estrategia IDENTITY.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del hotel.
     */
    private String nombre;

    /**
     * Ciudad donde se encuentra el hotel.
     */
    private String ciudad;

    /**
     * Número de estrellas del hotel.
     */
    private Integer estrellas;

    /**
     * Precio por noche del hotel.
     * Se mapea con la columna "precio_noche" en la base de datos.
     */
    @Column(name = "precio_noche")
    private Double precioNoche;
}