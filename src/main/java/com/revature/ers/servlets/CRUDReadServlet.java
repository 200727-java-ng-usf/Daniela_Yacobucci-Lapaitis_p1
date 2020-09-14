package com.revature.ers.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.dtos.ErrorResponse;
import com.revature.ers.util.CRUDReadRequestHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("*.read")
public class CRUDReadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        PrintWriter respWriter = resp.getWriter();
        resp.setContentType("application/json");

        String principalJSON = (String) req.getSession().getAttribute("principal");


        if (principalJSON == null) {
            ErrorResponse err = new ErrorResponse(401, "No principal object found on request.");
            respWriter.write(mapper.writeValueAsString(err));
            resp.setStatus(401);
            return;
        }

        System.out.println("In the following servlet " + this.getClass());
        System.out.println("This is the request URI: " + req.getRequestURI());
        respWriter.write(new CRUDReadRequestHelper().process(req));
        resp.setStatus(200);
        //TODO check of 200 status is appropriate
    }

}
