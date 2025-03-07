package tarea2ahorcado;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Random;

class Handler extends Thread {
    final DataInputStream dis;
    final DataOutputStream dos;
    final Socket s;

    public Handler(Socket s, DataInputStream dis, DataOutputStream dos) {
        this.s = s;
        this.dis = dis;
        this.dos = dos;
    }

@Override
public void run() {
    String[] palabras = {
        "java", "programacion", "ahorcado", "computadora", "desarrollo",
        "teclado", "monitor", "internet", "algoritmo", "variable",
        "funcion", "objeto", "clase", "herencia", "polimorfismo",
        "compilador", "depurador", "sintaxis", "lenguaje", "debugging"
    };

    try {
        
        dos.writeUTF("** Ahorcado ** \nEscribe E o e para terminar la conexión.");
        dos.flush(); 

        Random random = new Random();
        String palabraAleatoria = palabras[random.nextInt(palabras.length)];

        char[] letras = palabraAleatoria.toCharArray();
        char[] mostrar = new char[letras.length];

        for (int i = 0; i < mostrar.length; i++) {
            mostrar[i] = '_';
        }

        
        for (int i = 0; i < letras.length; i++) {
            if (random.nextBoolean() && random.nextBoolean()) {
                mostrar[i] = letras[i];
            }
        }

        int intentosRestantes = 7;
        boolean palabraCompleta = false;

        
        dos.writeUTF("Palabra: " + new String(mostrar) + "\nIntentos restantes: " + intentosRestantes);
        dos.flush(); // Forzar el envío del mensaje

        while (intentosRestantes > 0 && !palabraCompleta) {
            char letraUsuario = dis.readUTF().charAt(0);

            if (letraUsuario == 'E') {
                dos.writeUTF("Cerrando conexión...");
                dos.flush(); 
                s.close();
                return;
            }

            boolean letraAdivinada = false;

            for (int i = 0; i < letras.length; i++) {
                if (letras[i] == letraUsuario && mostrar[i] == '_') {
                    mostrar[i] = letraUsuario;
                    letraAdivinada = true;
                }
            }

            if (!letraAdivinada) {
                intentosRestantes--;
                dos.writeUTF("Letra incorrecta. Te quedan " + intentosRestantes + " intentos.");
                dos.flush(); 
            }

            
            palabraCompleta = true;
            for (char c : mostrar) {
                if (c == '_') {
                    palabraCompleta = false;
                    break;
                }
            }

           
            dos.writeUTF("Palabra: " + new String(mostrar) + "\nIntentos restantes: " + intentosRestantes);
            dos.flush(); 
        }

        
        if (palabraCompleta) {
            dos.writeUTF("¡Felicidades! Has adivinado la palabra: " + palabraAleatoria);
        } else {
            dos.writeUTF("¡Oh no! Te has quedado sin intentos. La palabra era: " + palabraAleatoria);
        }
        dos.flush(); 

    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            dis.close();
            dos.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
}
