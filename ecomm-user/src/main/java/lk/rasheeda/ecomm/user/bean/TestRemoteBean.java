package lk.rasheeda.ecomm.user.bean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.*;
import lk.rasheeda.ecomm.user.remote.TestRemote;

@Singleton
@Startup
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

    @PostActivate
    public void postActivate() {
        System.out.println("TestRemoteBean postActivate");
    }

    @PrePassivate
    public void prePassivate() {
        System.out.println("TestRemoteBean prePassivate");
    }

    @Remove
    public void remove() {
        System.out.println("TestRemoteBean remove");
    }

//    public TestRemoteBean(){
//        System.out.println("TestRemoteBean created"+this);
//    }

    @Override
    @Lock(LockType.WRITE)
    public String test() {

        for (int i = 0; i < 10; i++) {
            this.i++;
        }



        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return ("TestSessionBean : test()"+i);

    }
}
