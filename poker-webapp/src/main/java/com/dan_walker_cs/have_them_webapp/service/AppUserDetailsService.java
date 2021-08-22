package com.dan_walker_cs.have_them_webapp.service;

import com.dan_walker_cs.have_them_webapp.model.AppUserDetails;
import com.dan_walker_cs.have_them_webapp.model.User;
import com.dan_walker_cs.have_them_webapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;


// Abstracts out user information retrieval. This service takes a username and returns an object
//      containing all user details needed by the AuthenticationProvider for authentication and authorization.
@Service
public class AppUserDetailsService implements UserDetailsService {

    // Injects instance of the UserRepository
    @Autowired
    UserRepository userRepository;

    // Returns UserDetails instance, to be authenticated against, for a given username.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Searches the repository for a username matching the parameter and populates a user instance
        Optional<User> user = userRepository.findByUsername(username);

        user.orElseThrow(() -> new UsernameNotFoundException("Username: " + username + " not recognized."));

        return user.map(AppUserDetails::new).get();
    }
}
