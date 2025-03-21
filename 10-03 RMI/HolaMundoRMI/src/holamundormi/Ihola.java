/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package holamundormi;
import java.rmi.Remote;
import java.rmi.Server.UnicastRemoteObject;
/**
 *
 * @author Adrian
 */
public class Ihola extends UnicastRemoteObject implements Hola {
    public Hola() throws RemoteException{
        super();
    }

    @Override
    public String Saludar() throws RemoteException{
        return "Hola mundo";
    }
    
}
