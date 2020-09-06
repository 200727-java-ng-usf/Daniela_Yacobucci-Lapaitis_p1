package com.revature.services;

import com.revature.exceptions.AuthenticationException;
import com.revature.exceptions.InvalidRequestException;
import com.revature.models.ErsUser;
import com.revature.repo.ErsUserRepository;

public class ErsUserService {

    private ErsUserRepository ersUserRepo = new ErsUserRepository();

    public void authenticate(String username, String password) {

        // validate that the provided username and password are not non-values
        if (username == null || username.trim().equals("") || password == null || password.trim().equals("")) {
            throw new InvalidRequestException("Invalid credential values provided!");
        }

        ErsUser authUser = ersUserRepo.findUserByCredentials(username, password)
                .orElseThrow(AuthenticationException::new);

        //TODO sep app state
        // app.setCurrentUser(authUser);

    }
}
