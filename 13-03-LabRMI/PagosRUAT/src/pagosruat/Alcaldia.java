/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pagosruat;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Adrian
 */
public class Alcaldia extends UnicastRemoteObject implements IAlcaldia{
    
    ArrayList<Deuda> deuda;

    
    public Alcaldia() throws RemoteException{
        
        super();
        deuda = new ArrayList<>();
        this.deuda.add(new Deuda("1234567", 2022, Impuesto.vehiculo, 2451));
        this.deuda.add(new Deuda("1234567", 2022, Impuesto.inmueble, 2500));
        this.deuda.add(new Deuda("555587", 2021, Impuesto.vehiculo, 5000));
        this.deuda.add(new Deuda("333357", 2023, Impuesto.inmueble, 24547));
    }

    @Override
    public boolean BuscarObservaciones(String CI) throws RemoteException {
        
         for (Deuda d : deuda) { 
            if (d.getCI().equals(CI)) { 
                return false; 
            }
        }
        return true; 
    }

    
}

