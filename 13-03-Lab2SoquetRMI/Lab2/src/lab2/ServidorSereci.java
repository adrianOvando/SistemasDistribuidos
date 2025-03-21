/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adrian
 */
public class ServidorSereci {

    public static void main(String[] args) {
        int port = 6789; // Puerto para el servidor UDP
        try {
            DatagramSocket socketUDP = new DatagramSocket(port);
            byte[] buffer = new byte[1000]; // Buffer para recibir datos
            while (true) {
                // Recibir solicitud del cliente
                DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);
                socketUDP.receive(peticion); 
                String received = new String(peticion.getData(), 0, peticion.getLength()).trim();
                System.out.println("Mensaje recibido: " + received);
                String[] datos = received.split(":");
                if (datos.length < 2) {
                    System.out.println("Formato de mensaje incorrecto");
                    continue; 
                }
                String nombres = datos[1].split(",")[0];
                String apellidos = datos[1].split(",")[1];
                String fecha = datos[1].split(",")[2];

                Sereci sereci = new Sereci();
                String respuesta = sereci.verificarFecha(nombres, apellidos, fecha);

                byte[] mensajeRespuesta = respuesta.getBytes();
                DatagramPacket respuestaPacket = new DatagramPacket(
                    mensajeRespuesta, mensajeRespuesta.length, peticion.getAddress(), peticion.getPort()
                );
                socketUDP.send(respuestaPacket);
                System.out.println("Respuesta enviada: " + respuesta);
            }
        } catch (SocketException ex) {
            System.out.println("Error en el socket: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error de E/S: " + ex.getMessage());
        }
    }
}
    


/* socketUDP.receive(peticion);
                String received = new String(peticion.getData(), 0, peticion.getLength()).trim();
                System.out.println("Mensaje recibido: " + received);
                String respuesta = procesarSolicitud(received, operaciones);
                byte[] mensaje = respuesta.getBytes();
                DatagramPacket respuestaPacket = new DatagramPacket(mensaje, mensaje.length, peticion.getAddress(), peticion.getPort());
                socketUDP.send(respuestaPacket);*/
