package lk.rasheeda.com.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.rasheeda.com.model.User;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String mobile = req.getParameter("mobile");
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        ServletContext context = getServletContext();
        ArrayList<User> users = new ArrayList();

        if (context.getAttribute("users") != null) {
            users = (ArrayList) context.getAttribute("users");
        } else {
            context.setAttribute("users", users);
        }

        if (name != null && mobile != null && email != null && password != null) {

            for (User user : users) {

                if (user.getMobile().equals(mobile) && user.getEmail().equals(email)) {
                    resp.getWriter().write(email + "is already exist");
                    return;
                }
            }

            User user = new User(name, mobile, email, password);
            users.add(user);
            resp.getWriter().write(email + "is registered successfully");
        }else  {
            resp.getWriter().write("Requird Filled cannot be empty");
        }


    }
}
