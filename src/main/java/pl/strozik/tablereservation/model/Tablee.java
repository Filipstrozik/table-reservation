package pl.strozik.tablereservation.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Tablee implements Serializable {
    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long minNumberOfSeats;
    private Long maxNumberOfSeats;

    public Tablee() {
    }

    public Tablee(Long id, Long minNumberOfSeats, Long maxNumberOfSeats) {
        this.id = id;
        this.minNumberOfSeats = minNumberOfSeats;
        this.maxNumberOfSeats = maxNumberOfSeats;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMinNumberOfSeats() {
        return minNumberOfSeats;
    }

    public void setMinNumberOfSeats(Long minNumberOfSeats) {
        this.minNumberOfSeats = minNumberOfSeats;
    }

    public Long getMaxNumberOfSeats() {
        return maxNumberOfSeats;
    }

    public void setMaxNumberOfSeats(Long maxNumberOfSeats) {
        this.maxNumberOfSeats = maxNumberOfSeats;
    }

    @Override
    public String toString() {
        return "Table{" +
                "id=" + id +
                ", minNumberOfSeats=" + minNumberOfSeats +
                ", maxNumberOfSeats=" + maxNumberOfSeats +
                '}';
    }
}
