package com.revature.ers.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.ers.dtos.ErrorResponse;
import com.revature.ers.util.DatabaseRequestHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("*.database")
public class DatabaseValuesServlet extends HttpServlet {

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
        resp = new DatabaseRequestHelper().process(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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
        resp = new DatabaseRequestHelper().process(req,resp);
        //req.getRequestDispatcher(nextView).forward(req, resp);//change this so that the specific page gets the response
    }
}
