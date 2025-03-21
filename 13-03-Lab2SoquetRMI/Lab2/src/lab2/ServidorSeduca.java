package lab2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorSeduca {

    public static void main(String[] args) {
        int port = 5002;
        ServerSocket server;
        String mensaje = "";

        try {
            server = new ServerSocket(port);
            System.out.println("Servidor SEDUCA iniciado en el puerto " + port);

            while (true) {
                // Esperar una conexión del cliente
                Socket client = server.accept();
                System.out.println("Cliente conectado");

                BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
                PrintStream toClient = new PrintStream(client.getOutputStream());

                String operacion = fromClient.readLine(); 
                System.out.println("Mensaje recibido: " + operacion);

                // Extraer el RUDE de la operación
                String[] comandos = operacion.split("-");
                if (comandos.length < 2) {
                    mensaje = "respuesta:no,mensaje:formato de mensaje incorrecto";
                } else {
                    String rude = comandos[1];

                    if (rude.equals("WaSeAr11021996")) { 
                        mensaje = "respuesta:si,mensaje:verificado con éxito";
                    } else {
                        mensaje = "respuesta:no,mensaje:no se encontró el título de bachiller";
                    }
                }

                toClient.println(mensaje);
                System.out.println("Respuesta enviada: " + mensaje);

                client.close();
            }
        } catch (IOException ex) {
            System.out.println("Error en el servidor SEDUCA: " + ex.getMessage());
        }
    }
}