package com.revature.ers.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.dtos.ErrorResponse;
import com.revature.ers.dtos.Principal;
import com.revature.ers.dtos.UserView;
import com.revature.ers.models.ErsUser;
import com.revature.ers.services.ErsUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DatabaseRequestHelper {

    ErsUserService ersUserService = new ErsUserService();
    ObjectMapper mapper = new ObjectMapper();
    String response;

    public String process(HttpServletRequest req) throws IOException {

        System.out.println("[Request View Helper] req.getRequestURI() " + req.getRequestURI());
        Principal principal = Principal.JSONtoObj((String) req.getSession().getAttribute("principal"));

        switch(req.getRequestURI()){
            case "/userinfo.database":
            case "/ers/userinfo.database":
                response = httpGetUserInfo(principal);

        }

        return (response);
    }


    private String httpGetUserInfo(Principal principal){

        String userJSON = "";
        try {


            ErsUser principalUser = ersUserService.findUserByUsername(principal.getUsername());
            UserView loggedInUserView = new UserView(principalUser);
            System.out.println("UserView: " + loggedInUserView);
            userJSON = mapper.writeValueAsString(loggedInUserView);
            //TODO check of 200 status is appropriate


        }
        catch(Exception e){//TODO catch this exception accordingly

        }

        return userJSON;

    }

}
