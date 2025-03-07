/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socketudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Cliente {

    public static void main(String[] args) {
        int puerto = 6789; 
        String ip = "localhost"; 
        Scanner sc = new Scanner(System.in);

        try {
            DatagramSocket socketUDP = new DatagramSocket();
            InetAddress hostServidor = InetAddress.getByName(ip);

            while (true) {
                
                System.out.println("Elija una opción:");
                System.out.println("1.- Establecer valor de n");
                System.out.println("2.- Calcular Fibonacci");
                System.out.println("3.- Calcular Factorial");
                System.out.println("4.- Calcular Sumatoria");
                System.out.println("5.- Salir");
                System.out.print("Opción: ");
                String opcion = sc.nextLine();

                String mensaje = opcion;
                if (opcion.equals("1")) {
                    System.out.print("Ingrese el valor de n: ");
                    String n = sc.nextLine();
                    mensaje += "," + n; 
                }

                byte[] buffer = mensaje.getBytes();
                DatagramPacket peticion = new DatagramPacket(buffer, buffer.length, hostServidor, puerto);
                socketUDP.send(peticion);

                // Recibir la respuesta del servidor
                byte[] buferRespuesta = new byte[1000];
                DatagramPacket respuesta = new DatagramPacket(buferRespuesta, buferRespuesta.length);
                socketUDP.receive(respuesta);

                // Mostrar la respuesta
                System.out.println("Respuesta del servidor: " + new String(respuesta.getData()).trim());

                if (opcion.equals("5")) {
                    break;
                }
            }

            socketUDP.close();
            sc.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}