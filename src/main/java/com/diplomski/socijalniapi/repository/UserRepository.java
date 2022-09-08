package com.diplomski.socijalniapi.repository;

import com.diplomski.socijalniapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Integer> {

    @Query(value = "SELECT * FROM user WHERE username = :username",nativeQuery = true)
    public User getUserByUsername(@Param("username") String username); //U nasem SQLquery koristimo "u" da bi dali do znanja springu da treba da nam vrati objekat koji ce biti kastovan u tip podatka koji vraca f-ja. Jel u suprotnom vraca listu enkapsuliranih kolona tabele.


}
