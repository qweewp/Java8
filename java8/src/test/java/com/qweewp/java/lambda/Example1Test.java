package com.qweewp.java.lambda;

import com.qweewp.java.User;
import com.qweewp.java.UserDto;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Example1Test {

    private Example1 example1 = new Example1();

    @Test
    public void shouldConvertUserToDto() {
        int firstIndex = 0;
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Andrii"));

        List<UserDto> actualUsersDto = example1.convertToDto(users);

        assertTrue(actualUsersDto.size() == users.size());
        assertEquals(actualUsersDto.get(firstIndex).getName(), (users.get(firstIndex).getName()));
        assertEquals(actualUsersDto.get(firstIndex).getId(), (users.get(firstIndex).getId()));
    }
}
