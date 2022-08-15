package com.diplomski.socijalniapi;


import com.diplomski.socijalniapi.entity.Post;
import com.diplomski.socijalniapi.service.PostService;
import com.diplomski.socijalniapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controllers {

    @Autowired
    protected PostService ps;

    @Autowired
    protected UserService us;

    @GetMapping("/")
    public String index(){
        return "CAO";
    }

    @GetMapping("/svi")
    public List<Post> allPost(){
        return ps.getAllPosts();
    }

}
