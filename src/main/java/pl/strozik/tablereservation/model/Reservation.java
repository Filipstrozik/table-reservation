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
    //referencja na stolik
    @ManyToOne()
    @JoinColumn()
    private Tablee seatNumber;
    private int numberOfSeats;
    private String fullName;
    private String phone;
    private String email;

    public Reservation() {
    }

    public Reservation(Long id, String date, int duration, Tablee seatNumber, int numberOfSeats, String fullName, String phone, String email) {
        this.id = id;
        this.date = date;
        this.duration = duration;
        this.seatNumber = seatNumber;
        this.numberOfSeats = numberOfSeats;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Tablee getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(Tablee seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", duration=" + duration +
                ", seatNumber=" + seatNumber +
                ", numberOfSeats=" + numberOfSeats +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}


