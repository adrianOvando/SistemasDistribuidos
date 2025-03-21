/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package multiplicadorx2;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
/**
 *
 * @author Adrian
 */
public class Multiplicador extends UnicastRemoteObject implements IMultiplicador{
    public Multiplicador() throws RemoteException{
        super();
    }  

    @Override
    public int multiplicar2(int n) throws RemoteException {
        return n*2;
    }
}
