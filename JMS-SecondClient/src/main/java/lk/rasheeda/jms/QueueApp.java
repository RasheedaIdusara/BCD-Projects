package lk.rasheeda.jms;

import jakarta.jms.*;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Scanner;

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

            QueueSender sender = session.createSender(queue);

            for (int i = 1; i <= 100; i++) {
                TextMessage textMessage = session.createTextMessage();
                textMessage.setText(" Hello World "+i);
                sender.send(textMessage);

                Thread.sleep(500);
            }

//            Scanner scanner = new Scanner(System.in);
//            System.out.println("Enter message or Type 'exit' to quit.");
//
//            while (true) {
//                String line = scanner.nextLine();
//                if (line.equalsIgnoreCase("exit")) {
//                    break;
//                }
//
//                TextMessage textMessage = session.createTextMessage();
//
//                textMessage.setText(line);
//
//                sender.send(textMessage);
//            }

        } catch (NamingException | JMSException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
