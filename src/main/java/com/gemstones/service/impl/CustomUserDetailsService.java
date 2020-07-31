package com.gemstones.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gemstones.dto.MyUser;
import com.gemstones.entity.RoleEntity;
import com.gemstones.entity.UserEntity;
import com.gemstones.repository.UserRepository;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userEntity = userRepository.findOneByUsernameAndStatus(username, "1");

        if (userEntity == null) {
            throw new UsernameNotFoundException("User Not Found");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();

        for (RoleEntity role : userEntity.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getCode()));
        }

        MyUser myUser = new MyUser(userEntity.getUsername(), userEntity.getPassword(), true, true, true, true,
                authorities);
        myUser.setFullName(userEntity.getFullname());
        return myUser;
    }
}
