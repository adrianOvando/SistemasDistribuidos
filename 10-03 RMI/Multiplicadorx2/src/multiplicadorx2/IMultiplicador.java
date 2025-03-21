/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package multiplicadorx2;
import java.rmi.Remote;
import java.rmi.RemoteException;
/**
 *
 * @author Adrian
 */
public interface IMultiplicador extends Remote{
    public int multiplicar2(int n) throws RemoteException;
}
