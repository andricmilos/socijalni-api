package com.diplomski.socijalniapi.service;

import com.diplomski.socijalniapi.entity.Post;
import com.diplomski.socijalniapi.entity.User;
import com.diplomski.socijalniapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    protected static UserRepository ur;

    public static UserRepository getUr(){
        return ur;
    }

    @Override
    public List<User> getAll() {
        return ur.findAll();
    }

    @Override
    public void deleteUser(Integer id) {
        User user=ur.findById(id).orElseThrow(() -> new RuntimeException("Greska")); //FIXME Napraviti izuzetak
        ur.delete(user);
    }

    @Override
    public User getUserById(Integer id) {
        return ur.findById(id).orElseThrow(() -> new RuntimeException("Greska"));
    }

    @Override
    public User updateUser(Integer id, User user) {
        User staripost=ur.findById(id).orElseThrow(() -> new RuntimeException("Korisnik ne postoji")); //FIXME Napraviti izuzetak
        staripost.setIme(user.getIme());
        staripost.setPrezime(user.getPrezime());
        staripost.setUsername(user.getUsername());
        staripost.setDatum_rodjenja(user.getDatum_rodjenja());
        staripost.setDatum_pravljenja_naloga(user.getDatum_pravljenja_naloga());
        staripost.setPassword(user.getPassword());
        staripost.setRole(user.getRole());
        return ur.save(staripost);
    }

    @Override
    public User createUser(User user) {
        return ur.save(user);
    }
}
