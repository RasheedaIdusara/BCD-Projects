package lk.rasheeda.jms;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destinationLookup",propertyValue = "myTopic")
})
public class MessageReciver implements MessageListener {

    @PostConstruct
    public void init(){
        System.out.println("MessageReciver init");
    }

    @Override
    public void onMessage(Message message) {

        try {
            System.out.println("MessageReciver onMessage : "+message.getBody(String.class));
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}
