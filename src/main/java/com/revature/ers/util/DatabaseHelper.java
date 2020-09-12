package com.revature.ers.util;

import javax.servlet.http.HttpServletRequest;

public class DatabaseHelper {

    public String process(HttpServletRequest req) {

        System.out.println("[Request View Helper] req.getRequestURI() " + req.getRequestURI());

        switch(req.getRequestURI()){
            case "/userinfo.database":
            case "/ers/userinfo.database":
                //get principal's info


        }
        return "";

    }

}
