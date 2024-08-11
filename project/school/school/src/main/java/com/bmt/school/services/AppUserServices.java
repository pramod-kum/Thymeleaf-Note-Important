package com.bmt.school.services;

import com.bmt.school.models.AppUser;
import com.bmt.school.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserServices implements UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        AppUser appUser = appUserRepository.findByEmail(email);

        if(appUser != null){
            var springUser = User.withUsername(appUser.getEmail())
                    .password((appUser.getPassword()))
                    .roles(appUser.getRole())
                    .build();

            return springUser;
        }

        return null;
    }
}
