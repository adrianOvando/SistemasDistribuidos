/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package multiplicadorx2;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adrian
 */
public class Cliente {
    public static void main (String[] Args){
        IMultiplicador multiplicador;
        Scanner sc=new Scanner(System.in);
        try { 
           multiplicador=(IMultiplicador)Naming.lookup("rmi://localhost/M");
           
           System.out.println("introduzca un valor");
           int n= sc.nextInt();
           System.out.print("El valor multiplicadopor 2 es "+multiplicador.multiplicar2(n));
           
       } catch (NotBoundException ex) {
           Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
       } catch (MalformedURLException ex) {
           Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
       } catch (RemoteException ex) {
           Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
}
