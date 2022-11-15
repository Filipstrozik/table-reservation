package pl.strozik.tablereservation.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.strozik.tablereservation.model.Reservation;

public interface ReservationRepo extends JpaRepository<Reservation, Long> {
    void deleteReservationById(Long id);
}

