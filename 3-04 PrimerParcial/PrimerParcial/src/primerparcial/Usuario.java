/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primerparcial;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author Adrian
 */
public class Usuario {

    public static void main(String[] args) throws ClassNotFoundException {
        int port = 5002;
        Scanner sc = new Scanner(System.in);

        System.out.println("Cliente Banco");
        System.out.println("Opciones disponibles:");
        System.out.println("1. Consultar deudas por CI");
        System.out.println("2. Pagar una deuda");
        System.out.println("3. Salir");

        while (true) {
            System.out.print("\nSeleccione opcion (1-3): ");
            int opcion = sc.nextInt();
            sc.nextLine(); 

            if (opcion == 3) {
                break;
            }

            try (Socket socket = new Socket("localhost", port);
                 ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                 ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())) { //recive//

                switch (opcion) {
                    case 1: 
                        System.out.print("Ingrese CI a consultar: ");
                        String ciConsulta = sc.nextLine();

                        oos.writeInt(1);
                        oos.writeObject(ciConsulta);
                        oos.flush();
                        
                        Deuda[] deudas = (Deuda[]) ois.readObject();
                        System.out.println("\nDeudas encontradas:");
                        for (Deuda d : deudas) {
                            System.out.println("- " + d);
                        }
                        break;
                        
                    case 2: 
                        System.out.println("Ingrese datos de la deuda a pagar:");
                        System.out.print("CI: ");
                        String ciPago = sc.nextLine();
                        System.out.print("Anio: ");
                        int año = sc.nextInt();
                        System.out.print("Tipo (1-Vehiculo, 2-Casa): ");
                        Impuesto impuesto = sc.nextInt() == 1 ? Impuesto.vehiculo : Impuesto.casa;
                        System.out.print("Pagar deuda 1 para pagar");
                        double monto = sc.nextDouble();
                        sc.nextLine(); 
                        if(monto == 1){
                            System.out.print("Pago exitoso");
                        }
                        break;
                        
                        
                    default:
                        System.out.println("Opcion no valida");
                }
                
            } catch (UnknownHostException e) {
                System.err.println("Host desconocido: " + e.getMessage());
            } catch (IOException e) {
                System.err.println("Error de I/O: " + e.getMessage());
            }
        }
        sc.close();
        System.out.println("Aplicación terminada");
    }
}
