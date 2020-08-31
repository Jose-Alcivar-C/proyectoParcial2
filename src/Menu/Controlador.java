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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Controlador implements Initializable 
{   
    private String rutaLectura;
    private Map<String, String> caracteres;
    
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
            Iniciadores.activador(mostrarTabla, codificarNuevoArchivo, guardarArchivo);
        }
        
        catch(Exception e)
        {
            System.out.print("");
        }
    }
    
    @FXML
    private void accionCodificarNuevo(MouseEvent event)
    {
        Iniciadores.desactivador(tablaDeFrecuencia, mostrarTabla, ocultarTabla, codificarNuevoArchivo, guardarArchivo);
        elegirArchivo.setVisible(true);
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        Iniciadores.desactivador(tablaDeFrecuencia, mostrarTabla, ocultarTabla, codificarNuevoArchivo, guardarArchivo);
    }    
}
