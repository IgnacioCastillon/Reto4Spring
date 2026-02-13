package org.example.reto4spring2.repositories;

import org.example.reto4spring2.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio encargado del acceso a datos de la entidad Hotel.
 *
 * Extiende de JpaRepository para disponer automáticamente
 * de las operaciones básicas CRUD sin necesidad de implementarlas.
 *
 * Además, define métodos personalizados utilizando
 * la nomenclatura de Spring Data JPA para generar
 * consultas automáticamente.
 */
@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

    /**
     * Busca un hotel por su nombre exacto.
     *
     * @param name nombre del hotel
     * @return hotel encontrado o null si no existe
     */
    Hotel findHotelByNombre(String name);

    /**
     * Busca un hotel por su identificador.
     *
     * @param id identificador del hotel
     * @return hotel encontrado o null si no existe
     */
    Hotel findHotelById(Long id);

    /**
     * Busca hoteles cuyo nombre contenga el texto indicado,
     * ignorando mayúsculas y minúsculas.
     *
     * @param name texto a buscar
     * @return lista de hoteles coincidentes
     */
    List<Hotel> findByNombreContainingIgnoreCase(String name);

    /**
     * Busca hoteles por ciudad (búsqueda parcial),
     * ignorando mayúsculas y minúsculas.
     *
     * @param ciudad nombre o parte de la ciudad
     * @return lista de hoteles encontrados
     */
    List<Hotel> findByCiudadContainingIgnoreCase(String ciudad);

    /**
     * Devuelve los hoteles cuyo número de estrellas
     * esté dentro del rango indicado.
     *
     * @param estrellasAfter valor mínimo de estrellas
     * @param estrellasBefore valor máximo de estrellas
     * @return lista de hoteles dentro del rango
     */
    List<Hotel> findByEstrellasBetween(Integer estrellasAfter, Integer estrellasBefore);

    /**
     * Devuelve los hoteles cuyo precio por noche
     * esté entre los valores indicados.
     *
     * @param precioNocheAfter precio mínimo
     * @param precioNocheBefore precio máximo
     * @return lista de hoteles dentro del rango de precio
     */
    List<Hotel> findByPrecioNocheBetween(Integer precioNocheAfter, Integer precioNocheBefore);
}