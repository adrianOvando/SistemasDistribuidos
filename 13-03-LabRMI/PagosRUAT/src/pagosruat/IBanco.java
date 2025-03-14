/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pagosruat;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;



/**
 *
 * @author Adrian
 */
public interface IBanco extends Remote{
    
   public ArrayList<Deuda>ObtenerDeuda(String CI) throws RemoteException;
   public boolean Pagar(Deuda deuda) throws RemoteException;
    
}
