package com.travelbest.service;

import com.travelbest.entity.User;
import com.travelbest.repository.UserRepository;
import com.travelbest.security.auth.JwtUserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Ihor Sakaylyuk
 *
 * JwtUserDetailsService loads user by username
 */
@Service
public class JwtUserDetailsServiceBean implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Loads UserDetail by specified username
     * @param username by which UserDetails should be loaded
     * @return UserDetails of found user
     * @throws UsernameNotFoundException if there is no user with this username
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = null;
        try {
            user = userRepository.findByUsername(username);
        } catch(Exception ex) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        }

        return JwtUserFactory.create(user);
    }
}
