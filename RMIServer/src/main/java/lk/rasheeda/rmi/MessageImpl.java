package lk.rasheeda.rmi;

import lk.rasheeda.rmi.client.Message;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MessageImpl extends UnicastRemoteObject implements Message {

    MessageImpl() throws RemoteException {}

    @Override
    public String hello() throws RemoteException {
        return "hello";
    }
}
