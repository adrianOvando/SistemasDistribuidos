/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lab2;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Adrian
 */
public interface IUniversidad extends Remote{
    public Diploma EmitirDiploma(String ci, String Nombres, String primerapellido, String segundoapellido,String fecha_nacimiento,Carrera Carrera) throws RemoteException;
    
    
}
