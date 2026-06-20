package lk.rasheeda.jms;

import jakarta.annotation.Resource;
import jakarta.ejb.Remote;
import jakarta.jms.*;
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

    @Resource(lookup = "jms/__defaultConnectionFactory")
    private ConnectionFactory connectionFactory;

    @Resource(lookup = "myTopic")
    private Topic topic;


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().println("jms");
        try {

//            InitialContext context = new InitialContext();
//
//            ConnectionFactory factory =
//                    (ConnectionFactory) context.lookup("jms/__defaultConnectionFactory");

            Connection connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            //Topic topic = (Topic) context.lookup("myTopic");

//            Topic topic = session.createTopic("myTopic");

            MessageConsumer consumer = session.createConsumer(topic);

            consumer.setMessageListener(new MessageListener() {
                public void onMessage(Message message) {
                    try {
                        System.out.println(message.getBody(String.class));
                    } catch (JMSException e) {
                        throw new RuntimeException(e);
                    }
                }
            });




        }  catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}
