/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class Universidad extends UnicastRemoteObject implements IUniversidad {

    public Universidad() throws RemoteException {
        super();
    }
    
    @Override
    public Diploma EmitirDiploma(String ci, String nombres, String primerApellido, String segundoApellido, String fecha_nacimiento, Carrera carrera) throws RemoteException {
          Diploma aux = null;
        try {
            Boolean emitir = false;
            String rude = nombres.substring(0, 2) + primerApellido.substring(0, 2) + segundoApellido.substring(0, 2) + fecha_nacimiento.replace("-", "");

            // Llamar a SEGIP (RMI)
            ISegip segip;
            try {
                segip = (ISegip) Naming.lookup("rmi://localhost:1090/Segip");
                emitir = segip.Verificar(ci, nombres, primerApellido + " " + segundoApellido);
            } catch (NotBoundException | MalformedURLException ex) {
                Logger.getLogger(Universidad.class.getName()).log(Level.SEVERE, null, ex);
                return new Diploma("", null, "", "Error al conectar con SEGIP");
            }

            if (!emitir) {
                return new Diploma("", null, "", "Los Datos del CI no son correctos");
            }

            // Llamar a SEDUCA (TCP)
            try (Socket client = new Socket("localhost", 5002)) {
                PrintStream toServer = new PrintStream(client.getOutputStream());
                BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
                toServer.println("verificar-" + rude);
                String result = fromServer.readLine();

                if (!result.contains("respuesta:si")) {
                    return new Diploma("", null, "", "No se encontró el título de bachiller");
                }
            } catch (IOException ex) {
                Logger.getLogger(Universidad.class.getName()).log(Level.SEVERE, null, ex);
                return new Diploma("", null, "", "Error al conectar con SEDUCA");
            }

            // Llamar a SERECI (UDP)
            try {
                DatagramSocket socketUDP = new DatagramSocket();
                InetAddress hostServidor = InetAddress.getByName("localhost");
                int puertoServidor = 6789;
                // Preparar la solicitud
                String solicitud = "Ver-fecha:" + nombres + "," + primerApellido + " " + segundoApellido + "," + fecha_nacimiento;
                byte[] mensaje = solicitud.getBytes();
                DatagramPacket peticion = new DatagramPacket(mensaje, mensaje.length, hostServidor, puertoServidor);
                // Enviar la solicitud
                socketUDP.send(peticion);
                // Recibir la respuesta
                byte[] buffer = new byte[1000];
                DatagramPacket respuestaPacket = new DatagramPacket(buffer, buffer.length);
                socketUDP.receive(respuestaPacket);
                String respuesta = new String(respuestaPacket.getData(), 0, respuestaPacket.getLength()).trim();
                if (!respuesta.contains("respuesta:si")) {
                    return new Diploma("", null, "", "Error en la fecha de nacimiento");
                }
            } catch (IOException ex) {
                Logger.getLogger(Universidad.class.getName()).log(Level.SEVERE, null, ex);
                return new Diploma("", null, "", "Error al conectar con SERECI");
            }

            aux = new Diploma(nombres + " " + primerApellido + " " + segundoApellido, carrera, fecha_nacimiento, "");

        } catch (RemoteException ex) {
            Logger.getLogger(Universidad.class.getName()).log(Level.SEVERE, null, ex);
        }

        return aux;
    }
}