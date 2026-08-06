package lk.rasheeda.ejb;

import jakarta.annotation.Resource;
import jakarta.ejb.*;

@Stateless
public class TimerSessionBean{

    @Resource
    private TimerService timerService;

    public void createTimer(){
        //System.out.println(timerService);

        timerService.createTimer(10000L,5000L,"Test Timer");
    }

    @Timeout
    public void task(){
        System.out.println("Test Timer Task...");
    }

}
