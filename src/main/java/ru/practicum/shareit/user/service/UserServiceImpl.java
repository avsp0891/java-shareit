package ru.practicum.shareit.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.practicum.shareit.user.dto.UserDto;
import ru.practicum.shareit.user.dto.UserMapper;
import ru.practicum.shareit.user.exceptions.UserNotFoundException;
import ru.practicum.shareit.user.model.User;
import ru.practicum.shareit.user.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public List<UserDto> findAll() {
        log.info("Вернуть список всех пользователей.");
        return UserMapper.toUserDtoList(repository.findAll());
    }

    @Override
    public UserDto findById(Integer id) {
        log.info("Найти пользователя по id {}.", id);
        User user = findUserOrException(id);
        return UserMapper.toUserDto(user);
    }

    @Override
    public UserDto add(UserDto userDto) {
        log.info("Добавление пользователя c id {}.", userDto.getId());
        User user = repository.save(UserMapper.toUser(userDto));
        return UserMapper.toUserDto(user);
    }

    @Override
    public UserDto change(Integer id, UserDto userDto) {
        log.info("Изменение пользователя c id {}.", id);
        User oldUser = findUserOrException(id);
        User newUser = UserMapper.toUser(userDto);
        if (newUser.getName() != null) {
            oldUser.setName(newUser.getName());
        }
        if (newUser.getEmail() != null) {
            oldUser.setEmail(newUser.getEmail());
        }
        return UserMapper.toUserDto(repository.save(oldUser));
    }

    @Override
    public UserDto deleteById(Integer id) {
        log.info("Удаление пользователя c id {}.", id);
        UserDto user = findById(id);
        repository.deleteById(id);
        return user;
    }

    @Override
    public User findUserOrException(Integer id) {
        Optional<User> user = repository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("Пользователь с id " + id + " не найден.");
        } else {
            return user.get();
        }
    }
}
