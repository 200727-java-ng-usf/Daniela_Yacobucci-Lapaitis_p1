package com.revature.ers.util;

import javax.servlet.http.HttpServletRequest;


public class RequestViewHelper {

    public String process(HttpServletRequest req) {

        System.out.println("[Request View Helper] req.getRequestURI() " + req.getRequestURI());

        String principal = (String) req.getSession().getAttribute("principal");

        System.out.println("in helper");

        switch (req.getRequestURI()) {

            //region nav-bars

            case "/loadLoggedOutNavbar.view":
            case "/ers/loadLoggedOutNavbar.view":

                return "partials/navbarpartials/loggedoutnavbar.html";

            case "/loadLoggedInNavbar.view":
            case "/ers/loadLoggedInNavbar.view":
                if (principal == null || principal.equals("")) {
                    return "partials/navbarpartials/loggedoutnavbar.html";
                }

                return "partials/navbarpartials/loggedinnavbar.html";

                //endregion

            //region logged-out-views

            case "/login.view":
            case "/ers/login.view":

                return "partials/login.html";

            case "/register.view":
            case "/ers/register.view":
                return "partials/register.html";

            //endregion

            //region logged-in-for-all-views

            case "/profile.view":
            case "/ers/profile.view":


                if (principal == null || principal.equals("")) {
                    return "partials/login.html";
                }

                return "partials/profile.html";

            //endregion

            //region employee-views

            case "/employeeHome.view":
            case "/ers/employeeHome.view":

                if (principal == null || principal.equals("")) {
                    return "partials/employee/partialNotAllowed.html";
                    //TODO change file name to page not allowed, need to change tomcat issue though
                }

                return "partials/employee/employeeHome.html";

            case "/myReimbursements.view":
            case "/ers/myReimbursements.view":

                System.out.println("myReimbursements case");

                return "partials/employee/myreimbursements.html";

            case "/submitReimbursement.view":
            case "/ers/submitReimbursement.view":

                return "partials/employee/submitreimbursement.html";

            case "/updateReimbursements.view":
            case "/ers/updateReimbursements.view":

                return "partials/employee/updatereimbursement.html";


            //endregion

            //region admin-views

            case "/adminHome.view":
            case "/ers/adminHome.view":

                if (principal == null || principal.equals("")) {
                    return "partials/employee/partialNotAllowed.html";
                }

                return "partials/admin/adminHome.html";

            case "/addNewUsers.view":
            case "/ers/addNewUsers.view":
                //TODO check for user logged in and role
                return "partials/admin/add-new-user.html";

            case "/loadViewUsers.view":
            case "/ers/loadViewUsers.view":

                System.out.println("in correct case");

                return "partials/admin/view-users.html";

            //endregion

            //region finance-manager-views

            case "/financeManagerHome.view":
            case "/ers/financeManagerHome.view":

                if (principal == null || principal.equals("")) {
                    return "partials/employee/partialNotAllowed.html";
                }

                return "partials/financeManager/financeManagerHome.html";

            case "/allReimbursements.view":
            case "/ers/allReimbursements.view":

                return "partials/financeManager/load-all-reimbursements.html";

            case "/approveOrDenyReimbursements.view":
            case "/ers/approveOrDenyReimbursements.view":

                return "partials/financeManager/approve-or-deny-reimbursements.html";
                //TODO warning pop up on html page if id not found

            //endregion

            default:

                return "partials/badlogin.html";
                //TODO change file name to page not found

        }

    }
}