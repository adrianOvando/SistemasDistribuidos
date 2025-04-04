/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primerparcial;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adrian
 */
public class Banco {
    
    private List<Deuda> deudas;

    public Banco(){
        deudas = new ArrayList<>();
        deudas.add(new Deuda("1234567", 2022, Impuesto.vehiculo, 2451));
        deudas.add(new Deuda("1234567", 2022, Impuesto.casa, 2500));
        deudas.add(new Deuda("555587", 2021, Impuesto.vehiculo, 5000));
        deudas.add(new Deuda("333357", 2023, Impuesto.casa, 24547));
    }

    public ArrayList<Deuda> ObtenerDeuda(String CI) throws RemoteException {
        ArrayList<Deuda> resultado = new ArrayList<>();
        for (Deuda deuda : deudas) {
            if (deuda.getCI().equals(CI)) {
                resultado.add(deuda);
            }
        }
        return resultado; 
    }

    public boolean Pagar(Deuda deuda) throws RemoteException {
        for (Deuda d : deudas) {
            if (d.getCI().equals(deuda.getCI())) {
                return false; 
            }
        }
        return true;
    
    }
    
}
