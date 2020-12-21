package com.bridgelabz.myFirstServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.regex.Pattern;

public class Validate implements Serializable {
    public Validate() {
    }

    public boolean validateFirstName(String firstName) {
        Pattern check = Pattern.compile(service.FIRST_NAME_PATTERN);
        boolean value = check.matcher(firstName).matches();
        return value;
    }

    public static boolean checkPassword(LoginServlet loginServlet, HttpServletRequest request, HttpServletResponse response, boolean validateFirstName)
            throws IOException, ServletException {
        if (validateFirstName == false) {
            RequestDispatcher rd = loginServlet.getServletContext().getRequestDispatcher("/login.jsp");
            PrintWriter out = response.getWriter();
            out.println("<font color=red>Password is Incorrect</font>");
            rd.include(request, response);
            return false;
        }
        return true;
    }

    public boolean validatePassword(String firstName) {
        Pattern check = Pattern.compile(service.PASSWORD_PATTERN);
        boolean value = check.matcher(firstName).matches();
        return value;
    }
}