package ru.practicum.shareit.user.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.practicum.shareit.user.dto.UserDto;
import ru.practicum.shareit.user.dto.UserMapper;
import ru.practicum.shareit.user.exceptions.UserNotFoundException;
import ru.practicum.shareit.user.exceptions.UserValidationException;
import ru.practicum.shareit.user.model.User;
import ru.practicum.shareit.user.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public List<UserDto> findAll() {
        List<UserDto> list = new ArrayList<>();
        for (User user: userRepository.findAll()) {
            list.add(UserMapper.toUserDto(user));
        }
        return list;
    }

    @Override
    public UserDto findById(Integer id) {
        if (!userRepository.getRepository().containsKey(id)) {
            log.warn("Пользователь с идентификатором {} не найден.", id);
            throw new UserNotFoundException("Пользователь с id " + id + " не найден");
        }
        return UserMapper.toUserDto(userRepository.findById(id));
    }

    @Override
    public UserDto add(User user) {
        validateEmail(user);
        return UserMapper.toUserDto(userRepository.add(user));
    }

    @Override
    public UserDto change(Integer id, User user) {
        if (!userRepository.getRepository().containsKey(id)) {
            log.warn("Пользователь с идентификатором {} не найден.", id);
            throw new UserNotFoundException("Пользователь с id " + id + " не найден");
        }
        validateEmail(user);
        user.setId(id);
        User oldUser = userRepository.getRepository().get(id);
        if (user.getName() == null){
            user.setName(oldUser.getName());
        }
        if (user.getEmail() == null){
            user.setEmail(oldUser.getEmail());
        }
        return UserMapper.toUserDto(userRepository.change(user));
    }

    @Override
    public UserDto deleteById(Integer id) {
        if (!userRepository.getRepository().containsKey(id)) {
            log.warn("Пользователь с идентификатором {} не найден.", id);
            throw new UserNotFoundException("Пользователь с id " + id + " не найден");
        }
        return UserMapper.toUserDto(userRepository.deleteById(id));
    }

    private void validateEmail(User user) {
        for(User u: userRepository.getRepository().values()) {
            if (u.getEmail().equals(user.getEmail()) && !u.getId().equals(user.getId())) {
                log.warn("Дубликат email");
                throw new UserValidationException("Пользователь с " + user.getEmail() + " уже существует");
            }
        }
    }
}
