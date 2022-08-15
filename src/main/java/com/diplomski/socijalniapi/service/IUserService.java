package com.diplomski.socijalniapi.service;

import com.diplomski.socijalniapi.entity.User;

import java.util.List;

public interface IUserService {
    void deleteAll();

    List<User> getAll();
}
