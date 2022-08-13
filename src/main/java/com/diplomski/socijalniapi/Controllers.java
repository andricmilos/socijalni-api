package com.diplomski.socijalniapi;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controllers {

    @GetMapping("/")
    public String index(){
        return "CAO";
    }

}
