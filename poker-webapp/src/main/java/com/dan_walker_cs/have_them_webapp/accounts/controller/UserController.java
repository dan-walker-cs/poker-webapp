package com.dan_walker_cs.have_them_webapp.accounts.controller;


import com.dan_walker_cs.have_them_webapp.accounts.repository.UserRepository;
import com.dan_walker_cs.have_them_webapp.game.model.GameRules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.security.Principal;
import java.util.ArrayList;


// This class handles display for a user's account page
@Controller
public class UserController {

    // Log stuff
    Logger logger = LoggerFactory.getLogger(UserController.class);

    // Dependency to be injected
    @Autowired
    UserRepository userRepository;


    // Displays the user.html template
    @RequestMapping("/user/{username}")
    public String userPage(ModelMap model, Principal principal, @PathVariable String username) {
        // current authenticated principal for the session
        final String currentUser = principal.getName();

        if(principal != null)
            logger.trace("User: " + principal.getName());

        model.addAttribute("user", currentUser);

        GameRules gameRules = new GameRules();
        model.addAttribute("gameRules", gameRules);

        return "user";
    }

    @PostMapping("/user/{username}")
    public String createGame(ModelMap model, Principal principal, @PathVariable String username, GameRules gameRules) {
        // current authenticated principal for the session
        final String currentUser = principal.getName();

        logger.info("-----gameRules-----");
        logger.info(gameRules.toString());

        // validate input
        ArrayList<String> errorList = gameRules.validateRules();

        if(errorList.size() > 0) {
            model.addAttribute("user", currentUser);
            model.addAttribute("errorList", errorList);
            return "user";
        }

        return "redirect:/home";
    }
}
