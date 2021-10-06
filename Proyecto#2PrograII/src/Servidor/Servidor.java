package Servidor;

import java.io.*;
import java.net.*;
import controller.*;

/**
 * Esta es la clase servidor que establece una comuncacion con el cliente por medio del sockets
 * @author Albert Castañeda
 * @author Pablo Garcia
 */
public class Servidor {

    public static final int PUERTO=4182;
    public static ServerSocket ss;
    public static Socket cs;
    public static DataOutputStream salidaCliente;

    /**
     * Metodo que establece la comunicacion con el cliente y le manda informacion a este
     * @param montoTotal total ingresado durante el dia
     * @param estacDisp numero de estacionamientos disponibles que tiene el estacionamiento
     * @param estacOcup numero de estacionamientos ocupados que tiene el estacionamiento
     * @throws Exception puede lanzar una excepcion y delega el manejo de esta al lugar donde se invoque
     */
    public static void startServer(double montoTotal, int estacDisp, int estacOcup) throws Exception{
        //Crear el socket del servidor y lo dejamos escuchando
        ss = new ServerSocket(PUERTO);
        cs = new Socket();
        for(int i = 0; i<10;i++){
            cs = ss.accept();
            //envio de datos al cliente
            salidaCliente = new DataOutputStream(cs.getOutputStream());
            String mensaje = "El total del dia es " + montoTotal + ";" +
                    "El estado actual del parqueo es: ;" +
                    "Estacionamientos ocupados: " + estacOcup + ";" +
                    "Estacionamientos libres: " + estacDisp + ";" +"------------------------\n";
            salidaCliente.writeUTF(mensaje);
        }
        //se cierra la comunicacion
        System.out.println("(SERVIDOR) La app finaliza");
        ss.close();
    }

    /**
     * Metodo para mandar parametros a mi servidor
     * @param totalDia total del ingresado durante el dia
     * @param estcDisp numero de estacionamientos disponibles que tiene el estacionamiento
     * @param estacOcup numero de estacionamientos ocupados que tiene el estacionamiento
     */
    public static void start(double totalDia, int estcDisp, int estacOcup) {
        try{
            System.out.println(RetirarVehiculo.estacionamientosOcupados);
            System.out.println(RetirarVehiculo.estacionamientosLibres);
            System.out.println(RetirarVehiculo.montoTotales);
            startServer(totalDia, estcDisp, estacOcup);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
