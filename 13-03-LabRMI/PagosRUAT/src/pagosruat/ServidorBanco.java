/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pagosruat;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adrian
 */
public class ServidorBanco {
     public static void main(String[] args) throws RemoteException{
         try {
             //LocateRegistry.createRegistry(1099);
             
             IBanco banco = new Banco();
             
             Naming.rebind("banco", banco);
         } catch (MalformedURLException ex) {
             Logger.getLogger(ServidorRuat.class.getName()).log(Level.SEVERE, null, ex);
         }
         
     }
}
