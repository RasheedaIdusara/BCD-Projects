package lk.rasheeda.client;

import lk.rasheeda.ecomm.user.remote.TestRemote;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws NamingException {
        System.out.println("Client Application Starting ...");

        try {

            Properties props = new Properties();
            props.setProperty(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
            props.setProperty(Context.PROVIDER_URL,"iiop://localhost:3700");

            InitialContext ic = new InitialContext(props);

//            TestRemote testRemote = (TestRemote) ic.lookup("java:global/ecomm-user-1.0/TestRemoteBean");
//            testRemote.test();

            ic.rebind("Name","Rasheeda");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
