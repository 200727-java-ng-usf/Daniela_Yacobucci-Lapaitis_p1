package com.revature.ers.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.models.ErsReimbursementStatus;
import com.revature.ers.models.ErsUser;
import com.revature.ers.services.ErsReimbursementService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CRUDUpdateRequestHelper {

    ObjectMapper mapper = new ObjectMapper();
    ErsReimbursementService ersReimbursementService = new ErsReimbursementService();

    public void process(HttpServletRequest req) throws IOException {


        System.out.println("[CRUDUpdateRequestHelper] req.getRequestURI() " + req.getRequestURI());
        //String ersUserJSON = mapper.readValue(req.getInputStream(), String.class);
        //ErsUser ersUser = ErsUser.JSONtoObj(ersUserJSON);

        switch (req.getRequestURI()) {
            case "/user.updateUsername":
            case "/ers/user.updateUsername":
                httpUpdateErsUserUsername(req);
                break;
            case "/reimbursement.updateStatus":
            case "/ers/reimbursement.updateStatus":
                httpUpdateReimbursementStatusById(req);
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

    public void httpUpdateReimbursementStatusById(HttpServletRequest req){

        try {

            Map<String, Object> response = mapper.readValue(req.getInputStream(), HashMap.class);
            int id = Integer.parseInt(response.get("id").toString());
            String newStatus = response.get("status").toString();
            ersReimbursementService.changeReimbursementStatusByReimbId(id, newStatus);


            //ersReimbursementService.setReimbursementStatusToDeniedById(Integer.parseInt(id));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException nfe){
            nfe.printStackTrace();
        }
            //TODO js approve or deny reimb, handle it staying pending
        //TODO make error responses

    }

    public void httpApproveReimbursementById(HttpServletRequest req){



        //ersReimbursementService.changeReimbursementStatusByReimbId();

        ersReimbursementService.changeReimbursementStatusByReimbId(3,"Approved");

    }

}
