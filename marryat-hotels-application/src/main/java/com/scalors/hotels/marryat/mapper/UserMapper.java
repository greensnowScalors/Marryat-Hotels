package com.scalors.hotels.marryat.mapper;

import com.scalors.hotels.marryat.dto.user.UserDTO;
import com.scalors.hotels.marryat.mapper.common.CommonMapper;
import com.scalors.marryat.hotels.entities.users.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends CommonMapper<UserDTO, User> {
    @Override
    UserDTO convertToDTO(User dto);

    @Override
    User convertToEntity(UserDTO entity);
}
