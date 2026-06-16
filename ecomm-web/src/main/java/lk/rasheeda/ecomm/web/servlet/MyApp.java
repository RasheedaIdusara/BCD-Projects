package lk.rasheeda.ecomm.web.servlet;

import jakarta.enterprise.context.SessionScoped;

import java.io.Serializable;

@SessionScoped
public class MyApp implements Serializable {
    public void doSomething()
    {
        System.out.println("My App doSomething..."+this);
    }
}
