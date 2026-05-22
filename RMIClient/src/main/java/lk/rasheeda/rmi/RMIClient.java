package lk.rasheeda.rmi;

import lk.rasheeda.rmi.client.Message;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {
    public static void main(String[] args) {

        try {
            Registry registry = LocateRegistry.getRegistry("localhost",6666);
            String[] list = registry.list();

            for (String str : list) {
                System.out.println(str);
            }

            Message massage =(Message) registry.lookup("message_service");
            java.lang.String message = massage.hello();

            System.out.println(message);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
