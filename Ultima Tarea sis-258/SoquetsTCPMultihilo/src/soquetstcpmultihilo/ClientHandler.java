package soquetstcpmultihilo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

class ClientHandler extends Thread {
    final DataInputStream dis;
    final DataOutputStream dos;
    final Socket s;
    
    // Constructor
    public ClientHandler(Socket s, DataInputStream dis, DataOutputStream dos) {
        this.s = s;
        this.dis = dis;
        this.dos = dos;
    }
    
    @Override
    public void run() {
        String received;
        int acumulador = 0;
        int contadorVeces = 0; // Contador de veces que se acumuló
        
        try {
            while (true) {
                // Pedir al usuario que ingrese un número
                dos.writeUTF("Ingrese un número para acumular (0 para finalizar): ");
                
                // Recibir respuesta del cliente
                received = dis.readUTF();
                
                // Si el cliente envía "Exit", cerrar conexión
                if (received.equals("Exit")) {
                    System.out.println("Cliente " + this.s + " envió exit...");
                    System.out.println("Cerrando conexión.");
                    break;
                }
                
                int numero;
                try {
                    numero = Integer.parseInt(received);
                } catch (NumberFormatException e) {
                    dos.writeUTF("Error: Ingrese un número válido");
                    continue;
                }
                
                if (numero == 0) {
                    // Cuando el cliente envía 0, mostrar resultado final
                    String mensaje = "Cantidad de veces: " + contadorVeces + 
                                   ", Acumulado: " + acumulador;
                    dos.writeUTF(mensaje);
                    System.out.println("Cliente finalizó - " + mensaje);
                    
                    // Reiniciar para una nueva sesión con el mismo cliente
                    acumulador = 0;
                    contadorVeces = 0;
                } else {
                    // Acumular el número y incrementar contador
                    acumulador += numero;
                    contadorVeces++;
                    dos.writeUTF("Acumulado: " + acumulador);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // Cerrar recursos
                this.dis.close();
                this.dos.close();
                this.s.close();
                System.out.println("Conexión cerrada para cliente: " + this.s);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}