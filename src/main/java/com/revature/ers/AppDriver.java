package com.revature.ers;

import com.revature.ers.repo.ErsUserRepository;
import com.revature.ers.services.ErsUserService;

public class AppDriver {

    //TODO will be removed, currently here for testing purposes

    public static void main(String[] args) {

        ErsUserService userService = new ErsUserService();

        ErsUserRepository userRepo = new ErsUserRepository();

        System.out.println(userRepo.findUserByCredentials("meghvu","clowntime").get());
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