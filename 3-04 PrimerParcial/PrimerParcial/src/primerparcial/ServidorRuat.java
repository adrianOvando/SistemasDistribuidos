/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primerparcial;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adrian
 */
public class ServidorRuat {
         public static void main(String[] args) throws RemoteException{
         try {
             LocateRegistry.createRegistry(1099);
             IRuat ruat = new Ruat();
             Naming.rebind("ruat", ruat);
         } catch (MalformedURLException ex) {
             Logger.getLogger(ServidorRuat.class.getName()).log(Level.SEVERE, null, ex);
         }
         
     }
}
