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

public class CRUDReadRequestHelper {

    ErsUserService ersUserService = new ErsUserService();
    ObjectMapper mapper = new ObjectMapper();
    String response;

    public String process(HttpServletRequest req) throws IOException {

        System.out.println("[CRUDCreateRequestHelper] req.getRequestURI() " + req.getRequestURI());
        Principal principal = Principal.JSONtoObj((String) req.getSession().getAttribute("principal"));

        switch(req.getRequestURI()){
            case "/userinfo.read":
            case "/ers/userinfo.read":
                response = httpReadUserInfo(principal);

        }

        return (response);
    }

    //ERSUsers
    private String httpReadUserInfo(Principal principal){

        String userJSON = "";
        try {


            ErsUser principalUser = ersUserService.findUserByUsername(principal.getUsername());
            UserView loggedInUserView = new UserView(principalUser);
            System.out.println("UserView: " + loggedInUserView);
            userJSON = mapper.writeValueAsString(loggedInUserView);



        }
        catch(Exception e){//TODO catch this exception accordingly

        }

        return userJSON;

    }



}
