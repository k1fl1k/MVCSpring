package com.k1fl1k.mvcarchitecture.mapper;

import com.k1fl1k.mvcarchitecture.dto.UserDTO;
import com.k1fl1k.mvcarchitecture.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toDTO(User user);
    User toEntity(UserDTO userDTO);
}
