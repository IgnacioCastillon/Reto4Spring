package org.example.reto4spring2.controller;

import org.example.reto4spring2.entities.Hotel;
import org.example.reto4spring2.services.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST encargado de gestionar todas las operaciones
 * relacionadas con la entidad Hotel.
 *
 * Este controlador expone diferentes endpoints para:
 * - Consultar hoteles
 * - Filtrar por nombre, ciudad, estrellas o precio
 * - Buscar por ID
 * - Crear nuevos hoteles
 *
 * La ruta base del controlador es /apiv2.
 */
@RestController
@RequestMapping("/apiv2")
public class HotelController {

    private final HotelService hotelService;

    /**
     * Constructor que inyecta el servicio de hoteles.
     *
     * @param hotelService servicio que contiene la lógica de negocio
     */
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    /**
     * Obtiene la lista completa de hoteles.
     *
     * @return lista de todos los hoteles registrados
     */
    @GetMapping("/hotels")
    public List<Hotel> findAll() {
        return hotelService.findAll();
    }

    /**
     * Busca un hotel por su nombre exacto.
     *
     * @param name nombre del hotel
     * @return hotel encontrado o 404 si no existe
     */
    @GetMapping("/hotels/name/{name}")
    public ResponseEntity<Hotel> findByNombre(@PathVariable String name){
        Hotel h = hotelService.findHotelByNombre(name);
        if (h == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(h);
    }

    /**
     * Busca hoteles cuyo nombre contenga el texto indicado.
     *
     * @param name texto a buscar dentro del nombre
     * @return lista de hoteles que coinciden
     */
    @GetMapping("/hotels/nameLike/{name}")
    public ResponseEntity<List<Hotel>> findHotelByNombreLike(@PathVariable String name){
        List<Hotel> lista = hotelService.findHotelByNombreLike(name);
        if (lista == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(lista);
    }

    /**
     * Devuelve los hoteles cuyo número de estrellas
     * esté dentro del rango indicado.
     *
     * @param min número mínimo de estrellas
     * @param max número máximo de estrellas
     * @return lista de hoteles dentro del rango
     */
    @GetMapping("/hotels/estrellasBetween/{min}/{max}")
    public ResponseEntity<List<Hotel>> findByEstrellasBetween(
            @PathVariable Integer min,
            @PathVariable Integer max) {

        List<Hotel> lista = hotelService.findHotelByEstrellasBetween(min, max);
        return ResponseEntity.ok(lista);
    }

    /**
     * Devuelve los hoteles cuyo precio por noche
     * esté entre los valores indicados.
     *
     * @param min precio mínimo
     * @param max precio máximo
     * @return lista de hoteles dentro del rango de precio
     */
    @GetMapping("/hotels/precioBetween/{min}/{max}")
    public ResponseEntity<List<Hotel>> findByPrecioBetween(
            @PathVariable Integer min,
            @PathVariable Integer max) {

        List<Hotel> lista = hotelService.findByPrecioNocheBetween(min, max);
        return ResponseEntity.ok(lista);
    }

    /**
     * Busca hoteles por ciudad (búsqueda parcial).
     *
     * @param ciudad nombre de la ciudad
     * @return lista de hoteles encontrados
     */
    @GetMapping("/hotels/city/{ciudad}")
    public ResponseEntity<List<Hotel>> findHotelByCiudad(@PathVariable String ciudad){
        List<Hotel> lista = hotelService.findHotelByCiudadLike(ciudad);
        return ResponseEntity.ok(lista);
    }

    /**
     * Busca un hotel por su identificador.
     *
     * @param id identificador del hotel
     * @return hotel encontrado o 404 si no existe
     */
    @GetMapping("/hotels/{id}")
    public ResponseEntity<Hotel> findById(@PathVariable Long id){
        Hotel h = hotelService.findHotelById(id);
        if (h == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(h);
    }

    /**
     * Guarda un nuevo hotel en la base de datos.
     *
     * @param hotel objeto Hotel recibido en el cuerpo de la petición
     * @return hotel creado con código 201 CREATED
     */
    @PostMapping("/hotels")
    public ResponseEntity<Hotel> save(@RequestBody Hotel hotel) {
        Hotel guardado = hotelService.save(hotel);

        if (guardado == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(guardado);
    }


    @PutMapping("/hotels/{id}")
    public ResponseEntity<Hotel> update(@PathVariable Long id, @RequestBody Hotel hotel) {

        Hotel existente = hotelService.findHotelById(id);
        if (existente == null) {
            return ResponseEntity.notFound().build();
        }

        existente.setNombre(hotel.getNombre());
        existente.setCiudad(hotel.getCiudad());
        existente.setEstrellas(hotel.getEstrellas());
        existente.setPrecioNoche(hotel.getPrecioNoche());

        Hotel actualizado = hotelService.save(existente);
        return ResponseEntity.ok(actualizado);
    }
}