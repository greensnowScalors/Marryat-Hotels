package com.scalors.hotels.marryat.repository;

import com.scalors.marryat.hotels.entities.hotels.Hotel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends CrudRepository<Hotel, Long> {
}
