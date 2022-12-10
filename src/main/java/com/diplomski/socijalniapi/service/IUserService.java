package com.diplomski.socijalniapi.service;

import com.diplomski.socijalniapi.entity.Post;
import com.diplomski.socijalniapi.entity.User;

import java.util.List;

public interface IUserService {

    List<User> getAll();

    void deleteUser(Integer id);

    void aktivirajUser(Integer id);

    User getUserById(Integer id);

    User updateUser(Integer id,User user);

    User createUser(User user) throws RuntimeException;
}
