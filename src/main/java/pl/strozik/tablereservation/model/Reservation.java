package pl.strozik.tablereservation.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Reservation implements Serializable {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String date;
    private int duration;
    private int searNumber;
    private int numberOfSeats;
    private String fullName;
    private String phone;
    private String email;

}


