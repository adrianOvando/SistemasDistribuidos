/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author Adrian
 */
public class BancoMercantilClient {

    public static void main(String[] args) {
        int port = 9999;
        try (DatagramSocket socket = new DatagramSocket(port)) {
            System.out.println("Servidor Mercantil en ejecución en el puerto " + port);

            while (true) {
                byte[] buffer = new byte[1024];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                String mensaje = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Mensaje recibido: " + mensaje);

                String respuesta = procesarMensaje(mensaje);

                DatagramPacket packetRespuesta = new DatagramPacket(
                        respuesta.getBytes(), respuesta.length(),
                        packet.getAddress(), packet.getPort());
                socket.send(packetRespuesta);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String procesarMensaje(String mensaje) {
        if (mensaje.startsWith("Buscar:")) {
            String[] partes = mensaje.substring(7).split("-");
            if (partes.length >= 3) {
                String ci = partes[0];
                String nombres = partes[1];
                String apellidos = partes[2];

                if (ci.equals("11021654") && nombres.equals("Juan Perez") && apellidos.equals("Segovia")) {
                    return "";
                }
            }
            return "";
        } else if (mensaje.startsWith("Congelar:")) {
            return "NO-no encontrado";
        }
        return "Error: Comando no reconocido";
    }
}
