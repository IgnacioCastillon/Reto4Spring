package org.example.reto4spring2.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidad que representa la tabla "users" en la base de datos.
 *
 * Esta clase se utiliza para almacenar los usuarios registrados
 * en el sistema, incluyendo su email y contraseña.
 *
 * Se emplea Lombok para generar automáticamente getters, setters,
 * constructores y métodos auxiliares.
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class UserDB {

    /**
     * Identificador principal del usuario.
     * Se utiliza como clave primaria.
     */
    @Id
    private Long id;

    /**
     * Identificador alternativo del usuario.
     * Puede utilizarse como referencia externa o identificador adicional.
     */
    private String _id;

    /**
     * Email del usuario.
     * Se utiliza como credencial para autenticación.
     */
    private String email;

    /**
     * Contraseña del usuario.
     * Debe almacenarse en formato encriptado por seguridad.
     */
    private String password;
}