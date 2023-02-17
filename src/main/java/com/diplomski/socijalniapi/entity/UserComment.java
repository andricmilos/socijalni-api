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

    private Date datum_postavljanja;

    public UserComment(Integer userId, Integer postId, String sadrzaj,Date datum_postavljanja) {
        this.userId = userId;
        this.postId = postId;
        this.sadrzaj = sadrzaj;
        this.datum_postavljanja = datum_postavljanja;
    }

}

