package Main;

import Recursos.Utilitarios;
import TDAs.ArbolBinarioBusqueda;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Menu extends Application 
{
    @Override
    public void start(Stage primaryStage) 
    {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        Map<Character, Integer> mapa = Utilitarios.lectorDeArchivo("cien años de soledad.txt");
        
        Set<Character> conjunto = mapa.keySet();
        Iterator<Character> it = conjunto.iterator();
        while(it.hasNext())
        {
            Character clave = it.next();
            System.out.println(clave + " : " + mapa.get(clave));
        }
        
        PriorityQueue<ArbolBinarioBusqueda> colita = Utilitarios.creadorCola(mapa);
        System.out.println(mapa.size()+", " + colita.size());
    }

    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public static void main(String[] args) 
    {
        launch(args);
    }
    
}
