package com.diplomski.socijalniapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

    private Integer id;

    private String naslov;

    private String tekst;

    private Date datum_postavljanja;

    private String grupe;
}
