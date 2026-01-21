package com.juliafaco.diningreview.controller;

import com.juliafaco.diningreview.dto.UserRequest;
import com.juliafaco.diningreview.dto.UserResponse;
import com.juliafaco.diningreview.dto.UserSimpleResponse;
import com.juliafaco.diningreview.model.User;
import com.juliafaco.diningreview.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest userRequest){
        return userService.createUser(userRequest);
    }

    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable Long id){
        return userService.getUser(id);
    }

    @GetMapping
    public List<UserSimpleResponse> getAllUsers(){
        return userService.getAllUsers();
    }



}
