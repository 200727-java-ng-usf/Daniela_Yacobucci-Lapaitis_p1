package com.revature;

import com.revature.repo.ErsReimbursementStatusRepository;
import com.revature.repo.ErsReimbursementTypeRepository;
import com.revature.repo.ErsUserRoleRepository;
import com.revature.repo.ErsUserRepository;
import com.revature.services.ErsUserService;

public class AppDriver {

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
    }
}