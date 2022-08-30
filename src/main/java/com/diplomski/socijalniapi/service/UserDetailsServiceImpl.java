package com.diplomski.socijalniapi.service;

import com.diplomski.socijalniapi.entity.MyUserDetails;
import com.diplomski.socijalniapi.entity.User;
import com.diplomski.socijalniapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=UserService.getUr().getUserByUsername(username);
        if(user==null)
        {
            throw new UsernameNotFoundException("Korisnik nije pronadjen");
        }

        return new MyUserDetails(user);
    }
}
