package model;

import utils.TipoVehiculo;

import java.util.Date;

/**
 * Superclase de las diferentes clases de vehiculo y representa a todos los tipos de vehiculos que pueden acceder al estacionamiento
 * @author Pablo Garcia
 * @author Albert Castañeda
 **/
public class Vehiculo {

    private int noEstacionamiento;
    private String placa;
    private Date fechayHoraEntrada;
    private TipoVehiculo tipoVehiculo;
    private int segundos;

    /**
     * Motodo contructor que no recibe parametros
     */
    public Vehiculo(){
    }

    /**
     * Crea un objeto con la informacion que necesita el ticket y la factura, recibiendo como parametros datos importantes del registro al estacionamiento
     * @param noEstacionamiento numero de estacionamiento asignadon al vehiculo
     * @param placa placa del vehiculo que ingreso
     * @param fechayHoraEntrada fecha y hora de entrada del vehiculo al estacionamiento
     * @param tipoVehiculo tipo de vehiculo que ingreso al estacionamiento
     * @param segundos cantidad de segundos que han transcurrido en el dia hasta el momento de su ingreso al estacionamiento
     */
    public Vehiculo(int noEstacionamiento, String placa, Date fechayHoraEntrada, TipoVehiculo tipoVehiculo, int segundos) {
        this.noEstacionamiento = noEstacionamiento;
        this.placa = placa;
        this.fechayHoraEntrada = fechayHoraEntrada;
        this.tipoVehiculo = tipoVehiculo;
        this.segundos = segundos;
    }

    /**
     * Metodo para obtener la placa del vehiculo
     * @return la placa del vehiculo
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * Metodo para obtener la cantidad de segundos que han transcurrido en el dia hasta el momento de su ingreso al estacionamiento
     * @return cantidad de segundos que han transcurrido en el dia hasta el momento de su ingreso al estacionamiento
     */
    public int getSegundos() {
        return segundos;
    }

    /**
     *Metodo para obtener la fehca y hora de entrada al estacionamiento
     * @return la fecha y hora de entrada
     */
    public Date getFechayHoraEntrada() {
        return fechayHoraEntrada;
    }
}
