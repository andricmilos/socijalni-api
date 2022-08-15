package com.diplomski.socijalniapi.repository;

import com.diplomski.socijalniapi.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Integer> {
}
