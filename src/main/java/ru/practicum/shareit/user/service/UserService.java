package ru.practicum.shareit.user.service;

import ru.practicum.shareit.user.dto.UserDto;
import ru.practicum.shareit.user.model.User;

import java.util.List;

public interface UserService {

    List<UserDto> findAll();

    UserDto findById(Integer id);

    UserDto add(UserDto userDto);

    UserDto change(Integer id, UserDto userDto);

    UserDto deleteById(Integer id);

    User findUserOrException(Integer id);
}
