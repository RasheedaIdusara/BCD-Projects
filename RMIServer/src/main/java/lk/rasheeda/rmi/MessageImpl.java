package lk.rasheeda.rmi;

import lk.rasheeda.rmi.client.Message;
import lk.rasheeda.rmi.model.Data;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MessageImpl extends UnicastRemoteObject implements Message {

    MessageImpl() throws RemoteException {}

    @Override
    public String hello() throws RemoteException {
        return "hello";
    }

    @Override
    public Data getData() throws RemoteException {

        return new Data(10,"App Version");
    }
}
