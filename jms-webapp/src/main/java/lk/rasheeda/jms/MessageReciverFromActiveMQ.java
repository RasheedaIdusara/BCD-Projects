package lk.rasheeda.jms;

import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationType",propertyValue = "jakarta.jms.Topic"),
        @ActivationConfigProperty(propertyName = "destinationLookup",propertyValue = "activemq-topic"),
        @ActivationConfigProperty(propertyName = "destination",propertyValue = "activemq-topic"),
        @ActivationConfigProperty(propertyName = "resourceAdapter",propertyValue = "activemq-rar-6.2.6"),

})
public class MessageReciverFromActiveMQ implements MessageListener {
    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("Message Recieved from ActiveMQ : " + message.getBody(String.class));
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}
