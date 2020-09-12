package com.revature.ers.util;

import javax.servlet.http.HttpServletRequest;


public class RequestViewHelper {

    public String process(HttpServletRequest req) {

        System.out.println("[Request View Helper] req.getRequestURI() " + req.getRequestURI());

        switch (req.getRequestURI()) {

            //nav bar views
            case "/loadLoggedOutNavbar.view":
            case "/ers/loadLoggedOutNavbar.view":

                return "partials/navbarpartials/loggedoutnavbar.html";

            //nav bar views
            case "/loadLoggedInNavbar.view":
            case "/ers/loadLoggedInNavbar.view":

                return "partials/navbarpartials/loggedinnavbar.html";

            //app body views
            case "/login.view":
            case "/ers/login.view":

                return "partials/login.html";

            case "/register.view":
            case "/ers/register.view":
                return "partials/register.html";

            case "/home.view":
            case "/ers/home.view":

                String principal = (String) req.getSession().getAttribute("principal");
                if (principal == null || principal.equals("")) {
                    return "partials/login.html";
                }

                return "partials/home.html";

            default:
                return null;

        }

    }
}