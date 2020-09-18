package com.revature.ers.services;

import com.revature.ers.exceptions.AuthenticationException;
import com.revature.ers.exceptions.InvalidRequestException;
import com.revature.ers.models.ErsUser;
import com.revature.ers.repo.ErsUserRepository;

import java.util.List;

public class ErsUserService {

    private ErsUserRepository ersUserRepo = new ErsUserRepository();

    public ErsUser authenticate(String username, String password) {

        ErsUser ersUser;

        // validate that the provided username and password are not non-values
        if (username == null || username.trim().equals("") || password == null || password.trim().equals("")) {
            throw new InvalidRequestException("Invalid credential values provided!");
        }

        //ersUser = ersUserRepo.findUserByCredentials(username, password).get();
        //return ersUser;
        //TODO add this change to notes

        return ersUserRepo.findUserByCredentials(username, password)
                .orElseThrow(AuthenticationException::new);

        //TODO sep app state
        // app.setCurrentUser(authUser);

    }

    public boolean isUsernameAvailable(String username) {

        if(ersUserRepo.findUserByUsername(username).isPresent()){
            return false;
        }
        return true;
    }

    public boolean isEmailAvailable(String email) {

        if(ersUserRepo.findUserByEmail(email).isPresent()){
            return false;
        }

        return true;
    }

    public ErsUser findUserByUsername(String username){
        return ersUserRepo.findUserByUsername(username)
                .orElseThrow(AuthenticationException::new);
    }

//    public void softDeleteUser(ErsUser ersUser){
//
//        boolean result = ersUserRepo.changeRoleToInactive(ersUser);
//
//    }

    public List<ErsUser> getAllUsers(){
        return ersUserRepo.getAllErsUsers()
                .orElseThrow(AuthenticationException::new);
    }

    public void softDeleteUserById(int id){

        ersUserRepo.changeRoleToInactiveById(id);

    }

    //TODO add register method
}
