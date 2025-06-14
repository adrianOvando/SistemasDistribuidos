/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package operaciones;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adrian
 */
public class Cliente {
    public static void main (String[] Args){ 
    IOperacion operacion;
    Scanner sc = new Scanner(System.in);
        try {
            operacion = (IOperacion)Naming.lookup("rmi://localhost/N");
             System.out.println("Elija una opción:");
                System.out.println("1.- Calcular Factorial");
                System.out.println("2.- Calcular Fibonacci");
                System.out.println("3.- Calcular Sumatoria");
                System.out.println("4.- Salir");
                System.out.print("Opción: ");
                String opcion = sc.nextLine();
             switch (opcion) {

            case "1": 
                int a= sc.nextInt();
                System.out.println(operacion.Factorial(a));
                break;

            case "2": 
                int b= sc.nextInt();
                System.out.println(operacion.Fibonacci(b));
                break;

            case "3": 
                int c= sc.nextInt();
                System.out.println(operacion.Sumatoria(c));
                break;

            case "4": 
                break;

            default:
                System.out.println("Opción no válida");
                break;
        }
        } catch (NotBoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
