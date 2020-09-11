package com.revature.ers.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.services.ErsUserService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class ValidationHelper {

    private final ErsUserService ersUserService= new ErsUserService();

    public boolean process(HttpServletRequest req) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        switch (req.getRequestURI()) {
            case "/revabooks/email.validate":
                String email = mapper.readValue(req.getInputStream(), String.class);
                return ersUserService.isEmailAvailable(email);

            case "/revabooks/username.validate":
                String username = mapper.readValue(req.getInputStream(), String.class);
                return ersUserService.isUsernameAvailable(username);

            default:
                return false;
        }

    }
}

/*
previously RequestHelper had similar goal

import javax.servlet.http.HttpServletRequest;

public class RequestHelper {

    public static String process(HttpServletRequest req) {

        switch(req.getRequestURI()) {
            case "/project1/ers/login":
                return LoginController.login(req);
            default:
                return "/html/badlogin.html";
        }
    }

}




 */