package org.example.reto4spring2.security;

import org.example.reto4spring2.entities.UserDB;
import org.example.reto4spring2.repositories.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Servicio encargado de integrar los usuarios almacenados
 * en base de datos con Spring Security.
 *
 * Implementa la interfaz UserDetailsService, que es utilizada
 * por Spring Security durante el proceso de autenticación.
 *
 * Cuando un usuario intenta autenticarse, Spring llama al método
 * loadUserByUsername() para obtener sus credenciales desde la base
 * de datos y construir un objeto UserDetails.
 */
@Service
class AppUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    /**
     * Constructor que inyecta el repositorio de usuarios.
     *
     * @param userRepository repositorio que permite acceder
     *                       a los usuarios almacenados en BD
     */
    public AppUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Método que carga un usuario a partir de su email.
     *
     * Spring Security utiliza este método automáticamente
     * durante el proceso de login.
     *
     * Si el usuario no existe, se lanza una excepción
     * UsernameNotFoundException.
     *
     * Si existe, se construye un objeto UserDetails con:
     * - username (email)
     * - password
     * - rol asignado
     *
     * @param username email introducido en la autenticación
     * @return objeto UserDetails con la información del usuario
     * @throws UsernameNotFoundException si el usuario no existe
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserDB> currentUser = userRepository.findUserDBByEmail(username);

        if (currentUser.isEmpty()) {
            throw new UsernameNotFoundException("Username not found : " + username);
        }

        UserDetails user = User.withUsername(username)
                .password("{noop}" + currentUser.get().getPassword())
                .roles("ADMIN")
                .build();

        return user;
    }
}