/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package operaciones;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Adrian
 */
public interface IOperacion extends Remote{
    

    public int setN(int n) throws RemoteException;
    public int Factorial(int n) throws RemoteException;
    public int Fibonacci(int n) throws RemoteException;
    public int Sumatoria(int n) throws RemoteException;
}
