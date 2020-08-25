package Recursos;

import TDAs.ArbolBinarioBusqueda;
import java.io.File;
import java.util.Map;
import java.util.PriorityQueue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.util.Callback;

public class Iniciadores
{
    public static void mostrarCodificacion(String archivoALeer, TableView tabla, TableColumn letra, TableColumn frecuencia, TableColumn codigo)
    {
        ObservableList<ContenidoTabla> llenar = FXCollections.observableArrayList();
        
        Map<String, Integer> mapita = Utilitarios.lectorDeArchivo(archivoALeer);
        PriorityQueue<ArbolBinarioBusqueda> colita = Utilitarios.creadorCola(mapita);
        ArbolBinarioBusqueda fin = Utilitarios.generarArbolDelTexto(colita);
       
        while(!colita.isEmpty())
        {
            String buscado = colita.remove().getRaiz().getContenido().getContenido();
            llenar.add(new ContenidoTabla(buscado, Utilitarios.generadorDeCodigo(fin, buscado, ""), mapita.get(buscado)));
        }
        
        letra = (TableColumn<ContenidoTabla, String>)tabla.getColumns().get(0);
        frecuencia = (TableColumn<ContenidoTabla, Integer>)tabla.getColumns().get(1);
        codigo = (TableColumn<ContenidoTabla, String>)tabla.getColumns().get(2);
        
        letra.setCellValueFactory(new PropertyValueFactory<ContenidoTabla, String>("letra"));
        frecuencia.setCellValueFactory(new PropertyValueFactory<ContenidoTabla, Integer>("frecuencia"));
        codigo.setCellValueFactory(new PropertyValueFactory<ContenidoTabla, String>("codigo"));
  
        tabla.setItems(llenar);
    }
    
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //Este método nos permite escoger un archivo dandole clic
    public static void elegirArchivo(TableView tabla, TableColumn letra, TableColumn frecuencia, TableColumn codigo)
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
                mostrarCodificacion(ruta, tabla, letra, frecuencia, codigo);
                System.out.println(ruta);
            }
        }
        
        catch(NullPointerException error)
        {
            System.out.println("elija un archivo");
        }
    }
}
