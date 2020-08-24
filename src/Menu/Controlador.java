package Menu;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    private void accionCodificarArchivo(ActionEvent event) 
    {
        codificarNuevoArchivo.setDisable(false);
        botonMostrar.setText("ocultar");
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
