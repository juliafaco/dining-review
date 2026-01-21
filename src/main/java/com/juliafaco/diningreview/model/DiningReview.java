package com.juliafaco.diningreview.model;


import com.juliafaco.diningreview.enums.ReviewStatus;
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

    @Enumerated(EnumType.STRING)
    @Column(name = "admin_review", nullable = false)
    private ReviewStatus review = ReviewStatus.PENDING;


    public DiningReview(User user, Restaurant restaurant, Double rating, String commentary) {
        this.user = user;
        this.restaurant = restaurant;
        this.rating = rating;
        this.commentary = commentary;
    }


}
