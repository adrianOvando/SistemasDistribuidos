/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primerparcial;

import java.io.Serializable;

/**
 *
 * @author Adrian
 */
public class Deuda implements Serializable {

    private String CI;
    private int Anio;
    private Impuesto in;
    private double monto;

    public Deuda(String CI, int Anio, Impuesto in, double monto) {
        this.CI = CI;
        this.Anio = Anio;
        this.in = in;
        this.monto = monto;
    }

    public String getCI() {
        return CI;
    }

    public void setCI(String CI) {
        this.CI = CI;
    }

    public int getAnio() {
        return Anio;
    }

    public void setAnio(int Anio) {
        this.Anio = Anio;
    }

    public Impuesto getIn() {
        return in;
    }

    public void setIn(Impuesto in) {
        this.in = in;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Deuda{"
                + "CI='" + CI + '\''
                + ", Anio=" + Anio
                + ", Impuesto=" + in
                + ", Monto=" + monto
                + '}';
    }

}
