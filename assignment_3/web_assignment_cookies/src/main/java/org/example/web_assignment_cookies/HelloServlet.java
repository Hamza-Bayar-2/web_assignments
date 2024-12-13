package org.example.web_assignment_cookies;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String phone_number = request.getParameter("phone_number");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");

        if (remember != null) {
            addingCookie(response, email, name, surname, phone_number, password, remember);
        } else {
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
        }

        PrintWriter writer = response.getWriter();

        String htmlRespone = "<html>";
        htmlRespone += "<h2>Your name is: " + name + " " + surname + "<br/>";
        htmlRespone += "Your E-mail: " + email + "<br/>";
        htmlRespone += "Your Phone Number: " + phone_number + "<br/>";
        htmlRespone += "Your password is: " + password + "<br/>";
        htmlRespone += "remember value: " + remember + "</h2>";
        htmlRespone += "<h2><a href=\"index.jsp\">Go Back</a></h2>";
        htmlRespone += "</html>";

        writer.println(htmlRespone);
        writer.close();
    }

    protected void addingCookie(HttpServletResponse response,
                               String email,
                               String name,
                               String surname,
                               String phone_number,
                               String password,
                               String remember){

        Cookie mailCookie = new Cookie("email", email);
        Cookie nameCookie = new Cookie("name", name);
        Cookie surnameCookie = new Cookie("surname", surname);
        Cookie numberCookie = new Cookie("phone_number", phone_number);
        Cookie passwordCookie = new Cookie("password", password);
        Cookie rememberCookie = new Cookie("remember", remember);

        response.addCookie(mailCookie);
        response.addCookie(nameCookie);
        response.addCookie(surnameCookie);
        response.addCookie(numberCookie);
        response.addCookie(passwordCookie);
        response.addCookie(rememberCookie);
    }
}