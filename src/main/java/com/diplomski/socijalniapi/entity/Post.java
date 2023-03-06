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

    @Column(length = 3000)
    private String tekst;

    private Date datum_postavljanja;

    @ManyToOne
    private User korisnik;

    private String grupe;

    private String user;
    public Post(String naslov, String tekst, Date datum_postavljanja,String grupe, String user) {
        this.naslov = naslov;
        this.tekst = tekst;
        this.datum_postavljanja = datum_postavljanja;
        this.grupe=grupe;
        this.user = user;
    }
}
