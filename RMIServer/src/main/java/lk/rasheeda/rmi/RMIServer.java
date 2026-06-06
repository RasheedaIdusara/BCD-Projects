package lk.rasheeda.rmi;

import lk.rasheeda.rmi.model.User;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;

public class RMIServer {

    static HashMap<Integer, User> users = new HashMap<>();

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(6666);
            registry.bind("message_service", new MessageImpl());
            registry.bind("user_service", new UserServiceImpl());

            System.out.println("RMI Server Started...");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
