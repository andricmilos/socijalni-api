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

    @Autowired
    protected UserService us;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=us.getUr().getUserByUsername(username);
        if(user==null)
        {
            throw new UsernameNotFoundException("Korisnik nije pronadjen");
        }

        return new MyUserDetails(user);
    }

    public UserService getUserService(){

        return us;
    }
}
