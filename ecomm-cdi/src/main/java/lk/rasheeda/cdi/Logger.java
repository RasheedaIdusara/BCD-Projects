package lk.rasheeda.cdi;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import lk.rasheeda.annotation.Console;

@ApplicationScoped
public class Logger {
    public void log(@Observes String message) {
        System.out.println("Logger : "+ message);
    }

    public void consolelog(@Observes @Console String message) {
        System.out.println("console Logger : "+ message);
    }
}
