package com.juliafaco.diningreview.service;

import com.juliafaco.diningreview.dto.UserRequest;
import com.juliafaco.diningreview.dto.UserResponse;
import com.juliafaco.diningreview.dto.UserSimpleResponse;
import com.juliafaco.diningreview.model.User;
import com.juliafaco.diningreview.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse createUser(UserRequest userRequest) {
        if (userRepository.existsByUsername(userRequest.getUsername())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Username already exists");
        }
        User user = new User(userRequest.getUsername(),
                userRequest.getCity(),
                userRequest.getState(),
                userRequest.getZipCode());
        User savedUser = userRepository.save(user);

        return new UserResponse(
                savedUser.getId(),
                savedUser.getUsername(),
                savedUser.getCity(),
                savedUser.getState(),
                savedUser.getZipCode());
    }

    public UserResponse getUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        return new UserResponse( user.getId(),
                user.getUsername(),
                user.getCity(),
                user.getState(),
                user.getZipCode());
    }

    public List<UserSimpleResponse> getAllUsers() {
        List<UserSimpleResponse> userSimpleResponses = new ArrayList<>();

        for(User user : userRepository.findAll()){
            userSimpleResponses.add(new UserSimpleResponse(
                    user.getId(),
                    user.getUsername()));
        }
        return userSimpleResponses;
    }
}
