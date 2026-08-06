package lk.rasheeda.ejb;

import jakarta.annotation.Resource;
import jakarta.ejb.*;

@Stateless
public class TimerSessionBean implements TimedObject {

    @Resource
    private TimerService timerService;

    public void createTimer(){
        //System.out.println(timerService);

        timerService.createTimer(10000,"Test Timer");
    }

    //@Timeout
    public void task(){
        System.out.println("Test Timer Task...");
    }

    @Override
    public void ejbTimeout(Timer timer) {
        System.out.println("Test Timer Task implements way(old version)...");

    }
}
