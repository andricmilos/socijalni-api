package com.diplomski.socijalniapi.repository;

import com.diplomski.socijalniapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
