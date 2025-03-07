/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea2socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Carlos
 */
class Handler extends Thread {

    final DataInputStream dis;
    final DataOutputStream dos;
    final Socket s;
   
    // Constructor
    public Handler(Socket s, DataInputStream dis, DataOutputStream dos) {
        this.s = s;
        this.dis = dis;
        this.dos = dos;
    }

    @Override
    public void run() {
        String received;
        String toreturn;
        while (true) {
            try {

                // Ask user what he wants
                dos.writeUTF("Elija una opción..\n"
                        + "1.- Fibonacci \n"
                        + "2.- Factorial \n"
                        + "3.- Sumatoria \n"
                        + "Escibir Exit para terminar la conneccion.");

                // receive the answer from client
                received = dis.readUTF();

                if (received.equals("Exit")) {
                    System.out.println("Client " + this.s + " sends exit...");
                    System.out.println("Closing this connection.");
                    this.s.close();
                    System.out.println("Connection closed");
                    break;
                }

                // write on output stream based on the
                // answer from the client
                switch (received) {

                    case "1":
                        //System.out.println("Cantidad de n \n");
                         int n = dis.readInt();
                          int a = 0, b = 1;
                           toreturn = a + " " + b + " "; 
                            for (int i = 2; i < n; i++) {
                                int siguiente = a + b;
                                toreturn += siguiente + " ";
                                a = b;
                                b = siguiente;
                            }
                        dos.writeUTF(toreturn);
                        break;
                        
                    case "2":
                       int v = dis.readInt();
                       int resultado = 1;
                       for (int i = 1; i <= v; i++) {
                            resultado *= i;
                        }
                       toreturn = resultado+" ";
                       dos.writeUTF(toreturn);
                        break;
                        
                    case "3":
                       int c = dis.readInt();
                       resultado = (c * (c + 1)) / 2;
                       toreturn= resultado+" ";
                       dos.writeUTF(toreturn);
                        break;

                    default:
                        dos.writeUTF("Invalid input");
                        break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            // closing resources
            this.dis.close();
            this.dos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
