package lk.rasheeda.ejb;

import jakarta.ejb.Singleton;
import lk.rasheeda.ejb.remote.AppSetting;

@Singleton
public class AppSettingSessionBean implements AppSetting {
    @Override
    public String getName() {
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
