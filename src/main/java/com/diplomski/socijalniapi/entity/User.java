package com.diplomski.socijalniapi.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@ToString
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String ime;

    private String prezime;

    private String username;

    private Date datum_rodjenja;

    private Date datum_pravljenja_naloga;

    private String password;

    @OneToMany(mappedBy = "korisnik")
    private List<Post> post;

    public User(String ime, String prezime, String username, Date datum_rodjenja, Date datum_pravljenja_naloga, String password) {
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.datum_rodjenja = datum_rodjenja;
        this.datum_pravljenja_naloga = datum_pravljenja_naloga;
        this.password = password;
    }
}
