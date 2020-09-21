package com.revature.ers.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.dtos.ErsReimbursementView;
import com.revature.ers.models.ErsReimbursement;
import com.revature.ers.models.ErsReimbursementType;
import com.revature.ers.models.ErsUser;
import com.revature.ers.repo.ErsUserRepository;
import com.revature.ers.services.ErsReimbursementService;
import com.revature.ers.services.ErsReimbursementTypeService;
import com.revature.ers.services.ErsUserService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class CRUDCreateRequestHelper {

    ErsUserService ersUserService = new ErsUserService();
    ErsReimbursementTypeService ersReimbursementTypeService = new ErsReimbursementTypeService();
    ErsReimbursementService ersReimbursementService = new ErsReimbursementService();


    ObjectMapper mapper = new ObjectMapper();

    public void process(HttpServletRequest req) throws IOException {

        System.out.println("[CRUDDeleteRequestHelper] req.getRequestURI() " + req.getRequestURI());
        //String ersUserJSON = mapper.readValue(req.getInputStream(), String.class);
        //ErsUser ersUser = ErsUser.JSONtoObj(ersUserJSON);

        switch(req.getRequestURI()){
            case "/user.create":
            case "/ers/user.create":
                httpCreateUser(req);
                break;
            case "/reimbursement.create":
            case "/ers/reimbursement.create":
                httpCreateReimbursement(req);
                break;

        }

    }

    private void httpCreateUser(HttpServletRequest req) {

        try {
            String ersUserJSON = mapper.readValue(req.getInputStream(), String.class);
            ErsUser ersUser = ErsUser.JSONtoObj(ersUserJSON);
            ersUserService.createUser(ersUser);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // provided "http" at the begining of method to con confuse with methods in service and repo layers
    private void httpCreateReimbursement(HttpServletRequest req){

        try {
            String reimbursementViewJSON = mapper.readValue(req.getInputStream(), String.class);

            //creates a simpler reimbursement object to be able to store, username of the author and role name instead of the whole objects
            ErsReimbursementView ersReimbursementView = ErsReimbursementView.JSONtoObj(reimbursementViewJSON);

            //user view username to get author object
            ErsUser author = ersUserService.findUserByUsername(ersReimbursementView.getAuthorUsername());

            //user view reimbursmentTypeName to get object
            ErsReimbursementType ersReimbursementType = ersReimbursementTypeService.getErsReimbursementTypeByName(ersReimbursementView.getStatusName());

            //creates ErsReimbursement
            ErsReimbursement ersReimbursement = new ErsReimbursement(ersReimbursementView.getAmount(), ersReimbursementView.getDescription(), author, ersReimbursementType);

            //saves the ersReimbursement object in database
            ersReimbursementService.createReimbursement(ersReimbursement);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
