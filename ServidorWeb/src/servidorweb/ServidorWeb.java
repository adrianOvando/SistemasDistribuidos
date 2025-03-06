/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package servidorweb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Adrian
 */
public class ServidorWeb {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int port = 80;
            ServerSocket server;
            
           
            try {
            // TODO code application logic here
            server = new ServerSocket(port);
            System.out.println("Se inicio el servidor con éxito");
            Socket client;
            PrintStream toClient;
            while (true){
            client = server.accept(); //conexion entre cliente y servidor para comunicacion bidireccional
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
            System.out.println("Cliente se conecto");
            String recibido = fromClient.readLine();
            
            String request = fromClient.readLine();
            String mensaje=request;
            while(!request.equals("")){
                request=fromClient.readLine();
                mensaje+=request;
            }
            
            String nombre = fromClient.readLine();
            String ape = fromClient.readLine();
            String segape = fromClient.readLine();
            
            System.out.println("El cliente envio el mensaje:"+recibido);
            toClient = new PrintStream(client.getOutputStream());
            toClient.println("Hola Mundo desde el Servidor");
            }
            
        } catch (IOException ex) {
            System.out.print(ex.getMessage());
        }
    }
    
}
