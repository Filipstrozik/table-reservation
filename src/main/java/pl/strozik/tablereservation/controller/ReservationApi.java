package pl.strozik.tablereservation.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.strozik.tablereservation.model.Reservation;
import pl.strozik.tablereservation.service.ReservationService;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationApi {
    private final ReservationService reservationService;

    @Autowired
    public ReservationApi(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping()
    public ResponseEntity<List<Reservation>> getAllReservations(){
        List<Reservation> reservations = this.reservationService.findAllReservations();
        return new ResponseEntity<>(reservations, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation){
        this.reservationService.addReservation(reservation);
        return new ResponseEntity<>(reservation, HttpStatus.CREATED);
    }
}
