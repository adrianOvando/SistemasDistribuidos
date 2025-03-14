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
public class Ruat extends UnicastRemoteObject implements IRuat{
     
    ArrayList<Deuda> deuda;

    
    public Ruat() throws RemoteException{
        super();
        this.deuda = new ArrayList<>();
        this.deuda.add(new Deuda("1234567", 2022, Impuesto.vehiculo, 2451));
        this.deuda.add(new Deuda("1234567", 2022, Impuesto.inmueble, 2500));
        this.deuda.add(new Deuda("555587", 2021, Impuesto.vehiculo, 5000));
        this.deuda.add(new Deuda("333357", 2023, Impuesto.inmueble, 24547));
    }
    
    @Override
    public Deuda[] buscar(String CI) throws RemoteException {  
       ArrayList<Deuda> result = new ArrayList<>();
        for (Deuda d : deuda) { 
            if (d.getCI().equals(CI)) {
                result.add(d);
            }
        }
        return result.toArray(new Deuda[0]);
    }

    @Override
    public Boolean Pagar(Deuda deuda) throws RemoteException {
         for (int i = 0; i < this.deuda.size(); i++) {
        Deuda d = this.deuda.get(i);
        if (d.getCI().equals(deuda.getCI()) &&
            d.getAnio() == deuda.getAnio() &&
            d.getIn().equals(deuda.getIn()) &&
            d.getMonto() == deuda.getMonto()) {
            
            this.deuda.remove(i); 
            return true; 
        }
    }
    return false;
    
    }
    
}
