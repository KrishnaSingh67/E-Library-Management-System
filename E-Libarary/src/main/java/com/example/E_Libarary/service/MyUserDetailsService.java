package com.example.E_Libarary.service;

import com.example.E_Libarary.models.MyUser;
import com.example.E_Libarary.repository.MyUserCacheRepository;
import com.example.E_Libarary.repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    MyUserRepository myUserRepository;

    @Autowired
    MyUserCacheRepository myUserCacheRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser myUser=myUserCacheRepository.get(username);
        if (myUser==null){
            myUser = myUserRepository.findByUsername(username);     /////

            if (myUser !=null){
                myUserCacheRepository.set(myUser);
            }
        }
        return myUser;
    }
}
