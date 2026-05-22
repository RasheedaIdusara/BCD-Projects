package lk.rasheeda.rmi.client;

import lk.rasheeda.rmi.model.Data;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Message extends Remote {
    public String hello() throws RemoteException;
    public Data getData() throws RemoteException;
}
