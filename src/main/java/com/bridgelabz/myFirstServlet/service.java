package com.bridgelabz.myFirstServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class service {
    static final String FIRST_NAME_PATTERN="^[A-Z]{1}[a-zA-Z]{2}[a-zA-z0-9]*";
    static final String PASSWORD_PATTERN="^([a-zA-Z0-9@*#]{8,15})$";

    public static boolean checkFirstName(LoginServlet loginServlet, HttpServletRequest request, HttpServletResponse response, boolean validateFirstName)
            throws IOException, ServletException {
        if (validateFirstName==false){
            RequestDispatcher rd= loginServlet.getServletContext().getRequestDispatcher("/login.jsp");
            PrintWriter out=response.getWriter();
            out.println("<font color=red>user name is Incorrect</font>");
            rd.include(request,response);
            return false;
        }
        return true;
    }
}
