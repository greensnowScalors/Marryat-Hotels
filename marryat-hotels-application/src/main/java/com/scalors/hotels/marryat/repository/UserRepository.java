package com.scalors.hotels.marryat.repository;


import com.scalors.marryat.hotels.entities.users.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {


}
