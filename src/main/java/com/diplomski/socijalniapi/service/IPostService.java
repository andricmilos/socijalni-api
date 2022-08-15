package com.diplomski.socijalniapi.service;

import com.diplomski.socijalniapi.entity.Post;

import java.util.List;

public interface IPostService {

    void deleteAll();

    List<Post> getAllPosts();

    void deletePost(Integer id);

    Post getPostById(Integer id);

    Post updatePost(Integer id,Post post);

    Post createPost(Post post);
}
