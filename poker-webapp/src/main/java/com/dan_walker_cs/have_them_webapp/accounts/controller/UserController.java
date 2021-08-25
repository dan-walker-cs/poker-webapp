package com.dan_walker_cs.have_them_webapp.accounts.controller;


import com.dan_walker_cs.have_them_webapp.accounts.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.security.Principal;


// This class handles display for a user's account page
@Controller
public class UserController {

    // Log stuff
    Logger logger = LoggerFactory.getLogger(AdminController.class);

    // Dependency to be injected
    @Autowired
    UserRepository userRepository;


    // Displays the user.html template
    @RequestMapping("/user/{username}")
    public String userPage(ModelMap model, Principal principal, @PathVariable String username) {
        if(principal != null)
            logger.trace("User: " + principal.getName());

        // current authenticated principal for the session
        final String currentUser = principal.getName();
        model.addAttribute("user", currentUser);
        return "user";
    }
}
