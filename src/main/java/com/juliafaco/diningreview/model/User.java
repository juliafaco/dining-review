package com.juliafaco.diningreview.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private String zipCode;

    public User(String username,
                String city,
                String state,
                String zipCode){
    this.username = username;
    this.city = city;
    this.state = state;
    this.zipCode = zipCode;
    }
};
