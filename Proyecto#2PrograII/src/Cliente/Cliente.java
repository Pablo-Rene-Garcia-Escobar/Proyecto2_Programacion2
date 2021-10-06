package Cliente;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Esta es la clase cliente que establece una comuncacion con el servidor por medio del sockets
 * @author Albert Castañeda
 * @author Pablo Garcia
 */
public class Cliente {

    public static final int PUERTO = 4182;
    public static final String HOST = "localhost";
    public static Socket cs;

    /**
     * Metodo que establece la comunicacion con el servidor y recibe informacion de este
     */
    public static void startClient(){
        try{
            cs = new Socket(HOST, PUERTO);
            //leer mensaje del servidor
            BufferedReader entrada = new BufferedReader(new InputStreamReader(cs.getInputStream()));
            String mensajeRecibido = entrada.readLine();
            String[] mensajeS = mensajeRecibido.split(";");
            for(int i = 0; i < mensajeS.length; i++){
                System.out.println(mensajeS[i]);
            }
            entrada.close();
            cs.close();
        }catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args){
        startClient();
    }

}
