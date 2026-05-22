package lk.rasheeda.rmi;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(6666);
            registry.bind("message_service", new MessageImpl());

            System.out.println("RMI Server Started...");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
