package com.revature.ers.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.revature.ers.models.ErsUserRole;
import com.revature.ers.services.ErsUserService;
import com.revature.ers.dtos.Credentials;
import com.revature.ers.dtos.ErrorResponse;
import com.revature.ers.dtos.Principal;
import com.revature.ers.exceptions.AuthenticationException;
import com.revature.ers.exceptions.InvalidRequestException;
import com.revature.ers.models.ErsUser;
import com.revature.ers.services.ErsUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/auth")
public class AuthServlet extends HttpServlet {

    private final ErsUserService ersUserService = new ErsUserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("In the following servlet: " + this.getClass());
        req.getSession().invalidate();
        resp.setStatus(204);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("In the following servlet: " + this.getClass());
        ObjectMapper mapper = new ObjectMapper();
        PrintWriter respWriter = resp.getWriter();
        resp.setContentType("application/json");

        try {

            // User Jackson to read the request body and map the provided JSON to a Java POJO
            Credentials creds = mapper.readValue(req.getInputStream(), Credentials.class);

            ErsUser authUser = ersUserService.authenticate(creds.getUsername(), creds.getPassword());
            Principal principal = new Principal(authUser);

            HttpSession session = req.getSession();
            session.setAttribute("principal", principal.stringify());

            String principalJSON = mapper.writeValueAsString(principal);
            respWriter.write(principalJSON);

            resp.setStatus(200);

        } catch (MismatchedInputException | InvalidRequestException e) {

            resp.setStatus(400);
            ErrorResponse err = new ErrorResponse(400, "Bad Request: Malformed credentials object found in request body");
            String errJSON = mapper.writeValueAsString(err);
            respWriter.write(errJSON);

        } catch (AuthenticationException ae) {

            resp.setStatus(401);
            ErrorResponse err = new ErrorResponse(401, ae.getMessage());
            String errJSON = mapper.writeValueAsString(err);
            respWriter.write(errJSON);

        } catch (Exception e) {

            e.printStackTrace();
            resp.setStatus(500); // 500 = INTERNAL SERVER ERROR
            ErrorResponse err = new ErrorResponse(500, "Internal Server Error. It's not you, it's us. Our bad...");
            respWriter.write(mapper.writeValueAsString(err));

        }

    }
}



//TODO remove comment
/*
previously had this similar code

package com.revature.ers.controllers;


import com.revature.ers.models.ErsUser;
import com.revature.ers.models.ErsUserRole;
import com.revature.ers.services.ErsUserService;

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
}package com.revature.ers.controllers;


import com.revature.ers.models.ErsUser;
import com.revature.ers.models.ErsUserRole;
import com.revature.ers.services.ErsUserService;

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



 */
