package controller;


import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import utils.*;

/**
 * Clase que se utilizda para guardar las configuraciones del sistema
 * @author Albert Castañeda
 * @author Pablo Garcia
 */
public class EstablecerDatos {

    public TextField txtMotos;
    public TextField txtCarros;
    public TextField txtCamiones;
    public TextField txtTarifa;
    public TextField txtMensaje;
    public Button cerrarPestania;
    public static int estMo;
    public static int estCar;
    public static int estCam;
    public static double tarifa;
    MetodosComunes sv = new MetodosComunes();


    /**
     * Metodo para guardar la informacion recibida del cliente
     * @param actionEvent un evento que representa presionar un boton desde la interfaz
     */
    public void grabarDatos(ActionEvent actionEvent){
        estMo = Integer.parseInt(txtMotos.getText());
        estCar = Integer.parseInt(txtCarros.getText());
        estCam = Integer.parseInt(txtCamiones.getText());
        tarifa = Double.parseDouble(txtTarifa.getText());
        txtMotos.setText("");
        txtCarros.setText("");
        txtCamiones.setText("");
        txtTarifa.setText("");
        txtMensaje.setText("Informacion grabada");
    }

    /**
     * Metodo para levantar la interfaz MenuPrincipal.fxml
     * @param actionEvent un evento que que representa presionar un boton desde la interfaz
     * @throws Exception puede lanzar una excepcion y delega el manejo de esta al lugar donde se invoque
     */
    public void MenuPrincipal(ActionEvent actionEvent) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/MenuPrincipal.fxml"));
        Pane root = (Pane) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Menu Principal");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
        sv.salirGeneral(cerrarPestania);
    }

}
