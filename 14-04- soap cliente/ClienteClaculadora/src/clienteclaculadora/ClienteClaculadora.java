/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clienteclaculadora;

/**
 *
 * @author Adrian
 */
public class ClienteClaculadora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("El resulta de 4+5 es:" + sumar(4,5));
    }

    private static int sumar(int a, int b) {
        org.tempuri.WSCalculadora service = new org.tempuri.WSCalculadora();
        org.tempuri.WSCalculadoraSoap port = service.getWSCalculadoraSoap12();
        return port.sumar(a, b);
    }
    
}
