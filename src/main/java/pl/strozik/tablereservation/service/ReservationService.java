package pl.strozik.tablereservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.strozik.tablereservation.model.Reservation;
import pl.strozik.tablereservation.repo.ReservationRepo;

import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepo reservationRepository;

    @Autowired
    public ReservationService(ReservationRepo reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> findAllReservations(){
        return this.reservationRepository.findAll();
    }

    public Reservation addReservation(Reservation reservation){
        return this.reservationRepository.save(reservation);
    }

    public Reservation updateReservation(Reservation reservation){
        return this.reservationRepository.save(reservation);
    }

    public void deleteResevation(Long id){
        this.reservationRepository.deleteReservationById(id);
    }

}
