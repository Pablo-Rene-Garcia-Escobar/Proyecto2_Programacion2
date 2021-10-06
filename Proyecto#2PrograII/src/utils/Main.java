package utils;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Clase que ejecuta el programa
 * @author Pablo Garcia
 * @author Albert Castañeda
 */
public class Main extends Application{

    /**
     * Metodo para levantar la interfaz MenuPrincipal.fxml
     * @param primaryStage crea la primera escena de la interfaz
     * @throws Exception  puede lanzar una excepcion y delega el manejo de la esta al lugar donde se invoque
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane root = (Pane) FXMLLoader.load(getClass().getResource("/view/EstablecerDatos.fxml"));
        primaryStage.setTitle("Establecer Datos de Estacionamiento");
        Scene scene = new Scene(root, 600,400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
