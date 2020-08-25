package Recursos;

import TDAs.ArbolBinarioBusqueda;
import java.io.File;
import java.util.Map;
import java.util.PriorityQueue;
import javafx.scene.Parent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JFileChooser;

public class Iniciadores
{
    public static void mostrarCodificacion(String archivoALeer)
    {
        Map<String, Integer> mapita = Utilitarios.lectorDeArchivo(archivoALeer);
        PriorityQueue<ArbolBinarioBusqueda> colita = Utilitarios.creadorCola(mapita);
        ArbolBinarioBusqueda fin = Utilitarios.generarArbolDelTexto(colita);
       
        while(!colita.isEmpty())
        {
            String buscado = colita.remove().getRaiz().getContenido().getContenido();
            System.out.println(buscado + " : " + mapita.get(buscado) + " : " + Utilitarios.generadorDeCodigo(fin, buscado, ""));
        }
    }
    
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //Este método nos permite escoger un archivo dandole clic
    public static void elegirArchivo()
    {
        FileChooser elegirArchivo = new FileChooser();
        elegirArchivo.setTitle("Elegir archivo de texto");
        elegirArchivo.getExtensionFilters().add(new FileChooser.ExtensionFilter("archivo de texto","*.txt"));
        
        File archivo = elegirArchivo.showOpenDialog(null);
        String ruta = archivo.getAbsolutePath();
        
        try
        {
            if(archivo != null)
            {
                mostrarCodificacion(ruta);
                System.out.println(ruta);
            }
        }
        
        catch(NullPointerException error)
        {
            System.out.println("elija un archivo");
        }
    }
}
