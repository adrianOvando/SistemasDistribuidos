/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejcercicio5clase;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;
import org.jgroups.JChannel;
import org.jgroups.Message;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;
import org.jgroups.util.Util;
/**
 *
 * @author Adrian
 */

public class StateSyncCluster {

    private JChannel channel;
    private int state = 0; // Estado inicial (un contador)
    

    public void start() throws Exception {
// Crear el canal y unirse al grupo
        channel = new JChannel(); // Usa la configuración por defecto (UDP)
        channel.setReceiver(new ReceiverAdapter() {
            @Override
            public void receive(Message msg) {
// Manejar mensajes recibidos
                state++;
                System.out.println("estado: "+state);
                System.out.println("Mensaje recibido: " + msg.getObject());
            }

            @Override

            public void viewAccepted(View view) {
// Manejar cambios en la membresía del grupo
                System.out.println("Miembros del grupo: " + view.getMembers());
            }
        });
        channel.connect("StateSyncCluster"); // Conectar al grupo
        channel.connect("ChatPablo");
        channel.getState(null, 10000);
        Message msg=new Message(null,"conectado"); //crea mensaje
        channel.send(msg);
        System.out.println("Conectado al grupo 'StateSyncCluster'");
    }
    


    public static void main(String[] args) {
        try {
            StateSyncCluster example = new StateSyncCluster();
            example.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
