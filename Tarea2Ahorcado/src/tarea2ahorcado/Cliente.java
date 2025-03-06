package tarea2ahorcado;

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
                // Leer y mostrar el mensaje del servidor
                String mensaje = dis.readUTF();
                System.out.println(mensaje);

                // Verificar si el juego ha terminado
                if (mensaje.contains("Cerrando conexión") || mensaje.contains("¡Felicidades!") || mensaje.contains("¡Oh no!")) {
                    break;
                }

                // Solicitar una letra al usuario
                System.out.print("Ingresa una letra: ");
                char tosend = scn.next().charAt(0);
                dos.writeUTF(Character.toString(tosend));
                dos.flush(); // Forzar el envío de la letra
            }

            scn.close();
            dis.close();
            dos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}