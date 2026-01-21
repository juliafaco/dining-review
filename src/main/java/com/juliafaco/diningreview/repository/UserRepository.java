package com.juliafaco.diningreview.repository;

import com.juliafaco.diningreview.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existsByUsername(String username);

}
