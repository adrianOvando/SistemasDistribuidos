/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socketudp;

/**
 *
 * @author Adrian
 */
public class Operaciones {
   private int n; 

    public void setN(int n) {
        this.n = n;
    }
    public int getN() {
        return n;
    }

    public String calcularFibonacci() {
        int a = 0, b = 1;
        StringBuilder resultado = new StringBuilder(a + " " + b + " ");
        for (int i = 2; i < n; i++) {
            int siguiente = a + b;
            resultado.append(siguiente).append(" ");
            a = b;
            b = siguiente;
        }
        return resultado.toString().trim();
    }

    public String calcularFactorial() {
        int resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado *= i;
        }
        return String.valueOf(resultado);
    }

    public String calcularSumatoria() {
        int resultado = (n * (n + 1)) / 2;
        return String.valueOf(resultado);
    }
}
