package com.diplomski.socijalniapi.service;

import com.diplomski.socijalniapi.entity.User;
import com.diplomski.socijalniapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    protected UserRepository ur;

    @Override
    public void deleteAll() {
        ur.deleteAll();
    }

    @Override
    public List<User> getAll() {
        return ur.findAll();
    }
}
