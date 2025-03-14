/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pagosruat;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Adrian
 */
public class ClienteBanco {
     public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            IBanco banco = (IBanco) registry.lookup("banco");
            IAlcaldia alcaldia = (IAlcaldia) registry.lookup("alcaldia");

            Scanner scanner = new Scanner(System.in);

            System.out.print("Ingrese su CI: ");
            String CI = scanner.nextLine();

            ArrayList<Deuda> deudas = banco.ObtenerDeuda(CI);

            if (deudas.isEmpty()) {
                System.out.println("No se encontraron deudas para el CI: " + CI);
            } else {
                System.out.println("Deudas encontradas:");
                for (Deuda deuda : deudas) {
                    System.out.println(deuda);
                }

                 boolean tieneObservaciones = alcaldia.BuscarObservaciones(CI);
                if (tieneObservaciones) {
                    System.out.println("El CI " + CI + " tiene observaciones. No se puede realizar el pago.");
                } else {
                    System.out.println("El CI " + CI + " no tiene observaciones. Puede proceder con el pago.");
                }
            }
        } catch (Exception e) {
            System.err.println("Error en el cliente Banco: " + e.toString());
        }
    }
}
