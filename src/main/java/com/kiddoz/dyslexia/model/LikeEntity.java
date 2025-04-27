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
public class LikeEntity {

    @EmbeddedId
    private LikeId id;

    @ManyToOne
    @MapsId("userId") // Maps LikeId.userId
    private ApplicationUser user;

    @ManyToOne
    @MapsId("postId") // Maps LikeId.postId
    private PostEntity post;
}
