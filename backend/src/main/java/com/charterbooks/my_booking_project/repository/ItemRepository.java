package com.charterbooks.my_booking_project.repository;

import com.charterbooks.my_booking_project.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository  extends JpaRepository<Item, Long>{
}
