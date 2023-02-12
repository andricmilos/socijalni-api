package com.diplomski.socijalniapi.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class MyUserDetails implements UserDetails {

    private User user;

    public MyUserDetails(User user) {
        this.user=user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> listRole = new ArrayList<GrantedAuthority>();
        listRole.add(new SimpleGrantedAuthority(user.getRole()));
        return listRole;
    }

    public String getUserRole() { return user.getRole(); }

    public Integer getUserId(){
        return user.getId();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return user.isAktiviran();
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.isAktiviran();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return user.isAktiviran();
    }

    @Override
    public boolean isEnabled() {
        return user.isAktiviran();
    }
}
