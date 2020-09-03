package Menu;

import Recursos.Iniciadores;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class Controlador implements Initializable 
{   
    private String rutaLectura;
    private Map<String, String> caracteres;
    
    @FXML
    private Label rutaMostrada;
    
    @FXML
    private Label mensajito;
    
    @FXML
    private TextArea escritoOriginal;
    
    @FXML
    private ImageView tiempoReal;
    
    @FXML
    private TextArea escritoCodificado;
    
    @FXML
    private Label mensajito2;
    
    @FXML
    private TextArea escritoOriginal2;
    
    @FXML
    private ImageView decoTiempoReal;
    
    @FXML
    private TextArea escritoCodificado2;
    
    @FXML
    private ImageView codificarNuevoArchivo;
    
    @FXML
    private ImageView elegirArchivo;
    
    @FXML
    private ImageView guardarArchivo;
    
    @FXML
    private ImageView ocultarTabla;
    
    @FXML
    private ImageView mostrarTabla;
    
    @FXML
    private TableView tablaDeFrecuencia;
    
    @FXML
    private TableColumn letra;
    
    @FXML
    private TableColumn frecuencia;
    
    @FXML
    private TableColumn codigo;
    
    
    @FXML
    private Label escritura;
    
    @FXML
    private void accionCodificarArchivo(MouseEvent event) 
    {   
        try
        {
            rutaLectura = Iniciadores.elegirArchivo();
            caracteres = Iniciadores.mostrarCodificacion(rutaLectura, tablaDeFrecuencia, letra, frecuencia, codigo);
            elegirArchivo.setVisible(false);
            Iniciadores.activador(mostrarTabla, codificarNuevoArchivo, guardarArchivo, tiempoReal, decoTiempoReal);
            rutaMostrada.setText("Archivo leído --> " + rutaLectura);
        }
        
        catch(Exception e)
        {
            System.out.print("");
        }
    }
    
    @FXML
    private void accionCodificarNuevo(MouseEvent event)
    {
        Iniciadores.desactivador(tablaDeFrecuencia, mostrarTabla, ocultarTabla, codificarNuevoArchivo, guardarArchivo, tiempoReal, 
                   escritoOriginal, escritoCodificado, mensajito, decoTiempoReal, escritoOriginal2, escritoCodificado2, mensajito2);
        elegirArchivo.setVisible(true);
        escritoOriginal2.clear();
        escritoCodificado2.clear();
        escritoOriginal.clear();
        escritoCodificado.clear();
        rutaMostrada.setText("");
    }
            
    @FXML
    private void accionMostrar(MouseEvent event)
    {
            tablaDeFrecuencia.setVisible(true);
            mostrarTabla.setVisible(false); 
            ocultarTabla.setVisible(true);
    }
    
    @FXML
    private void accionOcultar(MouseEvent event)
    {
            tablaDeFrecuencia.setVisible(false);
            mostrarTabla.setVisible(true);
            ocultarTabla.setVisible(false);
    }
    
    @FXML
    private void guardarFichero(MouseEvent event)
    {
       try
       {
            Iniciadores.guardarFichero(rutaLectura, caracteres);
       }
       
       catch(Exception e)
       {
           System.out.print("");
       }
    }
    
    @FXML
    private void botonCodificarTiempoReal(MouseEvent event)
    {
        if(escritoOriginal.isVisible() && mensajito.isVisible() && escritoCodificado.isVisible())
        {
            escritoOriginal.setVisible(false);
            mensajito.setVisible(false);
            escritoCodificado.setVisible(false);
        }
        
        else
        {
            escritoOriginal.setVisible(true);
            mensajito.setVisible(true);
            escritoCodificado.setVisible(true);
        }
    }
    
    @FXML
    private void botonDecodificarTiempoReal(MouseEvent event)
    {
        if(escritoOriginal2.isVisible() && mensajito2.isVisible() && escritoCodificado2.isVisible())
        {
            escritoOriginal2.setVisible(false);
            mensajito2.setVisible(false);
            escritoCodificado2.setVisible(false);
        }
        
        else
        {
            escritoOriginal2.setVisible(true);
            mensajito2.setVisible(true);
            escritoCodificado2.setVisible(true);
        }
    }
    
    @FXML
    private void codificarTiempoReal(KeyEvent event)
    {
        Iniciadores.codificadorTiempoReal(escritoOriginal, escritoCodificado, caracteres);
    }
    
    @FXML
    private void decodificarTiempoReal(KeyEvent event)
    {
        Iniciadores.decodificadorTiempoReal(escritoOriginal2, escritoCodificado2, caracteres);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        escritoOriginal.setWrapText(true);
        escritoCodificado.setWrapText(true);
        escritoOriginal2.setWrapText(true);
        escritoCodificado2.setWrapText(true);
        Iniciadores.desactivador(tablaDeFrecuencia, mostrarTabla, ocultarTabla, codificarNuevoArchivo, guardarArchivo, tiempoReal,
                                escritoOriginal, escritoCodificado, mensajito, decoTiempoReal, escritoOriginal2, escritoCodificado2, mensajito2);
    }    
}
