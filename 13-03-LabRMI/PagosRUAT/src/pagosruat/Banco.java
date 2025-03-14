/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pagosruat;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adrian
 */
public class Banco extends UnicastRemoteObject implements IBanco{
    
    private List<Deuda> deudas;

    public Banco() throws RemoteException {
        super();
        
        deudas = new ArrayList<>();
        deudas.add(new Deuda("1234567", 2022, Impuesto.vehiculo, 2451));
        deudas.add(new Deuda("1234567", 2022, Impuesto.inmueble, 2500));
        deudas.add(new Deuda("555587", 2021, Impuesto.vehiculo, 5000));
        deudas.add(new Deuda("333357", 2023, Impuesto.inmueble, 24547));
    }

    @Override
    public ArrayList<Deuda> ObtenerDeuda(String CI) throws RemoteException {
        ArrayList<Deuda> resultado = new ArrayList<>();
        for (Deuda deuda : deudas) {
            if (deuda.getCI().equals(CI)) {
                resultado.add(deuda);
            }
        }
        return resultado; 
    }

    @Override
    public boolean Pagar(Deuda deuda) throws RemoteException {
        for (Deuda d : deudas) {
            if (d.getCI().equals(deuda.getCI())) {
                return false; 
            }
        }
        return true;
    
    }
    
}
