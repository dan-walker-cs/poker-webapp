package com.dan_walker_cs.have_them_webapp.accounts.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;


// Marks class as a controller where every method returns a domain object instead of a view
@Controller
// This class handles the API for the home screen
public class HomeController {

    // Log stuff
    Logger logger = LoggerFactory.getLogger(AdminController.class);

    // Redirects the default URL to the home page URL
    @RequestMapping({"/home","/"})
    public String homePage(Model model, Principal principal) {
        if(principal != null)
            logger.trace("User: " + principal.getName());

        return "home";
    }
}
