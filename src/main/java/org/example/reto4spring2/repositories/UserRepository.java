package org.example.reto4spring2.repositories;

import org.example.reto4spring2.entities.UserDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repositorio encargado del acceso a datos
 * relacionados con la entidad UserDB.
 *
 * Extiende de JpaRepository para disponer
 * automáticamente de las operaciones CRUD básicas.
 *
 * Se utiliza principalmente para la autenticación
 * de usuarios mediante su email.
 */
@Repository
public interface UserRepository extends JpaRepository<UserDB, Long> {

    /**
     * Busca un usuario por su email.
     *
     * Devuelve un Optional para manejar correctamente
     * el caso en el que el usuario no exista en la base
     * de datos, evitando así posibles NullPointerException.
     *
     * @param username email del usuario
     * @return Optional con el usuario si existe
     */
    Optional<UserDB> findUserDBByEmail(String username);
}