package lk.rasheeda.jta;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/test")
public class Test extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            EntityManagerFactory entityManagerFactory
                    = Persistence.createEntityManagerFactory("JTA-PU");

            EntityManager entityManager = entityManagerFactory.createEntityManager();

            System.out.println(entityManager);



    }
}
