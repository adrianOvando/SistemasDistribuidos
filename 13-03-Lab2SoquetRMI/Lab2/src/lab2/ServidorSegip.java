/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adrian
 */
public class ServidorSegip {
     public static void main(String[] args) {
        try {
            Segip segip = new Segip();
            LocateRegistry.createRegistry(1090); // Puerto 1090
            Naming.bind("rmi://localhost:1090/Segip", segip); // Registra en el puerto 1090
            System.out.println("Servidor SEGIP listo en puerto 1090...");
        } catch (Exception ex) {
            Logger.getLogger(ServidorSegip.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
