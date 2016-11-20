package com.qweewp.java.lambda;

import com.qweewp.java.User;
import com.qweewp.java.UserDto;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Example1 {
    public List<UserDto> convertToDto(List<User> users) {
        return users.stream()
                .map(user -> {
                    UserDto dto = new UserDto();
                    dto.setId(user.getId());
                    dto.setName(user.getName());
                    return dto;
                })
                .collect(toList());
    }
}
