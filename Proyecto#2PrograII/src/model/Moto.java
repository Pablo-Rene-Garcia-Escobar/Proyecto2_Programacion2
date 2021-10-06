package model;

/**
 * Subclase que hereda de la superclase Vehiculo y representa un vehiculo motocicleta
 * @author Pablo Garcia
 * @author Albert Castañeda
 **/
public class Moto extends Vehiculo{

    /**
     * Motodo contructor que no recibe parametros
     */
    public Moto(){
    }

    /**
     * Devuelve el total a pagar para los carros
     * @param tiempo tiempo que estuvo en el estacinamiento la moto
     * @param tarifa tarifa a pagar
     * @return devuelve el total a pagar
     */
    public double monto(int tiempo, double tarifa){
        double monto = tiempo * tarifa;
        double montoTotal = monto-(monto*0.10);
        return montoTotal;
    }

}
