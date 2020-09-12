package com.revature.ers.servlets;

import com.revature.ers.util.DatabaseHelper;
import com.revature.ers.util.RequestViewHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("*.database")
public class DatabaseValuesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("This is the request: " + req);
        String nextView = new DatabaseHelper().process(req);//TODO implement
        req.getRequestDispatcher(nextView).forward(req, resp);
    }
}
