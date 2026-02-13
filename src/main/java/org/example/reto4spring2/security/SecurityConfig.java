package org.example.reto4spring2.security;

import jakarta.servlet.http.HttpServletResponse;
import org.example.reto4spring2.dto.ErrorResponseDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import tools.jackson.databind.ObjectMapper;

/**
 * Configuración de seguridad de la aplicación.
 *
 * Esta clase define las reglas de acceso a los endpoints de la API:
 * - Las peticiones GET quedan abiertas (permitAll).
 * - Las peticiones POST requieren autenticación (authenticated).
 *
 * También se configura autenticación HTTP Basic y un AuthenticationEntryPoint
 * personalizado para devolver un JSON con información del error cuando el
 * usuario no está autenticado o las credenciales son incorrectas.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Define la cadena de filtros de seguridad de Spring Security.
     *
     * Se desactiva CSRF ya que la API está pensada para ser consumida desde
     * herramientas como Postman o clientes externos (no formularios web).
     *
     * Reglas configuradas:
     * - GET /** -> permitido para cualquiera.
     * - POST /** -> requiere autenticación.
     * - Cualquier otra petición -> permitida (por ejemplo PUT/DELETE si no se usan).
     *
     * Se utiliza autenticación HTTP Basic y se aplica un entry point
     * personalizado para devolver errores en JSON.
     *
     * @param http configuración de seguridad proporcionada por Spring
     * @return SecurityFilterChain con la configuración aplicada
     * @throws Exception si ocurre un error al construir la configuración
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.GET, "/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/**").authenticated()
                        .anyRequest().permitAll()
                )
                .httpBasic(basic -> basic.authenticationEntryPoint(customAuthenticationEntryPoint()));

        return http.build();
    }

    /**
     * Entry point personalizado para manejar errores de autenticación.
     *
     * Cuando un usuario intenta acceder a un endpoint protegido sin autenticarse
     * (o con credenciales incorrectas), se devuelve una respuesta JSON con:
     * - error: título del error
     * - message: explicación
     * - errorCode: código HTTP
     *
     * Esto ayuda a que el cliente reciba un mensaje más claro en vez del
     * error por defecto de Spring Security.
     *
     * @return AuthenticationEntryPoint que construye la respuesta JSON de error
     */
    @Bean
    public AuthenticationEntryPoint customAuthenticationEntryPoint() {
        return (request, response, e) -> {
            response.setContentType("application/json");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

            ErrorResponseDTO error = new ErrorResponseDTO(
                    "Usuario no autorizado",
                    "El usuario y contraseña no coinciden",
                    401
            );

            ObjectMapper mapper = new ObjectMapper();
            response.getWriter().write(mapper.writeValueAsString(error));
        };
    }
}