package com.scalors.hotels.marryat.repository;

import com.scalors.marryat.hotels.entities.rooms.RoomTemplate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomTemplateRepository extends CrudRepository<RoomTemplate, Long> {
}
