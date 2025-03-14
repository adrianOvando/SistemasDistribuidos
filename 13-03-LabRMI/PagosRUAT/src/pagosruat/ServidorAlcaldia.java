/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pagosruat;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.Naming;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Adrian
 */
public class ServidorAlcaldia {
    
    public static void main (String[] args){
        
        try {
            LocateRegistry.createRegistry(1099);
            IAlcaldia alcaldia = new Alcaldia();
            try {
                Naming.rebind("alcaldia", alcaldia);
                System.out.print("Servidor de alcaldia listo...");
                
            } catch (MalformedURLException ex) {
                Logger.getLogger(ServidorAlcaldia.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(ServidorAlcaldia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
