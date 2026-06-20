package lk.rasheeda.mq;

import jakarta.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;

public class MessageSender {

    public static void main(String[] args) {
        ActiveMQConnectionFactory connectionFactory
                = new ActiveMQConnectionFactory("tcp://localhost:61616");

        try {

            Connection connection = connectionFactory.createConnection();
            connection.start();

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Topic topic = session.createTopic("news");

            MessageProducer producer = session.createProducer(topic);
            TextMessage textMessage = session.createTextMessage("Hello World");
            producer.send(textMessage);

            producer.close();
            session.close();
            connection.close();


        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }

}
