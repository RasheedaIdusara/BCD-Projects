package lk.rasheeda.ecomm.web.servlet;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lk.rasheeda.ecomm.user.dto.UserDTO;
import lk.rasheeda.ecomm.user.remote.TestRemote;
import lk.rasheeda.ecomm.user.remote.UserRemote;
import lk.rasheeda.ejb.remote.AppSetting;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/test", loadOnStartup = 1)
public class Test extends HttpServlet {

    @EJB(lookup = "java:global/ecomm-user-1.0/TestNewRemoteBean!lk.rasheeda.ecomm.user.remote.TestRemote") //J2EE 5 +
    private TestRemote testRemote;

    @EJB
    private AppSetting appSetting;


    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("Web Servlet init");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Ecomm web module Test...");

        testRemote.test();

        resp.getWriter().write("APP Name:" + appSetting.getName());

    }
}
