package lk.rasheeda.ejb;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Stateful;
import jakarta.inject.Inject;
import lk.rasheeda.cdi.MyService;
import lk.rasheeda.ejb.remote.AppSetting;

@Singleton
public class AppSettingSessionBean implements AppSetting {

//    @PostConstruct
//    public void init(){
//        myService = new MyService();
//    } manullay hadanna widiha

    @Inject
    private MyService myService;

    @Override
    public String getName() {
        myService.doSomething();
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
