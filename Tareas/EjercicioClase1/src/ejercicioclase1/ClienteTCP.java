/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioclase1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Adrian
 */
public class ClienteTCP {
    public static void main(String[] args) {
        int port = 5555;
        try {
            Socket client = new Socket("localhost", port);
            
            Scanner scanner = new Scanner(System.in);
            System.out.print("Ingrese una palabra: ");
            String palabra = scanner.nextLine();
            
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(
                new InputStreamReader(client.getInputStream()));
            
            toServer.println(palabra);
            
            String palabraInvertida = fromServer.readLine();
            System.out.println("Palabra invertida recibida del servidor: " + palabraInvertida);
            
            client.close();
            scanner.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
