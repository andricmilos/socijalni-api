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
public class CodeGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String ime;

    @Column(length = 1000)
    private String opis;

    public CodeGroup(String ime, String opis) {
        this.ime = ime;
        this.opis = opis;
    }

}

