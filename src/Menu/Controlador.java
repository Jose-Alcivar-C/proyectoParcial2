package Menu;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controlador implements Initializable 
{   
    @FXML
    private Button codificarNuevoArchivo;
    
    
    @FXML
    private void accionCodificarArchivo(ActionEvent event) 
    {
        codificarNuevoArchivo.setDisable(false);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        codificarNuevoArchivo.setDisable(true);
    }    
    
}
