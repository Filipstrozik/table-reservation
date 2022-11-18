package pl.strozik.tablereservation.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.strozik.tablereservation.converter.ReservationConverter;
import pl.strozik.tablereservation.dtos.ReservationDto;
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
    public ResponseEntity<Long> createReservation(@RequestBody ReservationDto reservationDto){
        Reservation createdReservatoion = this.reservationService.addReservation(reservationDto);
        return new ResponseEntity<>(createdReservatoion.getId(), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> cancelReservation(@PathVariable("id") Long id){
        Reservation foundReservation = this.reservationService.findReservationById(id);
        if(foundReservation == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        //TODO if its too late user cannot cancel the reservation.
        String code = String.valueOf(Math.floor(Math.random() * 100000));
        foundReservation.setCancelationCode(code);
        this.reservationService.updateReservation(foundReservation);
        return new ResponseEntity<>(code, HttpStatus.FOUND);
    }

    @DeleteMapping("{id}/{code}")
    public ResponseEntity<String> deleteReservation(@PathVariable("id") Long id, @PathVariable("code") String code){
        Reservation foundReservation = this.reservationService.findReservationById(id);
        if(foundReservation == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        System.out.println(foundReservation.getCancelationCode());
        if(code.equals(foundReservation.getCancelationCode())){
            System.out.println("the same codes");
            this.reservationService.deleteResevation(id);
            return new ResponseEntity<>("deleted reservation", HttpStatus.OK);
        }
        return new ResponseEntity<>("incorrect cancelation code", HttpStatus.NOT_MODIFIED);
    }
}
