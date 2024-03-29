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

    private String email;

    private String ime;

    private String prezime;

    private String username;

    private Date datum_rodjenja;

    private Date datum_pravljenja_naloga;

    private String password;

    private boolean aktiviran;

    private String role;

    private String grupe;

    @OneToMany(mappedBy = "korisnik")
    private List<Post> post;

    public User(String email, String ime, String prezime, String username, Date datum_rodjenja, Date datum_pravljenja_naloga, String password) {
        this.email = email;
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.datum_rodjenja = datum_rodjenja;
        this.datum_pravljenja_naloga = datum_pravljenja_naloga;
        this.password = password;
        role="basic";
        aktiviran=false;
        this.grupe="";
    }

    public User(String email, String ime, String prezime, String username, Date datum_rodjenja, Date datum_pravljenja_naloga, String password, String grupe) {
        this.email = email;
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.datum_rodjenja = datum_rodjenja;
        this.datum_pravljenja_naloga = datum_pravljenja_naloga;
        this.password = password;
        role="basic";
        aktiviran=false;
        this.grupe=grupe;
    }

    public User(User u) {
        this.id = u.getId();
        this.email = u.getEmail();
        this.ime = u.getIme();
        this.prezime = u.getPrezime();
        this.username = u.getUsername();
        this.datum_rodjenja = u.getDatum_rodjenja();
        this.datum_pravljenja_naloga = u.getDatum_pravljenja_naloga();
        this.password = u.getPassword();
        this.aktiviran = u.isAktiviran();
        this.role = u.getRole();
        this.post = u.getPost();
        this.grupe=u.getGrupe();
    }
}
