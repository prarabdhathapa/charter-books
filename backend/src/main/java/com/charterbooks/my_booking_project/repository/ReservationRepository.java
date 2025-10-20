package com.charterbooks.my_booking_project.repository;

import com.charterbooks.my_booking_project.model.Reservation;
import com.charterbooks.my_booking_project.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long>{

    List<Reservation> findByItemAndReservationDate(Item item, LocalDate date);

    List<Reservation> findByClientName(String clientName);
}
