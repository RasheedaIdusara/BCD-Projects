package lk.rasheeda.ecomm.user.bean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.Stateless;
import lk.rasheeda.ecomm.user.remote.TestRemote;

@Stateless
public class TestRemoteBean implements TestRemote {

    int i;

    @PostConstruct
    public void init() {
        System.out.println("TestRemoteBean init");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("TestRemoteBean destroy");
    }

//    public TestRemoteBean(){
//        System.out.println("TestRemoteBean created"+this);
//    }

    @Override
    public String test() {

        i++;

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return ("TestSessionBean : test()"+i);

    }
}
