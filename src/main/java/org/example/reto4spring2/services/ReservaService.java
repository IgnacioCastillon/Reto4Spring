package org.example.reto4spring2.services;

import org.example.reto4spring2.entities.Reserva;
import org.example.reto4spring2.repositories.ReservaRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public Reserva save(Reserva reserva) {
        return reservaRepository.save(reserva);
    }
}