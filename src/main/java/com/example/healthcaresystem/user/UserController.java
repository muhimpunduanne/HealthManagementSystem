package com.example.healthcaresystem.user;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping
    @Operation(summary="hhhhhh")
    public List<User> findAll() {
        return userService.findAll();
    }
    @PostMapping("user/api")
    @Operation(summary="the user created")
    public User createUser(@RequestBody UserCreateDto userCreateDto) {
        User users = new User();
        users.setFirstname(userCreateDto.getFirstName());
        users.setLastname(userCreateDto.getLastName());
        users.setEmail(userCreateDto.getEmail());
        users.setPassword(userCreateDto.getPassword());
         return userService.createUser(users);

    }
    @PutMapping("user/api")
    @Operation(summary="the data updated successful")
    public User updateUser(@RequestBody UserCreateDto userCreateDto) {
        User user=new User();
        user.setFirstname(userCreateDto.getFirstName());
        user.setLastname(userCreateDto.getLastName());
        user.setEmail(userCreateDto.getEmail());
        user.setPassword(userCreateDto.getPassword());
        return userService.updateUser(user);
    }
}
