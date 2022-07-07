package ru.practicum.shareit.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.practicum.shareit.user.dto.UserDto;
import ru.practicum.shareit.user.model.User;
import ru.practicum.shareit.user.service.UserService;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    @ResponseStatus(OK)
    public List<UserDto> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    public UserDto findById(@PathVariable(value = "id") Integer id) {
        return userService.findById(id);
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public UserDto add(@Valid @RequestBody User user) {
        return userService.add(user);
    }

    @PatchMapping("/{id}")
    public UserDto change(@PathVariable(value = "id") Integer id, @RequestBody User user) {
        log.debug("Изменение нового пользователя : \n{}", user);
        return userService.change(id, user);
    }

    @DeleteMapping("/{id}")
    public UserDto deleteById(@PathVariable(value = "id") Integer id) {
        log.debug("Удаление пользователя {}", id);
        return userService.deleteById(id);
    }

}
