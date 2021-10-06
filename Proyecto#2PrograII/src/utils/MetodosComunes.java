package utils;

import Servidor.Servidor;
import controller.EstablecerDatos;
import controller.IngresarVehiculo;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.PDPage;
import java.time.LocalTime;

import java.util.Date;

/**
 * Clase que contiene metodos convocados mas de una vez en el programa ya que tienen como objetivo realizar las mismas acciones cada vez que son convocados
 * @author Pablo Garcia
 * @author Albert Castañeda
 */
public class MetodosComunes {

    /**
     * Metodo para cerrar las pestañas de la interfaz
     * @param b recibe el identificador de un boton de la interfaz
     */
    public void salirGeneral(Button b){
        Stage stage = (Stage) b.getScene().getWindow();
        stage.close();
    }

    /**
     * Metodo que genera un ticket para los vehiculos que ingresan al estacionamiento
     * @param noEstacionamiento numero de estacionamiento asignado al vehiculo
     * @param placa placa del vehiculo que ingreso
     * @param fecha fecha y hora de ingreso al estacionamiento
     * @throws Exception puede lanzar una excepcion y delega el manejo de esta al lugar donde se invoque
     */
    public void generarTicket(int noEstacionamiento, String placa, Date fecha) throws Exception{
        PDDocument documento = new PDDocument();
        PDPage pagina = new PDPage(PDRectangle.A5);
        documento.addPage(pagina);
        PDPageContentStream contenido = new PDPageContentStream(documento, pagina);

        String contS = Integer.toString(noEstacionamiento);

        for (int i = 1; i <= 4; i++) {
            contenido.beginText();
            contenido.setFont(PDType1Font.TIMES_BOLD, 12);
            if (i == 1) {
                contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                contenido.showText("--------------------------------------Ticket--------------------------------------");
            }
            if (i == 2 && contS.length() == 1) {
                contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                contenido.showText("Numero de estacionamiento: 00" + noEstacionamiento);
            }
            if (i == 2 && contS.length() == 2) {
                contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                contenido.showText("Numero de estacionamiento: 0" + noEstacionamiento);
            }
            if (i == 2 && contS.length() == 3) {
                contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                contenido.showText("Numero de estacionamiento: " + noEstacionamiento);
            }
            if (i == 3) {
                contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                contenido.showText("Placa del vehiculo: " + placa);
            }
            if (i == 4) {
                contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                contenido.showText("Fecha y Hora de entrada: " + fecha);
            }

            contenido.endText();
        }
        contenido.close();

        documento.save("C:/Ticket/ticket.pdf");
    }

    /**
     * Metodo que genera la factura para los vehiculos que salen del estacionamiento
     * @param placa placa del vehiculo que sale del estacionamiento
     * @param NIT NIT de la persona para utilizarlo en la factura
     * @param entrada feha y hora de entrada al estacionamiento
     * @param salida fecha y hora de salida al estacionamiento
     * @param monto monto a pagar sin aplicar los descuentos y recargos pertinentes
     * @param descuento descuento realizado al vehiculo
     * @param recargo recargo realizado al vehiculo
     * @param montoTotal monto total a pagar
     * @throws Exception puede lanzar una excepcion y delega el manejo de esta al lugar donde se invoque
     */
    public void generarFactura(String placa, String NIT, Date entrada, Date salida, double monto, double descuento, double recargo, double montoTotal) throws Exception{
        if(placa.charAt(0)=='M'){
            PDDocument documento = new PDDocument();
            PDPage pagina = new PDPage(PDRectangle.A6);
            documento.addPage(pagina);
            PDPageContentStream contenido = new PDPageContentStream(documento, pagina);

            for (int i = 1; i <= 8; i++) {
                contenido.beginText();
                contenido.setFont(PDType1Font.TIMES_BOLD, 12);
                if (i == 1) {
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                    contenido.showText("--------------------------Factura--------------------------");
                }
                if (i == 2) {
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                    contenido.showText("NIT de factura:" + NIT);
                }
                if (i == 3) {
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                    contenido.showText("Hora de entrada: " + entrada);
                }
                if (i == 4) {
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                    contenido.showText("Hora de salida: " + salida);
                }
                if (i == 5) {
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                    contenido.showText("Precio por tarifa: " + monto);
                }
                if (i == 6) {
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                    contenido.showText("Descuento: " + descuento);
                }
                if (i == 7) {
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                    contenido.showText("Recargo: " + recargo);
                }
                if (i == 8) {
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                    contenido.showText("Monto a pagar: " + montoTotal);
                }

                contenido.endText();
            }
            contenido.close();

            documento.save("C:/Facturas/factura.pdf");
        }

        if(placa.charAt(0)=='P'){
            PDDocument documento = new PDDocument();
            PDPage pagina = new PDPage(PDRectangle.A6);
            documento.addPage(pagina);
            PDPageContentStream contenido = new PDPageContentStream(documento, pagina);

            for (int i = 1; i <= 8; i++) {
                contenido.beginText();
                contenido.setFont(PDType1Font.TIMES_BOLD, 12);
                if (i == 1) {
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                    contenido.showText("--------------------------Factura--------------------------");
                }
                if (i == 2) {
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                    contenido.showText("NIT de factura:" + NIT);
                }
                if (i == 3) {
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                    contenido.showText("Hora de entrada: " + entrada);
                }
                if (i == 4) {
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                    contenido.showText("Hora de salida: " + salida);
                }
                if (i == 5) {
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                    contenido.showText("Precio por tarifa: " + monto);
                }
                if (i == 6) {
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                    contenido.showText("Descuento: " + descuento);
                }
                if (i == 7) {
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                    contenido.showText("Recargo: " + recargo);
                }
                if (i == 8) {
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                    contenido.showText("Monto a pagar: " + montoTotal);
                }

                contenido.endText();
            }
            contenido.close();

            documento.save("C:/Facturas/factura.pdf");
        }

        if(placa.charAt(0)=='C'){
            PDDocument documento = new PDDocument();
            PDPage pagina = new PDPage(PDRectangle.A6);
            documento.addPage(pagina);
            PDPageContentStream contenido = new PDPageContentStream(documento, pagina);

            for (int i = 1; i <= 8; i++) {
                contenido.beginText();
                contenido.setFont(PDType1Font.TIMES_BOLD, 12);
                if (i == 1) {
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                    contenido.showText("--------------------------Factura--------------------------");
                }
                if (i == 2) {
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                    contenido.showText("NIT de factura:" + NIT);
                }
                if (i == 3) {
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                    contenido.showText("Hora de entrada: " + entrada);
                }
                if (i == 4) {
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                    contenido.showText("Hora de salida: " + salida);
                }
                if (i == 5) {
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                    contenido.showText("Precio por tarifa: " + monto);
                }
                if (i == 6) {
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                    contenido.showText("Descuento: " + descuento);
                }
                if (i == 7) {
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                    contenido.showText("Recargo: " + recargo);
                }
                if (i == 8) {
                    contenido.newLineAtOffset(20, pagina.getMediaBox().getHeight() - (52 * i));
                    contenido.showText("Monto a pagar: " + montoTotal);
                }

                contenido.endText();
            }
            contenido.close();

            documento.save("C:/Facturas/factura.pdf");
        }


    }

    /**
     * Devuelve el tiempo en segundos que ha transcurrido en el dia
     * @param tiempo hora, minuto y segundo exacto en el que se invoco este metodo
     * @return tiempo en segundos que ha transcurrido en el dia
     */
    public int calcularTiempo(LocalTime tiempo){
        String hora = tiempo + "";
        char min1 = hora.charAt(3);
        char min2 = hora.charAt(4);
        char seg1 = hora.charAt(6);
        char seg2 = hora.charAt(7);
        String minuto = "" + min1 + min2;
        String segundo = "" + seg1 +seg2;
        int min = Integer.parseInt(minuto);
        int seg = Integer.parseInt(segundo);
        int totalSegs = (min * 60) + seg;
        return totalSegs;
    }


}
