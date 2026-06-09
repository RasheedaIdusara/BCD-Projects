package lk.rasheeda.web;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import lk.rasheeda.ejb.remote.UserDetails;

import javax.naming.InitialContext;
import java.io.IOException;

@WebServlet("/a")
public class A extends HttpServlet {

    @EJB
    Cal cal;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        res.getWriter().println("This is a me");
        m();
        //cal.getResult(10,20);

        try {
            InitialContext ic = new InitialContext();
            UserDetails userDetails = (UserDetails) ic.lookup("java:global/ejb-module/UserDetailsimpl");

            res.getWriter().write(String.valueOf(userDetails.getUsername()));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void m(){
        System.out.println("Hi");
    }
}
