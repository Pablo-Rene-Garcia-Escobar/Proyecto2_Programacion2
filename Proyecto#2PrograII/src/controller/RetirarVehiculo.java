package controller;

import Servidor.Servidor;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import utils.MetodosComunes;
import java.util.Date;
import java.time.LocalTime;
import java.util.concurrent.ThreadLocalRandom;
import model.*;

/**
 * Clase que guarda los datos y maneja las acciones realizadas desde la interfaz RetirarVehiculo.fxml
 * @author Pablo Garcia
 * @author Albert Castañeda
 */
public class RetirarVehiculo {

    public TextField txtPlaca;
    public Button volver;
    public TextField txtMensaje;
    public TextField txtNit;
    MetodosComunes sv = new MetodosComunes();
    Moto m = new Moto();
    Carro car = new Carro();
    Camion cam = new Camion();
    public static double montoTotal = 0;
    public static int estacionamientosOcupados = IngresarVehiculo.v.size();
    public static int totalEstacionamientos = EstablecerDatos.estMo + EstablecerDatos.estCar + EstablecerDatos.estCam;
    public static int estacionamientosLibres = totalEstacionamientos - estacionamientosOcupados;
    public static double montoTotales;

    /**
     * Metodo que calcula el total ingresado en el dia
     * @param monto el monto a pagar de cada vehiculo que sale del estacionamiento
     */
    public static void calcularTotal(double monto){
        montoTotales = montoTotales + monto;
    }

    /**
     * Metodo que crea el hilo para ejecutar el servidor
     */
    public static void inicializar(){
        Thread hilo = new Thread("Hilo de servidor"){
            public void run(){
                Servidor.start(montoTotales, estacionamientosLibres, estacionamientosOcupados);
            }
        };
        hilo.start();
    }


    /**
     * Metodo para guardar la informacion recibida del cliente
     * @param actionEvent un evento que que representa presionar un boton desde la interfaz
     */
    public void grabarPlaca(ActionEvent actionEvent) {
        String placa = txtPlaca.getText();
        txtPlaca.setText("");

        int x = 0;
        LocalTime tiempoFinal = LocalTime.now();
        int endTime = sv.calcularTiempo(tiempoFinal);

        double tarifa = EstablecerDatos.tarifa;
        if(placa.charAt(0) == 'M'){
            for(x = 0; x<IngresarVehiculo.v.size(); x++){
                if(placa.equals(IngresarVehiculo.v.get(x).getPlaca())){
                    Date dateEntrada = IngresarVehiculo.v.get(x).getFechayHoraEntrada();
                    Date dateSalida = new Date();
                    String nit = txtNit.getText();
                    txtNit.setText("");
                    int startTime = IngresarVehiculo.v.get(x).getSegundos();
                    int totalTime = endTime - startTime;
                    double monto = totalTime*tarifa;
                    double descuento = monto * 0.10;
                    double recargo = 0;
                    montoTotal = m.monto(totalTime, tarifa);
                    calcularTotal(montoTotal);
                    IngresarVehiculo.v.remove(x);
                    try{
                        sv.generarFactura(placa, nit, dateEntrada, dateSalida, monto, descuento, recargo, montoTotal);
                        inicializar();
                        txtMensaje.setText("Factura generada");
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
        if(placa.charAt(0) == 'P'){
            for(x = 0; x<IngresarVehiculo.v.size(); x++){
                if(placa.equals(IngresarVehiculo.v.get(x).getPlaca())){
                    Date dateEntrada = IngresarVehiculo.v.get(x).getFechayHoraEntrada();
                    Date dateSalida = new Date();
                    String nit = txtNit.getText();
                    txtNit.setText("");
                    int startTime = IngresarVehiculo.v.get(x).getSegundos();
                    int totalTime = endTime - startTime;
                    double monto = totalTime*tarifa;
                    double descuento = 0;
                    double recargo = 0;
                    montoTotal = car.monto(totalTime, tarifa);
                    calcularTotal(montoTotal);
                    IngresarVehiculo.v.remove(x);
                    try{
                        sv.generarFactura(placa, nit, dateEntrada, dateSalida, monto, descuento, recargo, montoTotal);
                        inicializar();
                        txtMensaje.setText("Factura generada");
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
        if(placa.charAt(0) == 'C'){
            for(x = 0; x<IngresarVehiculo.v.size(); x++){
                if(placa.equals(IngresarVehiculo.v.get(x).getPlaca())){
                    Date dateEntrada = IngresarVehiculo.v.get(x).getFechayHoraEntrada();
                    Date dateSalida = new Date();
                    String nit = txtNit.getText();
                    txtNit.setText("");
                    int startTime = IngresarVehiculo.v.get(x).getSegundos();
                    int totalTime = endTime - startTime;

                    double monto = 30;
                    double descuento = 0;
                    double recargo = 0;
                    int periodos = 0;
                    if(totalTime > 0 && totalTime<=60){
                        recargo = 0;
                        periodos = 1;
                    }
                    if(totalTime > 60 && totalTime<=120){
                        recargo = 5;
                        periodos = 2;
                    }
                    if(totalTime > 120 && totalTime<=180){
                        recargo = 10;
                        periodos = 3;
                    }
                    if(totalTime > 180 && totalTime<=240){
                        recargo = 15;
                        periodos = 4;
                    }
                    if(totalTime > 240 && totalTime<=300){
                        recargo = 20;
                        periodos = 5;
                    }
                    if(totalTime > 300 && totalTime<=360){
                        recargo = 25;
                        periodos = 6;
                    }
                    if(totalTime > 360 && totalTime<=420){
                        recargo = 30;
                        periodos = 7;
                    }
                    if(totalTime > 420 && totalTime<=480){
                        recargo = 35;
                        periodos = 8;
                    }
                    if(totalTime > 480 && totalTime<=540){
                        recargo = 40;
                        periodos = 9;
                    }
                    if(totalTime > 540 && totalTime<=600){
                        recargo = 45;
                        periodos = 10;
                    }
                    if(totalTime > 600 && totalTime<=660){
                        recargo = 50;
                        periodos = 11;
                    }
                    if(totalTime > 660 && totalTime<=720){
                        recargo = 55;
                        periodos = 12;
                    }
                    if(totalTime > 720 && totalTime<=780){
                        recargo = 60;
                        periodos = 13;
                    }
                    montoTotal = cam.monto(periodos);
                    calcularTotal(montoTotal);
                    IngresarVehiculo.v.remove(x);
                    try{
                        sv.generarFactura(placa, nit, dateEntrada, dateSalida, monto, descuento, recargo, montoTotal);
                        inicializar();
                        txtMensaje.setText("Factura generada");
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }

    /**
     * Metodo para levantar de nuevo la interfaz del MenuPrincipal.fxml y cerrar la interfaz IngresarVehiculo.fxml
     * @param actionEvent un evento que representa presionar un boton desde la interfaz
     * @throws Exception puede lanzar una excepcion y delega el manejo de esta al lugar donde se invoque
     */
    public void volverMenu(ActionEvent actionEvent) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/MenuPrincipal.fxml"));
        Pane root = (Pane) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Menu Principal");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
        sv.salirGeneral(volver);
    }


}
