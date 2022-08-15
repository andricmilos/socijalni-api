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
public class UserDto {

    private Integer id;

    private String ime;

    private String prezime;

    private String username;

    private Date datum_rodjenja;

    private Date datum_pravljenja_naloga;
}
