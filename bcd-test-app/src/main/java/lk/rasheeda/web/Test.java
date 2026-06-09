package lk.rasheeda.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;

@WebServlet("/test")
public class Test extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            InitialContext ic = new InitialContext();
            lk.rasheeda.web.Cal cal = (Cal) ic.lookup("java:global/BCD-WebApp/CalImpl!lk.rasheeda.web.Cal");
            cal.getResult(40,60);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
