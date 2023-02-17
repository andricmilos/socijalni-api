package com.diplomski.socijalniapi.service;

import com.diplomski.socijalniapi.entity.CodeGroup;
import com.diplomski.socijalniapi.entity.UserComment;

import java.util.List;

public interface IUserCommentService {

    List<UserComment> getAllUserComment();

    void deleteUserComment(Integer id);

    UserComment getUserCommentById(Integer id);

    UserComment updateUserComment(Integer id,UserComment userComment);

    UserComment createUserComment(UserComment userComment);
}
