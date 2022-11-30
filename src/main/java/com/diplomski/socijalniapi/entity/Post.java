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
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String naslov;

    @Column(length = 1000)
    private String tekst;

    private Integer lajkovi;

    private Date datum_postavljanja;

    @ManyToOne
    private User korisnik;

    public Post(String naslov, String tekst, Integer lajkovi, Date datum_postavljanja) {
        this.naslov = naslov;
        this.tekst = tekst;
        this.lajkovi = lajkovi;
        this.datum_postavljanja = datum_postavljanja;
    }
}
