package Recursos;

import TDAs.ArbolBinarioBusqueda;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import javafx.scene.control.TableView;

public class Iniciadores 
{
    public static void mostrarCodificacion(String archivoALeer)
    {
        Map<Character, Integer> mapita = Utilitarios.lectorDeArchivo(archivoALeer);
        PriorityQueue<ArbolBinarioBusqueda> colita = Utilitarios.creadorCola(mapita);
        ArbolBinarioBusqueda fin = Utilitarios.generarArbolDelTexto(colita);
        
        Set<Character> conjunto = mapita.keySet();
        Iterator<Character> iterador = conjunto.iterator();
        while(iterador.hasNext())
        {
            Character letra = iterador.next();
            System.out.println(letra + " : " + Utilitarios.generadorDeCodigo(fin, String.valueOf(letra), ""));
        }
    }
}
