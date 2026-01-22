package com.juliafaco.diningreview.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "dining_reviews")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiningReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;

    @Column(name = "restaurant_rating", nullable = false)
    private Double rating;

    @Column(name = "commentary", nullable = true)
    private String commentary;


    public DiningReview(User user, Restaurant restaurant, Double rating, String commentary) {
        this.user = user;
        this.restaurant = restaurant;
        this.rating = rating;
        this.commentary = commentary;
    }


}
