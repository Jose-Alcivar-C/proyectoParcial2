package Menu;

import Recursos.Iniciadores;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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
    private void accionCodificarArchivo(ActionEvent event) 
    {
        codificarNuevoArchivo.setDisable(false);
        try
        {
            Iniciadores.elegirArchivo(tablaDeFrecuencia, letra, frecuencia, codigo);
            
        }
        
        catch(Exception e)
        {
            System.out.println("Elija un archivo");
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        codificarNuevoArchivo.setDisable(true);
        tablaDeFrecuencia.setVisible(false);
    }    
    
}
