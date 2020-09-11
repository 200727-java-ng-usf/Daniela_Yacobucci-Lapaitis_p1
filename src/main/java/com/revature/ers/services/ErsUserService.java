package com.revature.ers.services;

import com.revature.ers.exceptions.AuthenticationException;
import com.revature.ers.exceptions.InvalidRequestException;
import com.revature.ers.models.ErsUser;
import com.revature.ers.repo.ErsUserRepository;

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

        //TODO implement isUsernaveAvailable
        return true;
    }

    public boolean isEmailAvailable(String email) {

        //TODO implement isEmailAvailable
        return true;
    }

    //TODO add register method
}
