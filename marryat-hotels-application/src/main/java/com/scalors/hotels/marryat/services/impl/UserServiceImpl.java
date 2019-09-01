package com.scalors.hotels.marryat.services.impl;

import com.scalors.hotels.marryat.dto.user.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.scalors.hotels.marryat.mapper.UserMapper;
import com.scalors.hotels.marryat.repository.UserRepository;
import com.scalors.hotels.marryat.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    @Transactional
    public UserDTO getUserById(Long userId) {
        return userMapper.convert(
                userRepository.getOne(userId)
        );
    }

    @Override
    @Transactional
    public UserDTO saveUser(UserDTO userDTO) {
        return null;
    }

    @Override
    @Transactional
    public UserDTO updateUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public UserDTO deleteUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public Page<UserDTO> getUserList() {
        return null;
    }

}
