package lk.rasheeda.jms;

import jakarta.jms.*;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class QueueApp {
    public static void main(String[] args) {

        try {
            InitialContext context = new InitialContext();
            QueueConnectionFactory factory =
                    (QueueConnectionFactory) context.lookup("jms/myQueueConnection");

            QueueConnection connection = factory.createQueueConnection();
            connection.start();

            QueueSession session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
            Queue queue = (Queue) context.lookup("myQueue");

            QueueReceiver receiver = session.createReceiver(queue);

            receiver.setMessageListener(new MessageListener() {
                public void onMessage(Message message) {
                    try {

                        String msg = message.getBody(String.class);
                        System.out.println(msg);

                    } catch (JMSException e) {
                        throw new RuntimeException(e);
                    }
                }
            });

        } catch (NamingException | JMSException e) {
            throw new RuntimeException(e);
        }

        while (true){}
    }
}
