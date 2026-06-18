package lk.rasheeda.cdi;

import jakarta.enterprise.context.Dependent;
import lk.rasheeda.annotation.Email;

@Email
@Dependent
public class EmailNotifire implements NotificationService {
    @Override
    public void notify(String message) {
        System.out.println("Email Notified by " + message);
    }
}
