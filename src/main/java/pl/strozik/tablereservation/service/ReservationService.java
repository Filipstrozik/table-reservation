package pl.strozik.tablereservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.strozik.tablereservation.converter.ReservationConverter;
import pl.strozik.tablereservation.dtos.ReservationDto;
import pl.strozik.tablereservation.model.Reservation;
import pl.strozik.tablereservation.model.Tablee;
import pl.strozik.tablereservation.repo.ReservationRepo;
import pl.strozik.tablereservation.repo.TableRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReservationService {
    private final ReservationRepo reservationRepository;
    private final TableRepo tableRepo;
    private final ReservationConverter reservationConverter;

    @Autowired
    public ReservationService(ReservationRepo reservationRepository, TableRepo tableRepo, ReservationConverter reservationConverter) {
        this.reservationRepository = reservationRepository;
        this.tableRepo = tableRepo;
        this.reservationConverter = reservationConverter;
    }


    public List<Reservation> findAllReservations(){
        return this.reservationRepository.findAll();
    }

    public Reservation addReservation(ReservationDto reservationDto){
        Optional<Tablee> tableeById = this.tableRepo.findTableeById(reservationDto.getTableId());
        Reservation newReservation = this.reservationConverter.dtoToEntity(reservationDto);
        newReservation.setSeatNumber(tableeById.get());
        return this.reservationRepository.save(newReservation);
    }

    public Reservation updateReservation(Reservation reservation){
        return this.reservationRepository.save(reservation);
    }

    public void deleteResevation(Long id){
        this.reservationRepository.deleteReservationById(id);
    }

    public Reservation findReservationById(Long id) {
        return this.reservationRepository.findReservationById(id);
    }
}
