package com.revature.ers.exceptions;

public class AuthenticationException extends RuntimeException{

    public AuthenticationException(){
        super("Authentication failed");
    }

    public AuthenticationException(String msg){
        super(msg);
    }
}
