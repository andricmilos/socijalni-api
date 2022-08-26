package com.diplomski.socijalniapi;


import com.diplomski.socijalniapi.dto.PostDto;
import com.diplomski.socijalniapi.dto.UserDto;
import com.diplomski.socijalniapi.entity.Post;
import com.diplomski.socijalniapi.entity.User;
import com.diplomski.socijalniapi.service.PostService;
import com.diplomski.socijalniapi.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.web.bind.annotation.*;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
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

    @RequestMapping(value = "/api/user/add",method = RequestMethod.POST)
    @ResponseBody
    public String addUser(@RequestParam("ime") String ime, @RequestParam("prezime") String prezime, @RequestParam("username") String username, @RequestParam("datum_rodjenja") String datum_rodjenja,@RequestParam("datum_pravljenja_naloga") String datum_pravljenja_naloga, @RequestParam("password") String password){
        SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
        try {
            User novi = new User(ime,prezime,username,format.parse(datum_rodjenja),format.parse(datum_pravljenja_naloga),password);
            us.createUser(novi);
            return "Uspesno";
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "Neuspesno";
    }

    @RequestMapping(value = "/api/user/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteUser(@RequestParam("id") Integer id){
        us.deleteUser(id);
        return "Zahtev poslat";
    }

    @RequestMapping(value = "/api/user/edit",method = RequestMethod.PUT)
    @ResponseBody
    public String editUser(@RequestParam("kogaid") Integer id,@RequestParam("ime") String ime, @RequestParam("prezime") String prezime, @RequestParam("username") String username, @RequestParam("datum_rodjenja") String datum_rodjenja,@RequestParam("datum_pravljenja_naloga") String datum_pravljenja_naloga, @RequestParam("password") String password){
        SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
        try {
            User novi = new User(ime,prezime,username,format.parse(datum_rodjenja),format.parse(datum_pravljenja_naloga),password);
            us.updateUser(id,novi);
            return "Uspesno";
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (RuntimeException r) {
            return r.getMessage();
        }
        return "Neuspesno";
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
