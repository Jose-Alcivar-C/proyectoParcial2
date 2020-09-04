package recursos;

import TDAs.ArbolBinarioBusqueda;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

/**
 *
 * @author Grupo 3
 */

public class Iniciadores
{
    //Este método setea los valores que contendrá la tabla de informacion del archivo  leído
    public static Map<String, String> mostrarCodificacion(String archivoALeer, TableView tabla)
    {
        ObservableList<ContenidoTabla> llenar = FXCollections.observableArrayList();//esta lista contiene los elementos que 
                                                                                    //irán en la tabla de frecuencias
        
        Map<String, String> valores = new TreeMap<>();//mapa de letra y codigo
        
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
       
        return ruta;
    }
    
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //Este método nos permite guardar un archivo a elección de ruta
    public static void guardarFichero(String rutaParaLeer, Map<String, String> arbolBase)
    {
        FileChooser elegirArchivo = new FileChooser();
        elegirArchivo.setTitle("Seleccione ruta para guardar");
        elegirArchivo.getExtensionFilters().add(new FileChooser.ExtensionFilter("archivo de texto","*.txt"));
        
        File archivo = elegirArchivo.showSaveDialog(null);
        String ruta = archivo.getAbsolutePath();
        
        Utilitarios.escritorDeArchivo(rutaParaLeer, arbolBase, ruta);
    }
    
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //Este método inhabilita todo lo que recibe por parámetro
    public static void desactivador(TableView tabla, ImageView mostrarTabla, ImageView ocultarTabla, ImageView codificar, ImageView guardar, 
                                    ImageView tiempoReal, TextArea escritoOriginal, TextArea escritoCodificado, Label mensajito,
                                    ImageView decoTiempoReal, TextArea escritoOriginal2, TextArea escritoCodificado2, Label mensajito2)
    {
        tabla.setVisible(false);
        mostrarTabla.setVisible(false);
        ocultarTabla.setVisible(false);
        codificar.setVisible(false);
        guardar.setVisible(false);
        tiempoReal.setVisible(false);
        escritoOriginal.setVisible(false);
        escritoCodificado.setVisible(false);
        mensajito.setVisible(false);
        decoTiempoReal.setVisible(false);
        escritoOriginal2.setVisible(false);
        escritoCodificado2.setVisible(false);
        mensajito2.setVisible(false);
    }
    
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //Este método habilita todo lo que recibe por parámetro
    public static void activador(ImageView mostrarTabla, ImageView codificar, ImageView guardar, ImageView tiempoReal, ImageView decoTiempoReal) 
    {
        mostrarTabla.setVisible(true);
        codificar.setVisible(true);
        guardar.setVisible(true);
        tiempoReal.setVisible(true);
        decoTiempoReal.setVisible(true);
    }
    
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //Este método lee y escribe codigo en tiempo real
    public static void codificadorTiempoReal(TextArea escritoOriginal, TextArea escritoCodificado, Map<String, String> mapaDeFrecuencias)
    {
        String leido = escritoOriginal.getText();
        escritoCodificado.setText("");
        char[] caracteres = leido.toCharArray();
        String codigo = "";
        
        for(char letrita: caracteres)
        {
            String valor = String.valueOf(letrita);
            
            if(mapaDeFrecuencias.containsKey(valor))
            {
                codigo = codigo + mapaDeFrecuencias.get(valor);
            }
            
            else
            {
                codigo = codigo + "";
            }
        }
        escritoCodificado.setText(codigo);
    }
    
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //Este método recibe un mapa de (letras y codigos) y devuelve un mapa de (codigos y letras)
    private static Map<String, String> mapaInverso(Map<String, String> mapaDeCodigos)
    {
        if(mapaDeCodigos != null)
        {
            Map<String, String> mapaInverso = new TreeMap<>();
            
            Set<String> claves = mapaDeCodigos.keySet();
            Iterator<String> iterador = claves.iterator();
            
            while(iterador.hasNext())
            {
                String cla = iterador.next();
                String val = mapaDeCodigos.get(cla);
                
                mapaInverso.put(val, cla);
            }
            
            return mapaInverso;
        }
        
        else
        {
            return null;
        }
    }
    
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //Este método lee codigo y escribe letra en tiempo real
    public static void decodificadorTiempoReal(TextArea escritoOriginal2, TextArea escritoCodificado2, Map<String, String> mapaDeFrecuencias)
    {
        if(mapaDeFrecuencias!=null)
        {
            Map<String, String> nuevoMapa;//mapa de codigo  y letra
            nuevoMapa = mapaInverso(mapaDeFrecuencias);
            
            String codLeido = escritoCodificado2.getText();
            escritoOriginal2.setText("");
            char[] binario = codLeido.toCharArray();
            
            String textoParaEscribir ="";
            String buscado ="";
            
            for(char bit: binario)
            {
                buscado = buscado + String.valueOf(bit);
                
                if(nuevoMapa.containsKey(buscado))
                {
                    textoParaEscribir = textoParaEscribir + nuevoMapa.get(buscado);
                    buscado = "";
                }
            }
            escritoOriginal2.setText(textoParaEscribir);
        }
    }
}
