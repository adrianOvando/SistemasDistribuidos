/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;
import org.jgroups.util.Util;

/**
 *
 * @author Adrian
 */
public class Votaciones extends ReceiverAdapter {

    private JChannel channel;
    private String user_name;
    private final List<String> state = new LinkedList<>();
    private final Map<String, Integer> votos = new HashMap<>();

    public Votaciones(String user_name) {
        this.user_name = user_name;
        votos.put("Lopez Obrador", 0);
        votos.put("Evo Morales", 0);
    }

    public void viewAccepted(View new_view) {
        System.out.println("Vista del grupo actualizada: " + new_view);
    }

    public void receive(Message msg) {
        String line = msg.getObject().toString();
        System.out.println(line);

        // Contar votos si es un mensaje de votación
        if (line.contains("Voto por")) {
            String candidato = line.contains("Lopez Obrador") ? "Lopez Obrador" : "Evo Morales";
            votos.put(candidato, votos.get(candidato) + 1);
        }

        synchronized (state) {
            state.add(line);
        }
    }

    public void getState(OutputStream output) throws Exception {
        synchronized (state) {
            Util.objectToStream(state, new DataOutputStream(output));
        }
    }

    @SuppressWarnings("unchecked")
    public void setState(InputStream input) throws Exception {
        List<String> list = (List<String>) Util.objectFromStream(new DataInputStream(input));
        synchronized (state) {
            state.clear();
            state.addAll(list);
        }
        System.out.println("Estado recibido (" + list.size() + " mensajes en la historia del chat):");
        for (String str : list) {
            System.out.println(str);
        }
    }

    private void start() throws Exception {
        channel = new JChannel();
        channel.setReceiver(this);
        channel.connect("ChatAdrian");
        channel.getState(null, 10000);
        eventLoop();
        channel.close();
    }

    private void eventLoop() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("> ");
                String line = sc.nextLine().toLowerCase();

                if (line.equals("quit") || line.equals("exit")) {
                    break;
                } else if (line.equals("1") || line.equals("2")) {
                    String candidato = line.equals("1") ? "Lopez Obrador" : "Evo Morales";
                    line = "[" + user_name + "] Votó por " + candidato;
                    Message msg = new Message(null, line);
                    channel.send(msg);
                } else if (line.equals("0")) {
                    mostrarResultados();
                } else {
                    System.out.println("Opcion no valida. Escribe 1 o 2 para votar o '0' para ver el conteo");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void mostrarResultados() {
        System.out.println("\nResultados de la votacion:");
        System.out.println("Lopez Obrador: " + votos.get("Lopez Obrador") + " votos");
        System.out.println("Evo Morales: " + votos.get("Evo Morales") + " votos\n");
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca su nombre: ");
        String nombre = sc.next();

        if (!nombre.isEmpty()) {
            System.out.println("Por quien votaras?");
            System.out.println("0 para ver los resultados");
            System.out.println("1 para Lopez Obrador");
            System.out.println("2 para Evo Morales");
        }

        new Votaciones(nombre).start();
    }
}
