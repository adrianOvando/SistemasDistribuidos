/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sockets2;

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
public class ClienteChat {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // TODO code application logic here
        int port = 5002;
        try {
            Socket client = new Socket("10.8.221.51", port);
            PrintStream toServer = new PrintStream(client.getOutputStream());
            BufferedReader fromServer = new BufferedReader(
                    new InputStreamReader(client.getInputStream()));
            String mensaje = "";
            while (!mensaje.equals("exit")) {
                System.out.print("cliente:");
                mensaje = sc.nextLine();
                toServer.println(mensaje);
                String result = fromServer.readLine();
                System.out.println("server: " + result);
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}