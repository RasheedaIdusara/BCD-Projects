package lk.rasheeda.jms;

import jakarta.jms.*;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try {

            InitialContext context = new InitialContext();
            TopicConnectionFactory factory =
                    (TopicConnectionFactory) context.lookup("myTopicConnectionFactory");

            TopicConnection connection = factory.createTopicConnection();
            connection.start();

            TopicSession session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
            Topic topic = (Topic) context.lookup("myTopic");

            TopicPublisher publisher = session.createPublisher(topic);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter message or Type 'exit' to quit.");

            while (true) {
                String line = scanner.nextLine();
                if (line.equalsIgnoreCase("exit")) {
                    break;
                }

                TextMessage textMessage = session.createTextMessage();

//                textMessage.setText("Hello This is First Message");
                textMessage.setText(line);

                publisher.publish(textMessage);
            }




        } catch (NamingException | JMSException e) {
            throw new RuntimeException(e);
        }
    }
}
