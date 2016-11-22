package com.qweewp.java.lambda;


import com.qweewp.java.User;
import com.qweewp.java.UserDto;
import com.qweewp.java.UserTransformer;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class Example1 {

    /**
     * Change:  Create {@link UserTransformer} class which helps to convert @{@link User} entity to another entity.
     *          In this case convert User to UserDto.
     */
    public List<UserDto> convertToDto(List<User> users) {
        return users.stream().map(UserTransformer::convertToUserDto).collect(toList());
    }
}
