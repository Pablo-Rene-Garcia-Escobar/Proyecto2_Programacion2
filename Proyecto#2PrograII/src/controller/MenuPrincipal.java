package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import utils.MetodosComunes;

/**
 * Clase que maneja las acciones que el cliente quiere realizar dentro del parqueo
 * @author Pablo Garcia
 * @author Albert Casteñeda
 */
public class MenuPrincipal {

    public Button salirSistema1;
    public Button salirSistema2;
    public Button salirSistema3;
    MetodosComunes sv = new MetodosComunes();

    /**
     * Metodo para levantar la interfaz IngresarVehiculo.fxml
     * @param actionEvent un evento que que representa presionar un boton desde la interfaz
     * @throws Exception puede lanzar una excepcion y delega el manejo de esta al lugar donde se invoque
     */
    public void ingresarVehiculo(ActionEvent actionEvent) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/IngresarVehiculo.fxml"));
        Pane root = (Pane) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Ingresar Vehiculo");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
        sv.salirGeneral(salirSistema1);
    }

    /**
     * Metodo para levantar la interfaz RetirarVehiculo.fxml
     * @param actionEvent un evento que que representa presionar un boton desde la interfaz
     * @throws Exception puede lanzar una excepcion y delega el manejo de esta al lugar donde se invoque
     */
    public void retirarVehiculo(ActionEvent actionEvent) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/RetirarVehiculo.fxml"));
        Pane root = (Pane) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Retirar vehiculo");
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
        sv.salirGeneral(salirSistema2);
    }



    /**
     * Metodo para salir cerrar el programa
     * @param actionEvent un evento que que representa presionar un boton desde la interfaz
     */
    public void salir(ActionEvent actionEvent) {
        sv.salirGeneral(salirSistema3);
    }



}
