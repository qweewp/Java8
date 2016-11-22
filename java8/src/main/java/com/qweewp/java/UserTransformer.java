package com.qweewp.java;

import java.util.Optional;

public class UserTransformer {

    public static UserDto convertToUserDto(User user) {
        Optional.ofNullable(user).orElseThrow(() -> new IllegalArgumentException("User is incorrect --> " + user));
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        return userDto;
    }

}

