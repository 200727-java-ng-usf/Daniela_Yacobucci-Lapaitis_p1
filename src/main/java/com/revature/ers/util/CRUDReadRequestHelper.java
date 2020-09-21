package com.revature.ers.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.dtos.ErrorResponse;
import com.revature.ers.dtos.ErsReimbursementView;
import com.revature.ers.dtos.Principal;
import com.revature.ers.dtos.UserView;
import com.revature.ers.models.ErsReimbursement;
import com.revature.ers.models.ErsUser;
import com.revature.ers.services.ErsReimbursementService;
import com.revature.ers.services.ErsUserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CRUDReadRequestHelper {

    ErsUserService ersUserService = new ErsUserService();
    ErsReimbursementService ersReimbursementService = new ErsReimbursementService();
    ObjectMapper mapper = new ObjectMapper();
    String response;

    public String process(HttpServletRequest req) throws IOException {

        System.out.println("[CRUDCreateRequestHelper] req.getRequestURI() " + req.getRequestURI());
        Principal principal = Principal.JSONtoObj((String) req.getSession().getAttribute("principal"));

        switch(req.getRequestURI()){
            case "/userinfo.read":
            case "/ers/userinfo.read":
                response = httpReadUserInfo(principal);

                break;

            case "/getAllUsers.read":
            case "/ers/getAllUsers.read":
                response = httpGetAllUsers();
                break;
            case "/getAllReimbursements.read":
            case "/ers/getAllReimbursements.read":
                response = httpGetAllReimbursements();
                break;
            case "/getUserReimbursements.read":
            case "/ers/getUserReimbursements.read":
                response = httpGetAllReimbursementsOfUser(req);
                break;

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

    private String httpGetAllUsers(){
        String allUsersJSON = "";

        try {
            List<ErsUser> allErsUsers = ersUserService.getAllUsers();
            List<UserView> allUserViews = new ArrayList<UserView>();

            for(ErsUser ersUser: allErsUsers){
                UserView loggedInUserView = new UserView(ersUser);
                allUserViews.add(loggedInUserView);

            }

            allUsersJSON = mapper.writeValueAsString(allUserViews);


        } catch (JsonProcessingException jpe) {
            jpe.printStackTrace();
        }

        return allUsersJSON;

    }

    public String httpGetAllReimbursements(){
        String allReimbursemenstJSON = "";

        try {
            List<ErsReimbursement> allReimbursements = ersReimbursementService.getAllReimbursements();


            List<ErsReimbursementView> allReimbursementViews = new ArrayList<ErsReimbursementView>();

            for(ErsReimbursement ersr: allReimbursements){
                ErsReimbursementView ersReimbursementView = new ErsReimbursementView(ersr);
                allReimbursementViews.add(ersReimbursementView);

            }

            allReimbursemenstJSON = mapper.writeValueAsString(allReimbursementViews);


        } catch (JsonProcessingException jpe) {
            jpe.printStackTrace();
        }

        return allReimbursemenstJSON;
    }

    public String httpGetAllReimbursementsOfUser(HttpServletRequest req){

        String allReimbursementsOfUserJSON = "";
        Map<String, Object> response;
        Principal principalObj = new Principal();

        String principal = (String) req.getSession().getAttribute("principal");

        System.out.println("principal: " + principal);

        try {
            principalObj = new ObjectMapper().readValue(principal, Principal.class);
        } catch (JsonProcessingException e) {

            System.out.println("here is the catch: ");
            e.printStackTrace();
        }

//            String username = response.get("username").toString();
//            System.out.println(username);

        try {
            List<ErsReimbursement> allReimbursementsOfUser = ersReimbursementService.getReimbursementsByAuthorUsername(principalObj.getUsername());


            System.out.println("all reimb");

            for(ErsReimbursement ersrv:allReimbursementsOfUser){
                System.out.println(ersrv);
            }

            List<ErsReimbursementView> allReimbursementViews = new ArrayList<ErsReimbursementView>();

            for(ErsReimbursement ersr: allReimbursementsOfUser){
                System.out.println("yes?");
                ErsReimbursementView ersReimbursementView = new ErsReimbursementView(ersr);
                System.out.println("no?");
                allReimbursementViews.add(ersReimbursementView);
                System.out.println("perhaps?");

            }

            //TODO remove
            System.out.println("all views");

            for(ErsReimbursementView ersrv:allReimbursementViews){
                System.out.println(ersrv);
            }


            allReimbursementsOfUserJSON = mapper.writeValueAsString(allReimbursementViews);


        } catch (JsonProcessingException jpe) {
            jpe.printStackTrace();
        }

        return allReimbursementsOfUserJSON;
    }

}
