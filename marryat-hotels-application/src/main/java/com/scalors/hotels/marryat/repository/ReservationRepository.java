package com.scalors.hotels.marryat.repository;

import com.scalors.marryat.hotels.entities.rooms.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {


}
