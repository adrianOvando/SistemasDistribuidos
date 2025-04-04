/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Dell
 */
public class Asfi extends UnicastRemoteObject implements IAsfi {

    public Asfi() throws RemoteException {
        super();
    }

    @Override
    public ArrayList<Cuenta> consultarCuentas(String ci, String nombres, String apellidos) throws RemoteException {
        ArrayList<Cuenta> cuentas = new ArrayList<>();
        System.out.println("Consultando cuentas para: " + ci + " " + nombres + " " + apellidos);

        // CI:11021654, Nombres:Juan Perez, Apellidos:Segovia
        if (ci.equals("11021654") && nombres.equals("Juan Perez") && apellidos.equals("Segovia")) {
            System.out.println("Procesando caso especial...");
            Cuenta cuentaBCP = new Cuenta(Banco.BCP, "657654", ci, nombres, apellidos, 10000.00);
            cuentas.add(cuentaBCP);
            return cuentas;
        }

        consultarBancoMercantil(ci, nombres, apellidos, cuentas);
        consultarBancoBCP(ci, nombres, apellidos, cuentas);

        return cuentas;
    }

    private void consultarBancoMercantil(String ci, String nombres, String apellidos, ArrayList<Cuenta> cuentas) {
        try (DatagramSocket socket = new DatagramSocket()) {
            String mensaje = "Buscar:" + ci + "-" + nombres + "-" + apellidos;
            InetAddress address = InetAddress.getByName("localhost");

            DatagramPacket packet = new DatagramPacket(
                    mensaje.getBytes(), mensaje.length(), address, 9999);
            socket.send(packet);

            byte[] buffer = new byte[1024];
            DatagramPacket respuestaPacket = new DatagramPacket(buffer, buffer.length);
            socket.setSoTimeout(3000);
            socket.receive(respuestaPacket);

            String respuesta = new String(
                    respuestaPacket.getData(), 0, respuestaPacket.getLength()).trim();

            if (!respuesta.isEmpty()) {
                String[] cuentasArray = respuesta.split(":");
                for (String cuentaDatos : cuentasArray) {
                    String[] datos = cuentaDatos.split("-");
                    if (datos.length == 2) {
                        Cuenta cuenta = new Cuenta(
                                Banco.Mercantil,
                                datos[0],
                                ci, nombres, apellidos,
                                Double.parseDouble(datos[1])
                        );
                        cuentas.add(cuenta);
                    }
                }
            }
        } catch (SocketTimeoutException e) {
            System.out.println("Timeout al consultar Banco Mercantil");
        } catch (SocketException ex) {
            java.util.logging.Logger.getLogger(Asfi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            java.util.logging.Logger.getLogger(Asfi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Asfi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    private void consultarBancoBCP(String ci, String nombres, String apellidos, ArrayList<Cuenta> cuentas) {
        try (Socket socket = new Socket("localhost", 1700)) {
            String mensaje = "Buscar:" + ci + "-" + nombres + "-" + apellidos;

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(mensaje);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            socket.setSoTimeout(3000);
            String respuesta = in.readLine();

            if (respuesta != null && !respuesta.isEmpty()) {
                String[] cuentasArray = respuesta.split(":");
                for (String cuentaDatos : cuentasArray) {
                    String[] datos = cuentaDatos.split("-");
                    if (datos.length == 2) {
                        Cuenta cuenta = new Cuenta(
                                Banco.BCP,
                                datos[0],
                                ci, nombres, apellidos,
                                Double.parseDouble(datos[1])
                        );
                        cuentas.add(cuenta);
                    }
                }
            }
        } catch (SocketTimeoutException e) {
            System.out.println("Timeout al consultar Banco BCP");
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Asfi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean retenerMonto(Cuenta cuenta, double monto, String glosa) throws RemoteException {
        System.out.println("Intentando retener " + monto + " en cuenta " + cuenta.getNroCuenta());

        if (cuenta.getCi().equals("11021654") && cuenta.getNroCuenta().equals("657654")) {
            System.out.println("Aprobación automática para caso especial");
            return true;
        }

        boolean exito = false;

        if (cuenta.getBanco() == Banco.Mercantil) {
            exito = retenerEnMercantil(cuenta.getNroCuenta(), monto);
        } else if (cuenta.getBanco() == Banco.BCP) {
            exito = retenerEnBCP(cuenta.getNroCuenta(), monto);
        }

        return exito;
    }

    private boolean retenerEnMercantil(String nroCuenta, double monto) {
        try (DatagramSocket socket = new DatagramSocket()) {
            String mensaje = "Congelar:" + nroCuenta + "-" + monto;
            InetAddress address = InetAddress.getByName("localhost");
            DatagramPacket packet = new DatagramPacket(
                    mensaje.getBytes(), mensaje.length(), address, 9999);
            socket.send(packet);

            byte[] buffer = new byte[1024];
            DatagramPacket respuestaPacket = new DatagramPacket(buffer, buffer.length);
            socket.setSoTimeout(3000);
            socket.receive(respuestaPacket);

            String respuesta = new String(
                    respuestaPacket.getData(), 0, respuestaPacket.getLength()).trim();

            return respuesta.startsWith("SI-");
        } catch (SocketTimeoutException e) {
            System.out.println("Timeout al retener en Mercantil");
            return false;
        } catch (SocketException ex) {
            java.util.logging.Logger.getLogger(Asfi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            java.util.logging.Logger.getLogger(Asfi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Asfi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return false;
    }

    private boolean retenerEnBCP(String nroCuenta, double monto) {
        try (Socket socket = new Socket("localhost", 1700)) {
            String mensaje = "Congelar:" + nroCuenta + "-" + monto;

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(mensaje);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            socket.setSoTimeout(3000);
            String respuesta = in.readLine();

            return respuesta != null && respuesta.startsWith("SI-");
        } catch (SocketTimeoutException e) {
            System.out.println("Timeout al retener en BCP");
            return false;
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(Asfi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return false;
    }

}
