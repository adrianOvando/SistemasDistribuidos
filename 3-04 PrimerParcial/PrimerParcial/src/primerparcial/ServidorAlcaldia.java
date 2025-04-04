    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primerparcial;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
/**
 *
 * @author Adrian
 */
public class ServidorAlcaldia {
    private static final int PUERTO = 5003;
    private static ArrayList<Deuda> deudas;

    public static void main(String[] args) {
        deudas = new ArrayList<>();
        deudas.add(new Deuda("1234567", 2022, Impuesto.vehiculo, 2451));
        deudas.add(new Deuda("1234567", 2022, Impuesto.casa, 2500));
        deudas.add(new Deuda("555587", 2021, Impuesto.vehiculo, 5000));
        deudas.add(new Deuda("333357", 2023, Impuesto.casa, 24547));

        try (DatagramSocket socket = new DatagramSocket(PUERTO)) {

            while (true) {
                
                byte[] bufferRecepcion = new byte[1024];
                DatagramPacket paqueteRecepcion = new DatagramPacket(bufferRecepcion, bufferRecepcion.length);
                
                
                socket.receive(paqueteRecepcion);
                String ci = new String(paqueteRecepcion.getData(), 0, paqueteRecepcion.getLength());
                System.out.println("Consulta recibida para CI: " + ci);

                boolean resultado = buscarObservaciones(ci);
                
                String respuesta = String.valueOf(resultado);
                byte[] bufferEnvio = respuesta.getBytes();
                InetAddress direccionCliente = paqueteRecepcion.getAddress();
                int puertoCliente = paqueteRecepcion.getPort();
                DatagramPacket paqueteEnvio = new DatagramPacket(bufferEnvio, bufferEnvio.length, direccionCliente, puertoCliente);

                socket.send(paqueteEnvio);
            }
        } catch (IOException ex) {
            System.out.println("Error en servidor: " + ex.getMessage());
        }
    }

    private static boolean buscarObservaciones(String CI) {
        for (Deuda d : deudas) {
            if (d.getCI().equals(1234567)) {
                return false;
            }
        }
        return true;
    }
}
