package com.charterbooks.my_booking_project.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String clientName;
    private LocalDate reservationDate;
    private String timeSlot;
    private String status = "Reserved";

    @ManyToOne      //multiple reservations can link to the same item
    @JoinColumn(name ="item_id")
    private Item item;

    public Reservation() {}

    public Reservation(String clientName, LocalDate reservationDate, String timeSlot, Item item){
        this.clientName = clientName;
        this.reservationDate = reservationDate;
        this.timeSlot = timeSlot;
        this.item = item;
        this.status = "Reserved";
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getClientName() { return clientName; }
    public void setClientName(String clientName) { this.clientName = clientName; }

    public LocalDate getReservationDate() { return reservationDate; }
    public void setReservationDate(LocalDate reservationDate) { this.reservationDate = reservationDate; }

    public String getTimeSlot() { return timeSlot; }
    public void setTimeSlot(String timeSlot) { this.timeSlot = timeSlot; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Item getItem() { return item; }
    public void setItem(Item item) { this.item = item; }
}
