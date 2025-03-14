/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pagosruat;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Adrian
 */
public interface IAlcaldia extends Remote{
    
    public boolean BuscarObservaciones(String CI) throws RemoteException;
    
}
