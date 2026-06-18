package lk.rasheeda.ejb;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Stateful;
import jakarta.ejb.Stateless;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import lk.rasheeda.annotation.Console;
import lk.rasheeda.annotation.Email;
import lk.rasheeda.cdi.EmailNotifire;
import lk.rasheeda.cdi.MyService;
import lk.rasheeda.cdi.NotificationService;
import lk.rasheeda.cdi.SMSNotifire;
import lk.rasheeda.ejb.remote.AppSetting;

@Stateless
public class AppSettingSessionBean implements AppSetting {

//    @PostConstruct
//    public void init(){
//        myService = new MyService();
//    } manullay hadanna widiha

    @Inject
    private MyService myService;

//    @Inject
//    private EmailNotifire emailNotifire;
//
//    @Inject
//    private SMSNotifire smsNotifire;

    @Inject
    @Email
    private NotificationService notificationService;

    @Inject
    @Console
    private Event<String> logevent;

    @Override
    public String getName() {
        notificationService.notify("Hello This is app setting session bean");

        logevent.fire("App Session bean : getName");

        //myService.doSomething();
        return "Ecomm EE App";
    }

    @Override
    public String getVersion() {
        return "1.0";
    }

    @Override
    public String getDescription() {
        return "This is the Ecomm EE App setting bean";
    }
}
