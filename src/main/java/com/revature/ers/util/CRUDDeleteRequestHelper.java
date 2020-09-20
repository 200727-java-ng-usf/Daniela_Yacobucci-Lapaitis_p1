package com.revature.ers.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.dtos.Principal;
import com.revature.ers.models.ErsUser;
import com.revature.ers.services.ErsUserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;


import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class CRUDDeleteRequestHelper {

    ErsUserService ersUserService = new ErsUserService();
    ObjectMapper mapper = new ObjectMapper();

    public void process(HttpServletRequest req) throws IOException {

        System.out.println("[CRUDDeleteRequestHelper] req.getRequestURI() " + req.getRequestURI());
        //String ersUserJSON = mapper.readValue(req.getInputStream(), String.class);
        //ErsUser ersUser = ErsUser.JSONtoObj(ersUserJSON);


        switch(req.getRequestURI()){
            case "/user.delete":
            case "/ers/user.delete":

                httpSoftDeleteUser(req);

                break;

        }

    }

    //private void httpSoftDeleteUser (ErsUser ersUser){
    private void httpSoftDeleteUser (HttpServletRequest req){

        String deletedErsUserId = req.getParameter("id");

        System.out.println("deletedErsUserId " + deletedErsUserId);
        if (deletedErsUserId != null) {
            int id = Integer.parseInt(deletedErsUserId);
            ersUserService.softDeleteUserById(id);
        }

    }
}
