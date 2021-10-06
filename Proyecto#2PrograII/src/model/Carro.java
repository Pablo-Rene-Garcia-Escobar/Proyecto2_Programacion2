package model;

/**
 * Subclase que hereda de la superclase Vehiculo y representa un vehiculo carro
 * @author Pablo Garcia
 * @author Albert Castañeda
 **/
public class Carro extends Vehiculo{

    /**
     * Motodo contructor que no recibe parametros
     */
    public Carro(){
    }

    /**
     * Devuelve el total a pagar para los carros
     * @param tiempo tiempo que estuvo en el estacinamiento el carro
     * @param tarifa tarifa a pagar
     * @return devuelve el total a pagar
     */
    public double monto(int tiempo, double tarifa){

        double montoTotal = tiempo*tarifa;

        return montoTotal;
    }

}
