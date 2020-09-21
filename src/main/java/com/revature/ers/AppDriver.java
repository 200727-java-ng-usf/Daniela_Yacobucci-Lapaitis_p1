package com.revature.ers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.models.ErsReimbursement;
import com.revature.ers.repo.ErsReimbursementRepository;
import com.revature.ers.repo.ErsUserRepository;
import com.revature.ers.services.ErsReimbursementService;
import com.revature.ers.services.ErsUserService;

import java.util.HashMap;
import java.util.Map;

public class AppDriver {

    //TODO will be removed, currently here for testing purposes

    public static void main(String[] args) {


        ErsReimbursementService reimbService = new ErsReimbursementService();
        ErsUserService userService = new ErsUserService();


        //System.out.println(userService.findUserById(6));

        //System.out.println(reimbService.getReimbursementsByAuthorUsername(""));




//    String JSONTest = "{ \"username\": \"meghvu\", \"password\": \"clowntime\" }";

//        try {
//            Map<String, Object> response = new ObjectMapper().readValue(JSONTest, HashMap.class);
//            String username = response.get("username").toString();
//            System.out.println(username);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }

//        ErsUserService userService = new ErsUserService();
//
        //ErsUserRepository userRepo = new ErsUserRepository();

        //ErsReimbursementService rembService = new ErsReimbursementService();

        //ErsReimbursementRepository reimbRepo = new ErsReimbursementRepository();

        //reimbRepo.getAllReimbursements();

        //System.out.println(rembService.getAllReimbursements());

        //userRepo.changeRoleToInactiveById(788);

//
//        System.out.println(userRepo.findUserByCredentials("meghvu","clowntime").get());
        // System.out.println(userService.authenticate("meghvu","clowntime").get());
//
//        ErsReimbursementTypeRepository.printErsReimbursementTypes();
//        ErsUserRoleRepository.printErsUserRoles();
//        ErsUserRepository.printErsUsers();
//        ErsUserRepository.printErsUsersCriteria();
//        ErsUserRepository.deleteUserByUsername("ppalotes");
//
//        userService.authenticate("yoo","aa");

        //TODO check whether user can get to ... for example home... thru url
        //TODO change black at top to fill
        //TODO change colors of nav bar
        //TODO do a while(undefined) in JS configureprofileview to be able to use getuserinfo
    }
}