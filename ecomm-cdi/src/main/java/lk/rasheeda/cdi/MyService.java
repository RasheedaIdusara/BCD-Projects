package lk.rasheeda.cdi;

import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class MyService {

    public void doSomething(){
        System.out.println("My Service doSomething..."+this);
    }

}
