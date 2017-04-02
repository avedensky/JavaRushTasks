package com.javarush.task.task32.task3207;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DoubleString extends Remote {
    String doubleString(String str) throws RemoteException;
}