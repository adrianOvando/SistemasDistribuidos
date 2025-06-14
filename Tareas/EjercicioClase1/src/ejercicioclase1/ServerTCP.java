/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioclase1;

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
public class ServerTCP {

     public static void main(String[] args) {
        int port = 5555;
        ServerSocket server;
        
        try {
            server = new ServerSocket(port);
            System.out.println("Servidor iniciado en el puerto " + port);
            
            Socket client = server.accept();
            System.out.println("Cliente conectado");
            
            BufferedReader fromClient = new BufferedReader(
                new InputStreamReader(client.getInputStream()));
            PrintStream toClient = new PrintStream(client.getOutputStream());
            
            String palabra = fromClient.readLine();
            System.out.println("Palabra recibida: " + palabra);
            
            // Invertir la palabra
            String palabraInvertida = new StringBuilder(palabra).reverse().toString();
            
            toClient.println(palabraInvertida);
            System.out.println("Palabra invertida enviada: " + palabraInvertida);
            
            client.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}

