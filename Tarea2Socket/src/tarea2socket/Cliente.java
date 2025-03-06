package tarea2socket;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try {
            Scanner scn = new Scanner(System.in);
            InetAddress ip = InetAddress.getByName("localhost");
            Socket s = new Socket(ip, 5056);

            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            while (true) {
                System.out.println(dis.readUTF()); // Mensaje del servidor
                String tosend = scn.nextLine();
                dos.writeUTF(tosend); // Enviar opción al servidor

                // Si el usuario quiere salir, cerrar conexión
                if (tosend.equalsIgnoreCase("Exit")) {
                    System.out.println("Cerrando conexión...");
                    s.close();
                    System.out.println("Conexión cerrada.");
                    break;
                }

                // Si la opción requiere un número, pedirlo y enviarlo
                if (tosend.equals("1") || tosend.equals("2") || tosend.equals("3")) {
                    System.out.println("Ingrese un número para n:");
                    int n = scn.nextInt();
                    scn.nextLine(); // Consumir el salto de línea
                    dos.writeInt(n);
                }

                // Recibir la respuesta del servidor
                String received = dis.readUTF();
                System.out.println(received);
            }

            scn.close();
            dis.close();
            dos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
