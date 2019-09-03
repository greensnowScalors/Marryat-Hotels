package com.scalors.hotels.marryat.services.impl;

import com.scalors.hotels.marryat.dto.user.UserDTO;
import com.scalors.hotels.marryat.mapper.UserMapper;
import com.scalors.hotels.marryat.repository.UserRepository;
import com.scalors.hotels.marryat.services.UserService;
import com.scalors.marryat.hotels.entities.users.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDTO getUserById(Long userId) {
        return userMapper.convertToDTO(
                userRepository.findById(userId).orElse(new User()));
    }

    @Override
    public void createUser(UserDTO userDTO) {
        userRepository.save(userMapper.convertToEntity(userDTO));
    }

    @Override
    public void updateUser(UserDTO userDTO) {
        userRepository.save(userMapper.convertToEntity(userDTO));
    }

    @Override
    public void deleteUserById(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<UserDTO> getUserList(Long offset, Long limit) {
        return null;
    }

}
