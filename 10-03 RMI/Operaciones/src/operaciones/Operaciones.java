/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operaciones;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Adrian
 */
public class Operaciones extends UnicastRemoteObject implements IOperacion{
    public Operaciones() throws RemoteException{
        super();
    } 

    @Override
    public int setN(int n) throws RemoteException {
        return n;
    }

    @Override
    public int Factorial(int n) throws RemoteException {
        int resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }

    @Override
    public int Fibonacci(int n) throws RemoteException {
        int a = 0, b = 1;
        for (int i = 2; i < n; i++) {
            int siguiente = a + b;
            a = b;
            b = siguiente;
        }
        return b;
    }

    @Override
    public int Sumatoria(int n) throws RemoteException {
        int resultado = (n * (n + 1)) / 2;
        return resultado;
    }

   
}
