package lk.rasheeda.ecomm.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lk.rasheeda.ecomm.user.dto.UserDTO;
import lk.rasheeda.ecomm.user.remote.TestRemote;
import lk.rasheeda.ecomm.user.remote.UserRemote;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.util.List;

@WebServlet("/test")
public class Test extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Ecomm web module Test...");

        try {

            TestRemote tr;

            HttpSession session = req.getSession();

//            if (session.getAttribute("testbean") == null) {
                InitialContext ic = new InitialContext();
                tr = (TestRemote) ic.lookup("java:global/ecomm-user-1.0/TestRemoteBean");

//                session.setAttribute("testbean", tr);
//            } else {
//                tr = (TestRemote) session.getAttribute("testbean");
//            }


            String test = tr.test();
            resp.getWriter().write("Result:" + test);

//            tr.remove();
//            session.removeAttribute("testbean");


//            List<UserDTO> allUsers = userRemote.getAllUsers();
//            for (UserDTO user : allUsers) {
//                user.toString();
//            }


        } catch (NamingException e) {
            throw new RuntimeException(e);
        }

    }
}
