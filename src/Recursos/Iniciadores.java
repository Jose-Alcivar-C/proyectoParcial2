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

public class Iniciadores
{
    public static ArbolBinarioBusqueda arbolito;
    
    
    //Este método setea los valores que contendrá la tabla de informacion del archivo
    public static void mostrarCodificacion(String archivoALeer, TableView tabla, TableColumn letra, TableColumn frecuencia, TableColumn codigo)
    {
        //esta lista contiene los elementos que irán en la tabla
        ObservableList<ContenidoTabla> llenar = FXCollections.observableArrayList();
        
        Map<String, Integer> mapita = Utilitarios.lectorDeArchivo(archivoALeer);
        PriorityQueue<ArbolBinarioBusqueda> colita = Utilitarios.creadorCola(mapita);
        arbolito = Utilitarios.generarArbolDelTexto(colita);
       
        while(!colita.isEmpty())
        {
            String caracterBuscado = colita.remove().getRaiz().getContenido().getContenido();
            int frec =  mapita.get(caracterBuscado);
            String cod = Utilitarios.generadorDeCodigo(arbolito, caracterBuscado, "");
            
            ContenidoTabla agregar = new ContenidoTabla(caracterBuscado, cod, frec);
            llenar.add(agregar);
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
   
    
    /***
     * Método para codificar una cadena
     * @param arbolito arbol binario de huffman
     * @param cadena secuencia de letras a codificar
     * @return cadena de texto codificada
     */
    public static String codificarCadena(ArbolBinarioBusqueda arbolito, String cadena )
    {
        StringBuilder cadenaCodificada = new StringBuilder();
        
        for(Character caracter : cadena.toCharArray()){
            String codigo = Utilitarios.generadorDeCodigo(arbolito, caracter.toString(), "");
            cadenaCodificada.append(codigo);
            
        }
        return cadenaCodificada.toString();
    }
    
    /***
     * Método para decodificar una cadena
     * @param arbolito arbol binario de huffman
     * @param cadena secuencia de unos y ceros a decodificar
     * @return cadena de texto decodificada
     */
    public static String decodificarCadena(ArbolBinarioBusqueda arbolito, String cadena )
    {
        StringBuilder cadenaCodificada = new StringBuilder();
        String tmp = "";
        
        for(Character bit : cadena.toCharArray())
        {
            tmp  = tmp + bit;
            String decodificacion = Utilitarios.generadorDeCaracteres( arbolito, tmp);
            
            if( decodificacion != null){
                cadenaCodificada.append(decodificacion);
                tmp = "";
            }
        }
        return cadenaCodificada.toString();
    }
}
