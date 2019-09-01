package com.scalors.hotels.marryat.services;

import com.scalors.hotels.marryat.dto.user.UserDTO;
import org.springframework.data.domain.Page;

/**
 * Interface UserService.
 *
 * @author Alexandr Nezhelskyi
 * @version 1.0.
 * 18.04.18
 */
public interface UserService {

    UserDTO getUserById(Long userId);

    UserDTO saveUser(UserDTO userDTO);

    UserDTO updateUser(UserDTO userDTO);

    UserDTO deleteUser(UserDTO userDTO);

    Page<UserDTO> getUserList();

}
