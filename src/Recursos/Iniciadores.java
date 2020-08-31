package Recursos;

import TDAs.ArbolBinarioBusqueda;
import java.io.File;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

public class Iniciadores
{
    //Este método setea los valores que contendrá la tabla de informacion del archivo
    public static Map<String, String> mostrarCodificacion(String archivoALeer, TableView tabla, TableColumn letra, TableColumn frecuencia, TableColumn codigo)
    {
        //esta lista contiene los elementos que irán en la tabla
        ObservableList<ContenidoTabla> llenar = FXCollections.observableArrayList();
        
        Map<String, String> valores = new TreeMap<>();
        
        Map<String, Integer> mapita = Utilitarios.lectorDeArchivo(archivoALeer);
        PriorityQueue<ArbolBinarioBusqueda> colita = Utilitarios.creadorCola(mapita);
        ArbolBinarioBusqueda arbolito = Utilitarios.generarArbolDelTexto(colita);
       
        while(!colita.isEmpty())
        {
            String caracterBuscado = colita.remove().getRaiz().getContenido().getContenido();
            int frec =  mapita.get(caracterBuscado);
            String cod = Utilitarios.generadorDeCodigo(arbolito, caracterBuscado, "");
            
            ContenidoTabla agregar = new ContenidoTabla(caracterBuscado, cod, frec);
            llenar.add(agregar);
            
            valores.put(caracterBuscado, cod);
        }
        
        letra = (TableColumn<ContenidoTabla, String>)tabla.getColumns().get(0);
        frecuencia = (TableColumn<ContenidoTabla, Integer>)tabla.getColumns().get(1);
        codigo = (TableColumn<ContenidoTabla, String>)tabla.getColumns().get(2);
        
        letra.setCellValueFactory(new PropertyValueFactory<ContenidoTabla, String>("letra"));
        frecuencia.setCellValueFactory(new PropertyValueFactory<ContenidoTabla, Integer>("frecuencia"));
        codigo.setCellValueFactory(new PropertyValueFactory<ContenidoTabla, String>("codigo"));
        
        tabla.setItems(llenar);
        
        return valores;
    }
    
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //Este método nos permite escoger un archivo dandole clic
    public static String elegirArchivo()
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
                System.out.println(ruta);
                return ruta;
            }
        }
        
        catch(NullPointerException error)
        {
            System.out.println("elija un archivo");
        }
        
        return null;
    }
    
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //Este método nos permite guardar un archivo a elección
    public static void guardarFichero(String rutaParaLeer, Map<String, String> arbolBase)
    {
        FileChooser elegirArchivo = new FileChooser();
        elegirArchivo.setTitle("Seleccione ruta para guardar");
        elegirArchivo.getExtensionFilters().add(new FileChooser.ExtensionFilter("archivo de texto","*.txt"));
        
        File archivo = elegirArchivo.showSaveDialog(null);
        String ruta = archivo.getAbsolutePath();
        
        try
        {
            if(archivo != null)
            {
                Utilitarios.escritorDeArchivo(rutaParaLeer, arbolBase, ruta);
            }
        }
        
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //Este método inhabilita todo lo que recibe por parámetro
    public static void desactivador(TableView tabla, ImageView mostrarTabla, ImageView ocultarTabla, ImageView codificar, ImageView guardar)
    {
        tabla.setVisible(false);
        mostrarTabla.setVisible(false);
        ocultarTabla.setVisible(false);
        codificar.setVisible(false);
        guardar.setVisible(false);
    }
    
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //Este método habilita todo lo que recibe por parámetro
    public static void activador(ImageView mostrarTabla, ImageView codificar, ImageView guardar)
    {
        mostrarTabla.setVisible(true);
        codificar.setVisible(true);
        guardar.setVisible(true);
    }
}
