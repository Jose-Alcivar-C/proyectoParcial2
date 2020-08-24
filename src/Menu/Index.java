package Menu;

import Recursos.Utilitarios;
import TDAs.ArbolBinarioBusqueda;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
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
        
        //Map<Character, Integer> mapita = Utilitarios.lectorDeArchivo("cien años de soledad.txt");
        //PriorityQueue<ArbolBinarioBusqueda> colita = Utilitarios.creadorColaDelTexto(mapita);
        ArbolBinarioBusqueda fin = Utilitarios.generarArbolDelTexto(Utilitarios.creadorColaDelTexto(Utilitarios.lectorDeArchivo("prueba.txt")));
        ArbolBinarioBusqueda iz = fin.getIzquierdo();
        ArbolBinarioBusqueda de = fin.getDerecho();
        System.out.println(fin.getRaiz().getContenido().getContenido()+ " : " + fin.getRaiz().getContenido().getFrecuencia() + " : " + fin.getRaiz().getContenido().getBit());
        System.out.println(iz.getRaiz().getContenido().getContenido()+ " : " + iz.getRaiz().getContenido().getFrecuencia() + " : " + iz.getRaiz().getContenido().getBit());
        System.out.println(de.getRaiz().getContenido().getContenido()+ " : " + de.getRaiz().getContenido().getFrecuencia() + " : " + de.getRaiz().getContenido().getBit());
        System.out.println(de.getIzquierdo().getRaiz().getContenido().getContenido()+ " : " + de.getIzquierdo().getRaiz().getContenido().getFrecuencia() + " : " + de.getIzquierdo().getRaiz().getContenido().getBit());
        System.out.println(de.getDerecho().getRaiz().getContenido().getContenido()+ " : " + de.getDerecho().getRaiz().getContenido().getFrecuencia() + " : " + de.getDerecho().getRaiz().getContenido().getBit());
        System.out.println("");
    }

    public static void main(String[] args) 
    {
        launch(args);
    }
    
}
