package com.charterbooks.my_booking_project.controller;

import com.charterbooks.my_booking_project.model.Reservation;
import com.charterbooks.my_booking_project.model.ReservationRequest;
import com.charterbooks.my_booking_project.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    // Create a new reservation
    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody ReservationRequest request) {
        Reservation reservation = reservationService.createReservation(
                request.getClientName(),
                request.getItemId(),
                request.getReservationDate(),
                request.getTimeSlot()
        );

        if (reservation == null) {
            return ResponseEntity.badRequest().build(); // e.g., item not available
        }

        return ResponseEntity.ok(reservation);
    }

    // Get all reservations
    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    // Cancel a reservation
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelReservation(@PathVariable Long id) {
        reservationService.cancelReservation(id);
        return ResponseEntity.ok().build();
    }
}
