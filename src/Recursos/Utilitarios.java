package Recursos;

import TDAs.ArbolBinarioBusqueda;
import TDAs.Huffman;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;

public class Utilitarios 
{
    //este metodo lee un archivo de texto y retorna un mapa con cada caracter y su frecuencia.
    public static Map<Character, Integer> lectorDeArchivo(String nombreDelArchivo)
    {
        Map<Character, Integer> datos = new TreeMap<>();
        
        try
        {
           FileReader lec1 = new FileReader(nombreDelArchivo);
           BufferedReader lec2 = new BufferedReader(lec1);
           String linea;
           
           while((linea = lec2.readLine())!= null)
           {
               char[] caracteres = linea.toCharArray();
               
               for(char letra: caracteres)
               {
                   if(datos.containsKey(letra))
                   {
                       int frecuencia = datos.get(letra)+1;
                       datos.put(letra, frecuencia);
                   }
                   
                   else
                   {
                       datos.put(letra, 1);
                   }
               }
           }
           
           lec1.close();
       }
        
       catch(IOException e)
       {
           System.out.println("No se encuentra el archivo" + e);
       }
        
        return datos;
    }
    
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //este metodo recibe el mapa de frecuencias de caracteres y crea la cola de Prioridad de los Arboles
    public static PriorityQueue<ArbolBinarioBusqueda> creadorCola(Map<Character, Integer> mapaDeFrecuencias)
    {
        if(!mapaDeFrecuencias.isEmpty() && mapaDeFrecuencias != null)
        {
            PriorityQueue<ArbolBinarioBusqueda> colaDeArboles = new PriorityQueue<>((num1, num2)->
            { 
                return (num1.getRaiz().getContenido().getFrecuencia() - num2.getRaiz().getContenido().getFrecuencia());
            });
            
            Set<Character> claves = mapaDeFrecuencias.keySet();
            Iterator<Character> iterador = claves.iterator();
        
            while(iterador.hasNext())
            {
                Character letra = iterador.next();
                int frecuencia = mapaDeFrecuencias.get(letra);
                Huffman capsula = new Huffman(String.valueOf(letra), frecuencia);
                ArbolBinarioBusqueda arbolito = new ArbolBinarioBusqueda(capsula);
                colaDeArboles.add(arbolito);
            }
            
            return colaDeArboles;
        }
        
        else
        {
            System.out.println("no hay datos");
            return null;
        }
    }
}
