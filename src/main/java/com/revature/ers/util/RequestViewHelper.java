package com.revature.ers.util;

import javax.servlet.http.HttpServletRequest;


public class RequestViewHelper {

    public String process(HttpServletRequest req) {

        System.out.println("[Request View Helper] req.getRequestURI() " + req.getRequestURI());

        String principal = (String) req.getSession().getAttribute("principal");

        switch (req.getRequestURI()) {

            //nav bar views
            case "/loadLoggedOutNavbar.view":
            case "/ers/loadLoggedOutNavbar.view":

                return "partials/navbarpartials/loggedoutnavbar.html";

            case "/loadLoggedInNavbar.view":
            case "/ers/loadLoggedInNavbar.view":
                if (principal == null || principal.equals("")) {
                    return "partials/navbarpartials/loggedoutnavbar.html";
                }

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

                if (principal == null || principal.equals("")) {
                    return "partials/login.html";
                }

                return "partials/home.html";

            case "/profile.view":
            case "/ers/profile.view":


                if (principal == null || principal.equals("")) {
                    return "partials/login.html";
                }

                return "partials/profile.html";

            //specific home views
            case "/employeeHome.view":
            case "/ers/employeeHome.view":

                if (principal == null || principal.equals("")) {
                    return "partials/employee/partialNotAllowed.html";
                }

                return "partials/employee/employeeHome.html";

            case "/adminHome.view":
            case "/ers/adminHome.view":

                if (principal == null || principal.equals("")) {
                    return "partials/employee/partialNotAllowed.html";
                }

                return "partials/admin/adminHome.html";

            case "/financeManagerHome.view":
            case "/ers/financeManagerHome.view":

                if (principal == null || principal.equals("")) {
                    return "partials/employee/partialNotAllowed.html";
                }

                return "partials/financeManager/financeManagerHome.html";

            case "/myReimbursements.view":
            case "/ers/myReimbursements.view":


                //return "partials/employee/myReimbursements.html";

                return "partials/register.html";

            default:
                return "partials/employee/myReimbursements.html";


        }

    }
}