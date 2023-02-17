package com.diplomski.socijalniapi.service;

import com.diplomski.socijalniapi.entity.UserComment;
import com.diplomski.socijalniapi.repository.UserCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCommentService implements IUserCommentService {

    @Autowired
    protected UserCommentRepository ucr;

    @Override
    public List<UserComment> getAllUserComment() {
        return ucr.findAll();
    }

    @Override
    public void deleteUserComment(Integer id) {
        UserComment userComment=ucr.findById(id).orElseThrow(() -> new RuntimeException("Greska"));
        ucr.delete(userComment);
    }

    @Override
    public UserComment getUserCommentById(Integer id) {
        return ucr.findById(id).orElseThrow(() -> new RuntimeException("Greska"));
    }

    @Override
    public UserComment updateUserComment(Integer id, UserComment userComment) {
        UserComment starikomentar=ucr.findById(id).orElseThrow(() -> new RuntimeException("Greska"));
        starikomentar.setUserId(userComment.getUserId());
        starikomentar.setPostId(userComment.getPostId());
        starikomentar.setSadrzaj(userComment.getSadrzaj());
        return ucr.save(starikomentar);
    }

    @Override
    public UserComment createUserComment(UserComment userComment) {
        return ucr.save(userComment);
    }

}
