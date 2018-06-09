package controller;


import request.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "WelcomeServlet", urlPatterns = "/welcome")
public class WelcomeServlet extends HttpServlet{

    UserService userService = new UserService();


    /**
     * if user not found, redirect user's web browser to login page, otherwise go to the welcome
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("====this is WelcomeServlet");

        String userId = req.getParameter("user");
        User user = userService.findUserById(userId);
        if(user == null)
            resp.sendRedirect("/login");
    }
}
