package lk.rasheeda.rmi.model;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class Data implements Remote, Serializable {

    private int id;
    private String name;

    public Data() throws RemoteException {
    }

    public Data(int id, String name) throws RemoteException {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
