package com.dan_walker_cs.have_them_webapp.accounts.controller;

import com.dan_walker_cs.have_them_webapp.accounts.model.User;
import com.dan_walker_cs.have_them_webapp.accounts.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

// This class handles display for the account registration page
@Controller
public class RegisterController {

    // Log stuff
    Logger logger = LoggerFactory.getLogger(AdminController.class);

    // Dependency to be injected
    @Autowired
    UserRepository userRepository;

    // Displays the register.html template
    @RequestMapping("/register")
    public String registrationPage(Model model, Principal principal) {
        if(principal != null)
            logger.trace("User: " + principal.getName());

        if (principal != null) {
            return "redirect:/user/" + principal.getName();
        }
        // new instance to be populated
        User user = new User();
        // add instance to the template
        model.addAttribute("user", user);
        return "register";
    }

    // Pulls data from the registration template
    @PostMapping("/register")
    public String createUser(User user) {
        // default data
        user.setActive(true);
        user.setRoles("ROLE_USER");
        // add new user to DB
        userRepository.save(user);
        return "redirect:/home";
    }
}
