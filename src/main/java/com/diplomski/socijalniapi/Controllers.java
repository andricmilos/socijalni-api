package com.diplomski.socijalniapi;


import com.diplomski.socijalniapi.dto.PostDto;
import com.diplomski.socijalniapi.dto.UserDto;
import com.diplomski.socijalniapi.entity.Post;
import com.diplomski.socijalniapi.entity.User;
import com.diplomski.socijalniapi.service.PostService;
import com.diplomski.socijalniapi.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controllers {

    @Autowired
    protected PostService ps;

    @Autowired
    protected UserService us;

    @Autowired
    protected ModelMapper modelMapper;

    @GetMapping("/")
    public String index(){
        return "CAO";
    }

    @GetMapping("/api")
    public String api(){
        return "CAO";
    }

    @GetMapping("/api/post/svi")
    public List<PostDto> allPost(){
        List<PostDto> nova=new ArrayList<>();
        List<Post> stari=ps.getAllPosts();
        for (Post p:stari) {
            nova.add(convertToDto(p));
        }
        return nova;
    }

    @GetMapping("/api/user/{Id}")
    public UserDto getUser(@PathVariable("Id") Integer id){
        return convertToDto(us.getUserById(id));
    }

    //koristimo UserDto da bi zastitili informacije. Radimo pretvaranje naseg usera u userDto.
    @GetMapping("/api/user/svi")
    public List<UserDto> allUser(){
        List<UserDto> nova=new ArrayList<>();
        List<User> stari=us.getAll();
        for (User u:stari) {
            nova.add(convertToDto(u));
        }
        return nova;
    }

    @GetMapping("/api/post/{Id}")
    public PostDto getPost(@PathVariable("Id") Integer id){
        return convertToDto(ps.getPostById(id));
    }

    private UserDto convertToDto(User user){
        UserDto userDto=modelMapper.map(user,UserDto.class);
        return userDto;
    }

    private PostDto convertToDto(Post post){
        PostDto postDto=modelMapper.map(post,PostDto.class);
        return postDto;
    }

}
