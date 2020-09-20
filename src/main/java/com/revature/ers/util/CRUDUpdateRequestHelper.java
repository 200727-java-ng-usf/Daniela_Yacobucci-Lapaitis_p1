package com.revature.ers.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.models.ErsReimbursementStatus;
import com.revature.ers.models.ErsUser;
import com.revature.ers.services.ErsReimbursementService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class CRUDUpdateRequestHelper {

    ObjectMapper mapper = new ObjectMapper();
    ErsReimbursementService ersReimbursementService = new ErsReimbursementService();

    public void process(HttpServletRequest req) throws IOException {



        System.out.println("[CRUDDeleteRequestHelper] req.getRequestURI() " + req.getRequestURI());
        //String ersUserJSON = mapper.readValue(req.getInputStream(), String.class);
        //ErsUser ersUser = ErsUser.JSONtoObj(ersUserJSON);

        switch (req.getRequestURI()) {
            case "/user.updateUsername":
            case "/ers/user.updateUsername":
                httpUpdateErsUserUsername(req);
                break;
            case "/reimbursement.approve":
            case "/ers/reimbursement.approve":
                httpDenyReimbursement(req);
                break;
            case "/reimbursement.deny":
            case "/ers/reimbursement.deny":
                httpApproveReimbursement(req);
                break;

        }

    }

    public void httpUpdateErsUserUsername(HttpServletRequest req) {

            try {
                String ersUsernameJSON = mapper.readValue(req.getInputStream(), String.class);


            } catch (IOException e) {
                e.printStackTrace();
            }

    }

    public void httpDenyReimbursement(HttpServletRequest req){

    }

    public void httpApproveReimbursement(HttpServletRequest req){

    }

}
