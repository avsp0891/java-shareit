package ru.practicum.shareit.user.dto;

import ru.practicum.shareit.user.model.User;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static UserDto toUserDto(@NotNull User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }

    public static User toUser(@NotNull UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getName(),
                userDto.getEmail()
        );
    }

    public static List<UserDto> toUserDtoList(List<User> users) {
        return users.stream().map(UserMapper::toUserDto).collect(Collectors.toList());
    }
}
