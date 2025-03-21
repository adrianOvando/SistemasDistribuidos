/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package multiplicadorx2;
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
public class Server {
    public static void main (String[] Args){
        
         try {
           Multiplicador multiplicador=new Multiplicador();
           LocateRegistry.createRegistry(1099); //levantar el servidor de registro;
          Naming.bind("M",multiplicador);
           
       } catch (RemoteException ex) {
           Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
       } catch (AlreadyBoundException ex) {
           Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
       } catch (MalformedURLException ex) {
           Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
       }
    
    }
}
