package com.charterbooks.my_booking_project.service;

import com.charterbooks.my_booking_project.model.Reservation;
import com.charterbooks.my_booking_project.model.Item;
import com.charterbooks.my_booking_project.repository.ReservationRepository;
import com.charterbooks.my_booking_project.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ItemRepository itemRepository;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation createReservation(String clientName, Long itemId, LocalDate date, String timeSlot) {
        Item item = itemRepository.findById(itemId).orElse(null);
        if(item == null ) throw new IllegalArgumentException("Item not found");
        if(!item.isEnabled()) throw new IllegalStateException("Item is disabled by admin");

        List<Reservation> existing = reservationRepository.findByItemAndReservationDate(item, date);
        boolean conflict = existing.stream().anyMatch(r -> r.getTimeSlot().equals(timeSlot));
        if (conflict) throw new IllegalStateException("Item is already reserved for this time slot");

        Reservation reservation = new Reservation(clientName, date, timeSlot, item);
        return reservationRepository.save(reservation);
    }

    public void cancelReservation(Long reservationId) {
        reservationRepository.findById(reservationId).ifPresent(res -> {
            res.setStatus("Cancelled");
            reservationRepository.save(res);
        });
    }
}
