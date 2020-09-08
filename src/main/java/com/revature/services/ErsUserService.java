package com.revature.services;

import com.revature.exceptions.AuthenticationException;
import com.revature.exceptions.InvalidRequestException;
import com.revature.models.ErsUser;
import com.revature.repo.ErsUserRepository;

import java.util.Optional;

public class ErsUserService {

    private ErsUserRepository ersUserRepo = new ErsUserRepository();

    public Optional<ErsUser> authenticate(String username, String password) {

        Optional<ErsUser> _ersUser = Optional.empty();

        // validate that the provided username and password are not non-values
        if (username == null || username.trim().equals("") || password == null || password.trim().equals("")) {
            throw new InvalidRequestException("Invalid credential values provided!");
        }

        _ersUser = ersUserRepo.findUserByCredentials(username, password);

        return _ersUser;

        //TODO sep app state
        // app.setCurrentUser(authUser);

    }
}
