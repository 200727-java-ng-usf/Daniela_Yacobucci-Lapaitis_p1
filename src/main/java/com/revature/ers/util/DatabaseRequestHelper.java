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

    public HttpServletResponse process(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        System.out.println("[Request View Helper] req.getRequestURI() " + req.getRequestURI());

        ObjectMapper mapper = new ObjectMapper();
        PrintWriter respWriter = resp.getWriter();

        switch(req.getRequestURI()){
            case "/userinfo.database":
            case "/ers/userinfo.database":
                //get principal's info
                //TODO not only get user info but also edit it
                try {
                    Principal principal = Principal.JSONtoObj((String) req.getSession().getAttribute("principal"));
                    ErsUser principalUser = ersUserService.findUserByUsername(principal.getUsername());
                    System.out.println("principalUser: " + principalUser);

                    UserView loggedInUserView = new UserView(principalUser);
                    System.out.println("UserView: " + loggedInUserView);
                    String userJSON = mapper.writeValueAsString(loggedInUserView);
                    respWriter.write(userJSON);
                    //TODO change status


                }
                catch(Exception e){//TODO catch this exception accordingly

                }


        }
        return resp;

    }

}
