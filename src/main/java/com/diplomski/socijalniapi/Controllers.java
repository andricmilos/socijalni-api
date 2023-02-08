package com.diplomski.socijalniapi;


import com.diplomski.socijalniapi.dto.PostDto;
import com.diplomski.socijalniapi.dto.UserDto;
import com.diplomski.socijalniapi.entity.CodeGroup;
import com.diplomski.socijalniapi.entity.MyUserDetails;
import com.diplomski.socijalniapi.entity.Post;
import com.diplomski.socijalniapi.entity.User;
import com.diplomski.socijalniapi.service.CodeGroupService;
import com.diplomski.socijalniapi.service.PostService;
import com.diplomski.socijalniapi.service.UserDetailsServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class Controllers extends ResponseEntityExceptionHandler {

    @Autowired
    protected PostService ps;

    @Autowired
    protected CodeGroupService gs;

    @Autowired
    protected UserDetailsServiceImpl serv;

    @Autowired
    protected ModelMapper modelMapper;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public void method(HttpServletResponse httpServletResponse) {
        httpServletResponse.setHeader("Location", "http://localhost:5173/log");
        httpServletResponse.setStatus(302);
    }

    @GetMapping("/api")
    public String api(){
        return "CAO";
    }

    @GetMapping("/api/validate/login")
    public String validateLogin(){
        return "valid";
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

    @GetMapping("/api/group/svi")
    public List<CodeGroup> allGroup(){
        return gs.getAllCodeGroups();
    }

    @GetMapping("/api/group/{Id}")
    public CodeGroup getGroup(@PathVariable("Id") Integer id){
        return gs.getCodeGroupById(id);
    }

    @GetMapping("/api/user/{Id}")
    public UserDto getUser(@PathVariable("Id") Integer id){
        return convertToDto(serv.getUserService().getUserById(id));
    }

    //koristimo UserDto da bi zastitili informacije. Radimo pretvaranje naseg usera u userDto.
    @GetMapping("/api/user/svi")
    public List<UserDto> allUser(){
        List<UserDto> nova=new ArrayList<>();
        List<User> stari=serv.getUserService().getAll();
        for (User u:stari) {
            nova.add(convertToDto(u));
        }
        return nova;
    }

    @GetMapping("/api/user/ulogovani")
    public String loggedInUser(){
        Authentication authenticator = SecurityContextHolder.getContext().getAuthentication();
        MyUserDetails myUserDetails= (MyUserDetails) authenticator.getPrincipal();
        return "{\"ID\":"+myUserDetails.getUserId().toString()+"}";
    }

    @GetMapping("/api/post/{Id}")
    public PostDto getPost(@PathVariable("Id") Integer id){
        return convertToDto(ps.getPostById(id));
    }

    @GetMapping("/api/post/from/{Id}")
    public List<PostDto> getPostFromUser(@PathVariable("Id") Integer id){
        User u=serv.getUserService().getUserById(id);
        List<PostDto> nova=new ArrayList<>();
        List<Post> stari=u.getPost();
        for (Post p:stari) {
            nova.add(convertToDto(p));
        }
        return nova;
    }

    @GetMapping(value = "/api/user/add")
    public String addUser(@RequestParam String email, @RequestParam String ime, @RequestParam String prezime, @RequestParam String username, @RequestParam String datum_rodjenja, @RequestParam String datum_pravljenja_naloga, @RequestParam String password){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format2=new SimpleDateFormat("MM/dd/yyyy, hh:mm:ss");
        try {
            User novi = new User(email,ime,prezime,username,format.parse(datum_rodjenja),format2.parse(datum_pravljenja_naloga),password);
            serv.getUserService().createUser(novi);
            return "Uspesno";
        } catch (ParseException e) {
            //e.printStackTrace();
        }
        return "Neuspesno";
    }

    @GetMapping(value = "/api/group/add")
    public String addGroup(@RequestParam String ime, @RequestParam String opis)
    {
        CodeGroup novi=new CodeGroup(ime,opis);
        gs.createCodeGroup(novi);
        return "Uspesno";
    }

    @GetMapping(value = "/api/group/edit")
    public String addGroup(@RequestParam String kogaid,@RequestParam String ime, @RequestParam String opis)
    {
        try {
            CodeGroup novi=new CodeGroup(ime,opis);
            int mojId=Integer.parseInt(kogaid);
            gs.updateCodeGroup(mojId,novi);
            return "Uspesno";
        } catch (RuntimeException r) {
            return r.getMessage();
        }
    }

    @RequestMapping(value = "/api/group/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteGroup(@RequestParam("id") Integer id){
        gs.deleteCodeGroup(id);
        return "Zahtev poslat";
    }


    @RequestMapping(value = "/api/user/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteUser(@RequestParam("id") Integer id){
        serv.getUserService().deleteUser(id);
        return "Zahtev poslat";
    }

    @RequestMapping(value = "/api/user/aktiviraj", method = RequestMethod.POST)
    @ResponseBody
    public String aktivirajUser(@RequestParam("id") Integer id){
        serv.getUserService().aktivirajUser(id);
        return "Zahtev poslat";
    }

    @RequestMapping(value = "/api/user/edit")
    public String editUser(@RequestParam String email, @RequestParam String kogaid,@RequestParam String ime, @RequestParam String prezime, @RequestParam String username, @RequestParam String datum_rodjenja,@RequestParam String datum_pravljenja_naloga, @RequestParam String password, @RequestParam String grupe){
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format2=new SimpleDateFormat("MM/dd/yyyy, hh:mm:ss aa");
        try {
            User novi = new User(email,ime,prezime,username,format.parse(datum_rodjenja),format2.parse(datum_pravljenja_naloga),password,grupe);
            int mojId=Integer.parseInt(kogaid);
            serv.getUserService().updateUser(mojId,novi);
            return "Uspesno";
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (RuntimeException r) {
            return r.getMessage();
        }
        return "Neuspesno";
    }

    @GetMapping(value = "/api/post/add")
    public String addPost(@RequestParam String naslov, @RequestParam String tekst, @RequestParam String datum_postavljanja, @RequestParam String grupe){
        SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
        try {
            Post novi = new Post(naslov,tekst,format.parse(datum_postavljanja),grupe);
            ps.createPost(novi);
            return "Uspesno";
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "Neuspesno";
    }

    @RequestMapping(value = "/api/post/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public String deletePost(@RequestParam("id") Integer id){
        ps.deletePost(id);
        return "Zahtev poslat";
    }

    @RequestMapping(value = "/api/post/edit")
    public String editPost(@RequestParam("kogaid") String id,@RequestParam String naslov, @RequestParam String tekst, @RequestParam String datum_postavljanja, @RequestParam String grupe){
        SimpleDateFormat format=new SimpleDateFormat("MM/dd/yyyy, hh:mm:ss aa");
        try {
            Post novi = new Post(naslov,tekst,format.parse(datum_postavljanja),grupe);
            ps.updatePost(Integer.parseInt(id),novi);
            return "Uspesno";
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (RuntimeException r) {
            return r.getMessage();
        }
        return "Neuspesno";
    }

    @ExceptionHandler({ RuntimeException.class })

    protected ResponseEntity<Object> handleConflict(
            RuntimeException ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    private UserDto convertToDto(User user){
        return modelMapper.map(user,UserDto.class);
    }

    private PostDto convertToDto(Post post){
        return modelMapper.map(post,PostDto.class);
    }

}
