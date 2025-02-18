/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tareaclases;

import java.util.Scanner;

/**
 *
 * @author Adrian
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
               int op=0;
        int n=0;
        Scanner sc=new Scanner(System.in);
        while (op!=5)
        {
            System.out.println("1. Introducir n");
            System.out.println("2. Fibonacci");
            System.out.println("3. Factorial");
            System.out.println("4. Sumatoria");
            System.out.println("5. Salir");
            System.out.println("Introduzca Opcion");
            op=sc.nextInt();
            
            switch(op)
            {
                case 1:
                    System.out.println("Introduzca el valor de n");
                    n=sc.nextInt();
                   break;
                case 2:
                    System.out.println("El fibonacci es.."+fibonacci(n));
                    break;
            }
            
        }
        
    }

    private static int fibonacci(int n) {
        if (n==0)
            return 0;
        if (n==1)
            return 1;
        return fibonacci(n-1)+fibonacci(n-2);
            
    }
}

  