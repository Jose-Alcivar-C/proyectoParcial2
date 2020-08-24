package Menu;

import Recursos.Iniciadores;
import Recursos.Utilitarios;
import TDAs.ArbolBinarioBusqueda;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Index extends Application 
{
    
    @Override
    public void start(Stage stage) throws Exception 
    {
        Parent root = FXMLLoader.load(getClass().getResource("Ventana.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
        Iniciadores.mostrarCodificacion("cien años de soledad.txt");
    }

    public static void main(String[] args) 
    {
        launch(args);
    }
    
}
