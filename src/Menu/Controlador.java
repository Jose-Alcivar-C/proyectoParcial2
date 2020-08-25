package Menu;

import Recursos.Iniciadores;
import TDAs.ArbolBinarioBusqueda;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

public class Controlador implements Initializable 
{   
    @FXML
    private Button codificarNuevoArchivo;
    
    @FXML
    private Button botonMostrar;
    
    @FXML
    private TableView tablaDeFrecuencia;
    
    @FXML
    private TableColumn letra;
    
    @FXML
    private TableColumn frecuencia;
    
    @FXML
    private TableColumn codigo;
    
    @FXML
    private Label mensaje;
    
    @FXML
    private Label mensaje1;
    
    @FXML
    private Label escritura;
    
    @FXML
    private Button botonCtr;
    
    @FXML
    private TextArea trCodificar;
    
    @FXML
    private TextArea trDecodificar;
    
    @FXML
    private void accionCodificarArchivo(ActionEvent event) 
    {
        codificarNuevoArchivo.setDisable(false);
        try
        {
            Iniciadores.elegirArchivo(tablaDeFrecuencia, letra, frecuencia, codigo);
            mensaje.setVisible(true);
            mensaje1.setVisible(false);
            
            botonCtr.setVisible(true);
            botonCtr.setText("Mostrar codificacion en tiempo real");
        }
        
        catch(Exception e)
        {
            mensaje.setVisible(false);
            mensaje1.setVisible(true);
            
            botonCtr.setVisible(false);
        }
    }
    
    @FXML
    private void accionMostrar(ActionEvent event)
    {
        if(botonMostrar.getText().equals("Mostrar"))
        {
            tablaDeFrecuencia.setVisible(true);
            botonMostrar.setText("Ocultar");
        }
        
        else
        {
            tablaDeFrecuencia.setVisible(false);
            botonMostrar.setText("Mostrar");
        }
    }
    
    
    @FXML
    private void llenar(ActionEvent event)
    {
       if(trCodificar.visibleProperty().get() && trDecodificar.visibleProperty().get())
       {
           trCodificar.setVisible(false);
           trDecodificar.setVisible(false);
           botonCtr.setText("Mostar codificacion en tiempo real");
        }
       else
       {
           trCodificar.setVisible(true);
           trDecodificar.setVisible(true);
           botonCtr.setText("Ocultar codificacion en tiempo real");
       }
    }
    
    @FXML
    private void Codificar()
    {
       String text = trCodificar.getText();
       String codificacion;
       
       // codificacion
       codificacion = Iniciadores.codificarCadena( Iniciadores.arbolito,  text );
       
       trDecodificar.setText(codificacion);
    }
    
    @FXML
    private void Decodificar()
    {
       String text = trDecodificar.getText();
       String decodificacion;
       
       // decodificacion
       decodificacion = Iniciadores.decodificarCadena( Iniciadores.arbolito,  text );
       
       trCodificar.setText(decodificacion);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        codificarNuevoArchivo.setDisable(true);
        tablaDeFrecuencia.setVisible(false);
        mensaje.setVisible(false);
        mensaje1.setVisible(false);
    }    
}
