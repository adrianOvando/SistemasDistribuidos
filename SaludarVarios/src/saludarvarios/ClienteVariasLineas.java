/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package saludarvarios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class ClienteVariasLineas {
     public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
         int port = 5002;
        try {
            Socket client = new Socket("localhost", port);
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));
            System.out.println("Introduzca su primer nombre");
            String nombre=sc.nextLine();
            System.out.println("Introduzca su primer apellido");
            String ape=sc.nextLine();
            System.out.println("Introduzca su segundo");
            String segape=sc.nextLine();
            toServer.println(nombre);
            toServer.println(ape);
            toServer.println(segape);
            toServer.println("Hola Mundo desde el Cliente");
            String result = fromServer.readLine();
            System.out.println("cadena devuelta por el servidor es: " + result);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}