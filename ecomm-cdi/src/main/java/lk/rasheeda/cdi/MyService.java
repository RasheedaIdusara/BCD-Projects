package lk.rasheeda.cdi;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;

import java.io.Serializable;

@ApplicationScoped
public class MyService implements Serializable {

    public void doSomething(){
        System.out.println("My Service doSomething..."+this);
    }

}
