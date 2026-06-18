package lk.rasheeda.cdi;

import jakarta.enterprise.context.Dependent;
import lk.rasheeda.annotation.SMS;

@SMS
@Dependent
public class SMSNotifire implements NotificationService {
    @Override
    public void notify(String message) {
        System.out.println("SMS Notified by " + message);
    }
}
