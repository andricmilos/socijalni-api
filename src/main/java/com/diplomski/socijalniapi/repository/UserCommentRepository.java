package com.diplomski.socijalniapi.repository;

import com.diplomski.socijalniapi.entity.UserComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCommentRepository extends JpaRepository<UserComment,Integer> {
}
