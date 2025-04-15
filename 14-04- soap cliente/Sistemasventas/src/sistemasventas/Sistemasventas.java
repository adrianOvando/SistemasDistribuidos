/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemasventas;

import org.tempuri.Producto;
import org.tempuri.WebService1;

/**
 *
 * @author Adrian
 */
public class Sistemasventas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        WebService1.Producto p = new Producto();
    }

    private static Producto getProducto(java.lang.String codigo) {
        org.tempuri.WebService1 service = new org.tempuri.WebService1();
        org.tempuri.WebService1Soap port = service.getWebService1Soap12();
        return port.getProducto(codigo);
    }
    
}
