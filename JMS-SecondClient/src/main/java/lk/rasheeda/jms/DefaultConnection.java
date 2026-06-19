package lk.rasheeda.jms;

import jakarta.jms.*;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class DefaultConnection {
    public static void main(String[] args) {
        try {

            InitialContext context = new InitialContext();

            ConnectionFactory factory =
                    (ConnectionFactory) context.lookup("jms/__defaultConnectionFactory");

            Connection connection = factory.createConnection();
            connection.start();

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

//            Topic topic = (Topic) context.lookup("myTopic");
            Topic topic = session.createTopic("abcd");

            MessageProducer producer = session.createProducer(topic);


            for (int i = 1; i <= 10; i++) {
                TextMessage textMessage = session.createTextMessage();
                textMessage.setText("Hello World");
                producer.send(textMessage);
            }




        } catch (NamingException e) {
            throw new RuntimeException(e);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}
