package com.revature.controllers;


import com.revature.models.ErsUser;
import com.revature.models.ErsUserRole;
import com.revature.services.ErsUserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

public class LoginController {


    private static ErsUserService ersUserService = new ErsUserService();

    public static String login(HttpServletRequest req) {

//        // Making sure method is a POST http method
//        if (!req.getMethod().equals("POST")) {
//            return "/html/login.html";
//        }

        // Get Login Info
        String username = req.getParameter("fusername");
        String password = req.getParameter("fpassword");

        Optional<ErsUser> loggedUser = ersUserService.authenticate(username, password);


        if (loggedUser.isPresent()) {

            ErsUserRole loggedUserRole = loggedUser.get().getErsUserRole();
            username = loggedUser.get().getUsername();

            switch(loggedUserRole.getRoleName()) {
                case "Admin":
                    return "/html/admin/adminDashboard.html";
                case "Fin mngr":
                    return "/html/financeManager/managerDashboard.html";
                case "Employee":
                    return "/html/employee/employeeDashboard.html";
            }
        }

        return "/html/badlogin.html";

    }
}