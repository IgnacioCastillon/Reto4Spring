package org.example.reto4spring2.controller;

import org.example.reto4spring2.entities.Hotel;
import org.example.reto4spring2.entities.Reserva;
import org.example.reto4spring2.services.HotelService;
import org.example.reto4spring2.services.ReservaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apiv2")
public class ReservaController {

    private final ReservaService reservaService;
    private final HotelService hotelService;

    public ReservaController(ReservaService reservaService, HotelService hotelService) {
        this.reservaService = reservaService;
        this.hotelService = hotelService;
    }

    @PostMapping("/reservas")
    public ResponseEntity<Reserva> save(@RequestBody Reserva reserva) {

        if (reserva.getHotel() == null || reserva.getHotel().getId() == null) {
            return ResponseEntity.badRequest().build();
        }

        Hotel hotel = hotelService.findHotelById(reserva.getHotel().getId());
        if (hotel == null) {
            return ResponseEntity.notFound().build();
        }

        reserva.setHotel(hotel);

        Reserva guardada = reservaService.save(reserva);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardada);
    }
}