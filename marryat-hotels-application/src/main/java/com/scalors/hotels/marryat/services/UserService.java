package com.scalors.hotels.marryat.services;

import com.scalors.hotels.marryat.dto.user.UserDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {

    UserDTO getUserById(Long userId);

    void createUser(UserDTO userDTO);

    void updateUser(UserDTO userDTO);

    void deleteUserById(Long userId);

    Page<UserDTO> getUserList(Long offset, Long limit);

}
