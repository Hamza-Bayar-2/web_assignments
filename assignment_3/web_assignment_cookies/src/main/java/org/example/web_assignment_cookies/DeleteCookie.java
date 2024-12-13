package org.example.web_assignment_cookies;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "deleteCookie", value = "/delete-cookie")
public class DeleteCookie extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
        PrintWriter writer = response.getWriter();

        String htmlRespone = "<html>";
        htmlRespone += "<h2>you are successfully logged out!<br/>";
        htmlRespone += "<a href=\"index.jsp\">Go Back</a></h2>";
        htmlRespone += "</html>";

        writer.print(htmlRespone);
        writer.close();
    }
}
