package org.example.reto4spring2.services;

import org.example.reto4spring2.entities.Hotel;
import org.example.reto4spring2.repositories.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio encargado de contener la lógica de negocio
 * relacionada con la entidad Hotel.
 *
 * Actúa como capa intermedia entre el Controller y el Repository,
 * separando la lógica de acceso a datos de la lógica de presentación.
 *
 * Aquí se gestionan las operaciones CRUD y las consultas
 * personalizadas sobre los hoteles.
 */
@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    /**
     * Constructor que inyecta el repositorio de hoteles.
     *
     * @param hotelRepository repositorio encargado del acceso a datos
     */
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    /**
     * Devuelve todos los hoteles almacenados en la base de datos.
     *
     * @return lista completa de hoteles
     */
    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    /**
     * Busca un hotel por su ID utilizando el método
     * proporcionado por JpaRepository.
     *
     * @param id identificador del hotel
     * @return Optional con el hotel si existe
     */
    public Optional<Hotel> findById(Long id) {
        return hotelRepository.findById(id);
    }

    /**
     * Guarda un hotel en la base de datos.
     *
     * Si el hotel no tiene ID se crea uno nuevo,
     * si lo tiene se actualiza.
     *
     * @param hotel objeto Hotel a guardar
     * @return hotel guardado
     */
    public Hotel save(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    /**
     * Busca un hotel por su nombre exacto.
     *
     * @param name nombre del hotel
     * @return hotel encontrado o null si no existe
     */
    public Hotel findHotelByNombre(String name) {
        return hotelRepository.findHotelByNombre(name);
    }

    /**
     * Busca un hotel por su ID mediante método personalizado.
     *
     * @param id identificador del hotel
     * @return hotel encontrado o null si no existe
     */
    public Hotel findHotelById(Long id) {
        return hotelRepository.findHotelById(id);
    }

    /**
     * Busca hoteles cuyo nombre contenga el texto indicado,
     * ignorando mayúsculas y minúsculas.
     *
     * @param name texto a buscar
     * @return lista de hoteles coincidentes
     */
    public List<Hotel> findHotelByNombreLike(String name) {
        return hotelRepository.findByNombreContainingIgnoreCase(name);
    }

    /**
     * Busca hoteles por ciudad (búsqueda parcial),
     * ignorando mayúsculas y minúsculas.
     *
     * @param ciudad nombre o parte de la ciudad
     * @return lista de hoteles encontrados
     */
    public List<Hotel> findHotelByCiudadLike(String ciudad) {
        return hotelRepository.findByCiudadContainingIgnoreCase(ciudad);
    }

    /**
     * Devuelve los hoteles cuyo número de estrellas
     * esté dentro del rango indicado.
     *
     * @param estrellasAfter valor mínimo de estrellas
     * @param estrellasBefore valor máximo de estrellas
     * @return lista de hoteles dentro del rango
     */
    public List<Hotel> findHotelByEstrellasBetween(Integer estrellasAfter, Integer estrellasBefore) {
        return hotelRepository.findByEstrellasBetween(estrellasAfter, estrellasBefore);
    }

    /**
     * Devuelve los hoteles cuyo precio por noche
     * esté dentro del rango indicado.
     *
     * @param precioNocheAfter precio mínimo
     * @param precioNocheBefore precio máximo
     * @return lista de hoteles dentro del rango
     */
    public List<Hotel> findByPrecioNocheBetween(Integer precioNocheAfter, Integer precioNocheBefore) {
        return hotelRepository.findByPrecioNocheBetween(precioNocheAfter, precioNocheBefore);
    }
}