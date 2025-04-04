/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primerparcial;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adrian
 */
public class Ruat extends UnicastRemoteObject implements IRuat {

    ArrayList<Deuda> deudas;

    public Ruat() throws RemoteException {
        super();

        deudas = new ArrayList<>();
        deudas.add(new Deuda("1234567", 2022, Impuesto.vehiculo, 2451));
        deudas.add(new Deuda("1234567", 2022, Impuesto.casa, 2500));
        deudas.add(new Deuda("555587", 2021, Impuesto.vehiculo, 5000));
        deudas.add(new Deuda("333357", 2023, Impuesto.casa, 24547));
    }

    @Override
    public Deuda[] buscar(String CI) throws RemoteException {
        ArrayList<Deuda> resultado = new ArrayList<>();
        for (Deuda deuda : deudas) {
            if (deuda.getCI().equals(CI)) {
                resultado.add(deuda);
            }
        }
        return resultado.toArray(new Deuda[0]);
    }

    @Override
    public Boolean Pagar(Deuda deuda) throws RemoteException {
        for (int i = 0; i < this.deudas.size(); i++) {
            Deuda d = this.deudas.get(i);
            if (d.getCI().equals(deuda.getCI())
                    && d.getAnio() == deuda.getAnio()
                    && d.getIn().equals(deuda.getIn())
                    && d.getMonto() == deuda.getMonto()) {

                this.deudas.remove(i);
                return true;
            }
        }
        return false;
    }

}
