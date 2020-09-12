package com.revature.ers.servlets;

import com.revature.ers.util.RequestViewHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("*.view")
public class ViewServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("In the following servlet: " + this.getClass());
        System.out.println("This is the request: " + req);
        String nextView = new RequestViewHelper().process(req);
        req.getRequestDispatcher(nextView).forward(req, resp);

    }
}

//TODO web.xml remove html from before index.html possibly
/*
similar to the following previous master servlet



package com.revature.ers.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="/ers/*")
public class MasterServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(RequestHelper.process(req)).forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(RequestHelper.process(req)).forward(req, resp);
    }

}



 */
//TODO remove above comment
