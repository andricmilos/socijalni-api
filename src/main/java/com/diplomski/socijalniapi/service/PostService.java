package com.diplomski.socijalniapi.service;

import com.diplomski.socijalniapi.entity.Post;
import com.diplomski.socijalniapi.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements IPostService{

    @Autowired
    protected PostRepository pr;

    @Override
    public List<Post> getAllPosts() {
        return pr.findAll();
    }

    @Override
    public void deletePost(Integer id) {
        Post post=pr.findById(id).orElseThrow(() -> new RuntimeException("Greska")); //FIXME Napraviti izuzetak
        pr.delete(post);
    }

    @Override
    public Post getPostById(Integer id) {
        return pr.findById(id).orElseThrow(() -> new RuntimeException("Greska"));
    }

    @Override
    public Post updatePost(Integer id, Post post) {
        Post staripost=pr.findById(id).orElseThrow(() -> new RuntimeException("Greska")); //FIXME Napraviti izuzetak
        staripost.setNaslov(post.getNaslov());
        staripost.setTekst(post.getTekst());
        staripost.setDatum_postavljanja(post.getDatum_postavljanja());
        staripost.setKorisnik(post.getKorisnik());
        staripost.setGrupe(post.getGrupe());
        return pr.save(staripost);
    }

    @Override
    public Post createPost(Post post) {
        return pr.save(post);
    }

}
