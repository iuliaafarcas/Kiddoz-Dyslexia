package com.kiddoz.dyslexia.model;


import com.kiddoz.recommendation.model.ApplicationUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    @ManyToOne
    private ApplicationUser author;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostEntity post;

}
