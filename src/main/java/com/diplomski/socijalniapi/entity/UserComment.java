package com.diplomski.socijalniapi.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@ToString
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class UserComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer userId;

    private Integer postId;

    @Column(length = 1000)
    private String sadrzaj;

    public UserComment(Integer userId, Integer postId, String sadrzaj) {
        this.userId = userId;
        this.postId = postId;
        this.sadrzaj = sadrzaj;
    }

}

