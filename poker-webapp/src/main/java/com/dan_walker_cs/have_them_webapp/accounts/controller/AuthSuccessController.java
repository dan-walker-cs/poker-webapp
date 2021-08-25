package com.dan_walker_cs.have_them_webapp.accounts.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;


// This class handles the redirection logic after a successful login attempt
@Controller
public class AuthSuccessController {

    // Log stuff
    Logger logger = LoggerFactory.getLogger(AdminController.class);

   // Redirects the principal based on their role
    @RequestMapping("/authsuccess")
    public String authSuccessRedirect(Principal principal, HttpServletRequest request) {
        if(principal != null)
            logger.trace("User: " + principal.getName());

        if(request.isUserInRole("ADMIN")) {
            return "redirect:/admin";
        }
        return "redirect:/user/" + principal.getName();
    }
}
