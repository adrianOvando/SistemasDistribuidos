/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socketudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 *
 * @author Dell
 */
public class Server {
   
    public static void main(String[] args) {
        int port = 6789; 
        Operaciones operaciones = new Operaciones(); 

        try {
            DatagramSocket socketUDP = new DatagramSocket(port);
            byte[] bufer = new byte[1000];

            while (true) {
                DatagramPacket peticion = new DatagramPacket(bufer, bufer.length);
                socketUDP.receive(peticion);
                String received = new String(peticion.getData(), 0, peticion.getLength()).trim();
                System.out.println("Mensaje recibido: " + received);
                String respuesta = procesarSolicitud(received, operaciones);
                byte[] mensaje = respuesta.getBytes();
                DatagramPacket respuestaPacket = new DatagramPacket(mensaje, mensaje.length, peticion.getAddress(), peticion.getPort());
                socketUDP.send(respuestaPacket);

                System.out.println("Respuesta enviada: " + respuesta);
            }
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        }
    }

    private static String procesarSolicitud(String received, Operaciones operaciones) {
        String[] partes = received.split(","); 
        String opcion = partes[0];
        String respuesta = "";

        switch (opcion) {
            case "1": 
                int n = Integer.parseInt(partes[1]);
                operaciones.setN(n);
                respuesta = "Valor de n establecido: " + n;
                break;

            case "2": 
                respuesta = "Fibonacci: " + operaciones.calcularFibonacci();
                break;

            case "3": 
                respuesta = "Factorial: " + operaciones.calcularFactorial();
                break;

            case "4": 
                respuesta = "Sumatoria: " + operaciones.calcularSumatoria();
                break;

            case "5": 
                respuesta = "Saliendo...";
                break;

            default:
                respuesta = "Opción no válida";
                break;
        }

        return respuesta;
    }
    
}