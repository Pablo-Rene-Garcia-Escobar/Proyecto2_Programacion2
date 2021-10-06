package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import java.util.ArrayList;
import java.util.Date;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.*;
import utils.*;
import Servidor.*;
import java.time.LocalTime;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Clase que guarda los datos y maneja las acciones realizadas desde la interfaz IngresarVehiculo.fxml
 * @author Pablo Garcia
 * @author Albert Castañeda
 */
public class IngresarVehiculo{

    private int contMotos;
    private int contCamiones;
    private int contCarros;
    public static ArrayList<Vehiculo> v = new ArrayList<>();
    public TextField txtPlaca;
    public Button volver;
    public TextField txtMensaje;
    MetodosComunes sv = new MetodosComunes();

    /**
     * Metodo para guardar la informacion recibida del cliente
     * @param actionEvent un evento que que representa presionar un boton desde la interfaz
     */
    public void grabarPlaca(ActionEvent actionEvent){
        String placa = txtPlaca.getText();
        txtPlaca.setText("");
        Date fecha = new Date();
        boolean lleno = true;
        LocalTime HoraInicio = LocalTime.now();
        int startTime = sv.calcularTiempo(HoraInicio);
        if(placa.charAt(0) == 'P' && contCarros < EstablecerDatos.estCar){
            contCarros++;
            Vehiculo c = new Vehiculo(contCarros, placa, fecha, TipoVehiculo.CARRO, startTime);
            lleno = false;
            v.add(c);
            try{
                sv.generarTicket(contCarros, placa, fecha);
                txtMensaje.setText("Ticket Generado");
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        if(placa.charAt(0) == 'M' && contMotos < EstablecerDatos.estMo) {
            contMotos++;
            Vehiculo m = new Vehiculo(contMotos, placa, fecha, TipoVehiculo.MOTO, startTime);
            lleno = false;
            v.add(m);
            try{
                sv.generarTicket(contMotos, placa, fecha);
                txtMensaje.setText("Ticket Generado");
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        if(placa.charAt(0) == 'C' && contCamiones < EstablecerDatos.estCam){
            contCamiones++;
            Vehiculo c = new Vehiculo(contCamiones, placa, fecha, TipoVehiculo.CAMION, startTime);
            lleno = false;
            v.add(c);
            try{
                sv.generarTicket(contCamiones, placa, fecha);
                txtMensaje.setText("Ticket Generado");
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        if(lleno == true){
            txtMensaje.setText("El estacionamiento esta lleno");
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
