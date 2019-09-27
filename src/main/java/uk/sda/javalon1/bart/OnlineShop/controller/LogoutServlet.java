package uk.sda.javalon1.bart.OnlineShop.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //downloading cookies
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            //if the cookie name is user_cookie, set its age to 0
            if (cookie.getName().equals("user_cookie")) {
                cookie.setMaxAge(0);
                resp.addCookie(cookie);
            }
        }
        //redirect to log.js
        resp.sendRedirect("log.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}