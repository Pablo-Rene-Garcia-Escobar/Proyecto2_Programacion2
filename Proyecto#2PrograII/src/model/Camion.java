package model;

/**
 * Subclase que hereda de la superclase Vehiculo y representa un vehiculo camion
 * @author Pablo Garcia
 * @author Albert Castañeda
 **/
public class Camion extends Vehiculo{

    /**
     * Motodo contructor que no recibe parametros
     */
    public Camion(){
    }

    /**
     * Devuelve el total a pagar de los camiones
     * @param periodos periodos que estuvo en el estacionamiento
     * @return devuelve el total a pagar
     */
    public double monto(int periodos){
        double montoTotal = 0;
        if(periodos == 1){
            montoTotal = ((30*periodos)+(5*(periodos-1)));
        }else {
            montoTotal = ((30*periodos)+(5*(periodos-1))-30);
        }
        return montoTotal;
    }
}
