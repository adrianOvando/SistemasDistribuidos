/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class Juez {

    public static void main(String[] args) {
        try {
            IAsfi asfi = (IAsfi) Naming.lookup("rmi://localhost/Asfi");
            Scanner scanner = new Scanner(System.in);
            
            System.out.println("Sistema de Retenciones Judiciales");
            System.out.print("Ingrese CI: ");
            String ci = scanner.nextLine();
            System.out.print("Ingrese Nombres: ");
            String nombres = scanner.nextLine();
            System.out.print("Ingrese Apellidos: ");
            String apellidos = scanner.nextLine();
            System.out.println("\nBuscando cuentas...");
            List<Cuenta> cuentas = asfi.consultarCuentas(ci, nombres, apellidos);
            
            if (cuentas.isEmpty()) {
                System.out.println("No se encontraron cuentas para el cliente.");
                return;
            }
            
            System.out.println("\nCuentas encontradas:");
            for (int i = 0; i < cuentas.size(); i++) {
                System.out.println((i+1) + ". " + cuentas.get(i));
            }
            
            System.out.print("\nSeleccione la cuenta para retener (número): ");
            int seleccion = scanner.nextInt();
            
            if (seleccion < 1 || seleccion > cuentas.size()) {
                System.out.println("Selección inválida.");
                return;
            }
            
            Cuenta cuentaSeleccionada = cuentas.get(seleccion - 1);
            
            System.out.print("Ingrese el monto a retener: ");
            double monto = scanner.nextDouble();
            scanner.nextLine(); 
            System.out.print("Ingrese la glosa: ");
            String glosa = scanner.nextLine();
            System.out.println("\nProcesando retención...");
            boolean resultado = asfi.retenerMonto(cuentaSeleccionada, monto, glosa);
            
            if (resultado) {
                System.out.println("Transacción con éxito");
            } else {
                System.out.println("No se pudo realizar la retención");
            }
            
        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(Juez.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al conectar con el servidor ASFI");
        }
    }
}
