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
public class Usuario {
     public static void main(String[] args) {
        try {

            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            IBanco banco = (IBanco) registry.lookup("banco");

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\n--- Menú de Usuario ---");
                System.out.println("1. Consultar deudas");
                System.out.println("2. Pagar deuda");
                System.out.println("3. Salir");
                System.out.print("Seleccione una opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine(); 
                
                switch (opcion) {
                    case 1:
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
                        }
                        break;
                    case 2:
                        System.out.print("Ingrese su CI: ");
                        CI = scanner.nextLine();
                        deudas = banco.ObtenerDeuda(CI);
                        if (deudas.isEmpty()) {
                            System.out.println("No se encontraron deudas para el CI: " + CI);
                        } else {
                            System.out.println("Deudas encontradas:");
                            for (Deuda deuda : deudas) {
                                System.out.println(deuda);
                            }

                            System.out.print("Ingrese el año de la deuda a pagar: ");
                            int anio = scanner.nextInt();
                            scanner.nextLine(); 

                            System.out.print("Ingrese el tipo de impuesto (vehiculo/inmueble): ");
                            String impuesto = scanner.nextLine();

                            for (Deuda deuda : deudas) {
                                if (deuda.getAnio() == anio && deuda.getIn().toString().equalsIgnoreCase(impuesto)) {
                                    if (banco.Pagar(deuda)) {
                                        System.out.println("Pago realizado con éxito.");
                                    } else {
                                        System.out.println("No se pudo realizar el pago. El CI tiene observaciones.");
                                    }
                                    break;
                                }
                            }
                        }
                        break;

                    case 3:
                        System.out.println("Saliendo...");
                        return;

                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            }
        } catch (Exception e) {
            System.err.println("Error en el usuario: " + e.toString());
        }
    }
}
