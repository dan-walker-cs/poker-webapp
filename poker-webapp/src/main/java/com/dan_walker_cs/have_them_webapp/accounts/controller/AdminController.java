package com.dan_walker_cs.have_them_webapp.accounts.controller;

import com.dan_walker_cs.have_them_webapp.accounts.model.User;
import com.dan_walker_cs.have_them_webapp.accounts.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;


// This class handles display for the admin overview page
@Controller
public class AdminController {

    // Log stuff
    Logger logger = LoggerFactory.getLogger(AdminController.class);

    // Dependency to be injected
    @Autowired
    UserRepository userRepository;

    // Displays the admin.html template
    @RequestMapping("/admin")
    public String adminPage(Model model, Principal principal) {
        if(principal != null)
            logger.trace("User: " + principal.getName());

        // populates a list of users from the DB
        List<User> allUsers = this.userRepository.findAll();
        // adds the list to the template
        model.addAttribute("allUsers", allUsers);
        return "admin";
    }
}
