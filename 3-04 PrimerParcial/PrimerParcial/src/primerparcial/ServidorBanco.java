/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primerparcial;

import java.io.*;
import java.net.*;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;


/**
 *
 * @author Adrian
 */
public class ServidorBanco {

    private static IRuat ruat;
    
    public static void main(String[] args) {
        try {
            ruat = (IRuat) Naming.lookup("rmi://localhost/ruat");
        } catch (Exception e) {
            System.out.println("Error conectando al RUAT: " + e.getMessage());
            return;
        }
        
        int port = 5002;
        try (ServerSocket server = new ServerSocket(port)) {
            
            while (true) {
                try (Socket client = server.accept();
                     ObjectInputStream ois = new ObjectInputStream(client.getInputStream()); //recive//
                     ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream())) {
                    
                    System.out.println("Cliente conectado");
                    
                    int operacion = ois.readInt();
                    
                    if (operacion == 1) {
                        String ci = (String) ois.readObject();
                        Deuda[] deudas = ruat.buscar(ci);
                        oos.writeObject(deudas);
                    } else if (operacion == 2) {
                        Deuda deuda = (Deuda) ois.readObject();
                        boolean resultado = ruat.Pagar(deuda);
                        oos.writeBoolean(resultado);
                    }
                    
                } catch (Exception e) {
                    System.out.println("Error con cliente: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error en servidor: " + e.getMessage());
        }
    }
}
