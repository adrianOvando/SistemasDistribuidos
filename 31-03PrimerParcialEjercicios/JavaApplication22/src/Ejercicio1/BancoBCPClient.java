package Ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Adrian
 */
public class BancoBCPClient {

    public static final ArrayList<Cuenta> cuentas = new ArrayList<>();

    static {
        cuentas.add(new Cuenta(Banco.BCP, "657654", "11021654", "Juan Perez", "Segovia", 10000.00));
    }

    public static void main(String[] args) {
        int port = 1700;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Servidor BCP iniciado en el puerto " + port);

            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    System.out.println("Cliente conectado: " + socket.getInetAddress());

                    BufferedReader fromClient = new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));
                    PrintWriter toClient = new PrintWriter(socket.getOutputStream(), true);

                    String mensaje = fromClient.readLine();
                    System.out.println("Mensaje recibido: " + mensaje);

                    String respuesta = procesarMensaje(mensaje);
                    toClient.println(respuesta);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
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
                    return "657654-10000.00";
                }
            }
            return "";
        } else if (mensaje.startsWith("Congelar:")) {
            String[] partes = mensaje.substring(9).split("-");
            if (partes.length >= 2) {
                String nroCuenta = partes[0];
                double monto = Double.parseDouble(partes[1]);

                if (nroCuenta.equals("657654")) {
                    return "SI-657654";
                }
            }
            return "NO-no encontrado";
        }
        return "Error: Comando no reconocido";
    }
}
