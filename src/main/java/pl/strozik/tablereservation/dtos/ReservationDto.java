package pl.strozik.tablereservation.dtos;

import lombok.Data;

@Data
public class ReservationDto {
    private String datum;
    private int duration;
    private Long tableId;
    private int numberOfSeats;
    private String fullName;
    private String phone;
    private String email;
}
