package com.diplomski.socijalniapi.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@ToString
@NoArgsConstructor
@Getter
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
}
