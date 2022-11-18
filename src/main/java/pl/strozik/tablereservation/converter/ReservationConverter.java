package pl.strozik.tablereservation.converter;


import org.springframework.stereotype.Component;
import pl.strozik.tablereservation.dtos.ReservationDto;
import pl.strozik.tablereservation.model.Reservation;

@Component
public class ReservationConverter {

    public ReservationDto entityToDto(Reservation reservation) {
        ReservationDto dto = new ReservationDto();
        dto.setDatum(reservation.getDatum());
        dto.setDuration(reservation.getDuration());
        dto.setTableId(reservation.getSeatNumber().getId());
        dto.setNumberOfSeats(reservation.getNumberOfSeats());
        dto.setFullName(reservation.getFullName());
        dto.setEmail(reservation.getEmail());
        dto.setPhone(reservation.getPhone());
        return dto;
    }

    public Reservation dtoToEntity(ReservationDto reservationDto){
        Reservation reserv = new Reservation();
        reserv.setDatum(reservationDto.getDatum());
        reserv.setDuration(reservationDto.getDuration());
        reserv.setNumberOfSeats(reservationDto.getNumberOfSeats());
        //leave table null
        reserv.setFullName(reservationDto.getFullName());
        reserv.setEmail(reservationDto.getEmail());
        reserv.setPhone(reservationDto.getPhone());
        return reserv;
    }
}

