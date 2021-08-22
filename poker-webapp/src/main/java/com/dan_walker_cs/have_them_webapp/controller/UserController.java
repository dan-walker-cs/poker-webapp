package com.dan_walker_cs.have_them_webapp.controller;


import com.dan_walker_cs.have_them_webapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;


// This class handles display for a user's account page
@Controller
public class UserController {

    // Dependency to be injected
    @Autowired
    UserRepository userRepository;


    // Displays the user.html template
    @RequestMapping("/user/{username}")
    public String userPage(ModelMap model, final HttpServletRequest request, Principal principal, @PathVariable String username) {
        // current authenticated principal for the session
        final String currentUser = principal.getName();
        model.addAttribute("user", currentUser);
        return "user";
    }
}
