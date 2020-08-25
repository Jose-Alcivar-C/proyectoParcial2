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
    public static Map<String, Integer> lectorDeArchivo(String nombreDelArchivo)
    {
        Map<String, Integer> datos = new TreeMap<>();
        
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
                   String agregar = String.valueOf(letra);
                   if(datos.containsKey(agregar))
                   {
                       int frecuencia = datos.get(agregar)+1;
                       datos.put(agregar, frecuencia);
                   }
                   
                   else
                   {
                       datos.put(agregar, 1);
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
    public static PriorityQueue<ArbolBinarioBusqueda> creadorCola(Map<String, Integer> mapaDeFrecuencias)
    {
        if(!mapaDeFrecuencias.isEmpty() && mapaDeFrecuencias != null)
        {
            PriorityQueue<ArbolBinarioBusqueda> colaDeArboles = new PriorityQueue<>((arb1, arb2)->
            { 
                if(arb1.getRaiz().getContenido().getFrecuencia() == arb2.getRaiz().getContenido().getFrecuencia())
                {
                    return(arb1.getRaiz().getContenido().getContenido().compareTo(arb2.getRaiz().getContenido().getContenido()));
                }
                
                else
                {
                    return (arb1.getRaiz().getContenido().getFrecuencia() - arb2.getRaiz().getContenido().getFrecuencia());
                }
            });
            
            Set<String> claves = mapaDeFrecuencias.keySet();
            Iterator<String> iterador = claves.iterator();
        
            while(iterador.hasNext())
            {
                String letra = iterador.next();
                int frecuencia = mapaDeFrecuencias.get(letra);
                
                Huffman capsula = new Huffman(letra, frecuencia);
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
    
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //Este método retorna el árbol de Busqueda a partir de la cola de prioridad
    public static ArbolBinarioBusqueda generarArbolDelTexto(PriorityQueue<ArbolBinarioBusqueda> colaDePrioridad)
    {
        if(colaDePrioridad != null)
        {   
            PriorityQueue<ArbolBinarioBusqueda> copiaDeCola = new PriorityQueue<>(colaDePrioridad);
            
            while(!copiaDeCola.isEmpty() && copiaDeCola.size()>1)
            {
               ArbolBinarioBusqueda arb1 = copiaDeCola.remove();
               ArbolBinarioBusqueda arb2 = copiaDeCola.remove();
               
               String contenido1 = arb1.getRaiz().getContenido().getContenido();
               String contenido2 = arb2.getRaiz().getContenido().getContenido();
               
               int frecuencia1 = arb1.getRaiz().getContenido().getFrecuencia();
               int frecuencia2 = arb2.getRaiz().getContenido().getFrecuencia();
               
               Huffman nuevoNodo = new Huffman(contenido1+contenido2, frecuencia1+frecuencia2);
               ArbolBinarioBusqueda nuevoArbol = new ArbolBinarioBusqueda(nuevoNodo);
               
               arb1.getRaiz().getContenido().setBit("0");
               arb2.getRaiz().getContenido().setBit("1");
               
               nuevoArbol.setIzquierdo(arb1);
               nuevoArbol.setDerecho(arb2);
               
               copiaDeCola.add(nuevoArbol);
           }
           
            return copiaDeCola.remove();
       }
       
       else
       {
           System.out.println("La cola está vacía");
           return null;
       }
    }
    
    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //Este método retorna el código Huffman de la letra buscada, en base a un árbol pasado como parámetro
    public static String generadorDeCodigo(ArbolBinarioBusqueda arbol, String letraBuscada, String concatenar)
    {
        if(arbol != null)
        {
            if(arbol.getIzquierdo().getRaiz().getContenido().getContenido().indexOf(letraBuscada) == -1)
            {
                if(letraBuscada.equals(arbol.getDerecho().getRaiz().getContenido().getContenido()))
                {
                    return ( concatenar + arbol.getDerecho().getRaiz().getContenido().getBit());
                }
                
                else
                {
                    concatenar = concatenar + arbol.getDerecho().getRaiz().getContenido().getBit();
                    return ( generadorDeCodigo(arbol.getDerecho(), letraBuscada , concatenar) );
                }
            }
            
            else
            {
                if(letraBuscada.equals(arbol.getIzquierdo().getRaiz().getContenido().getContenido()))
                {
                    return ( concatenar + arbol.getIzquierdo().getRaiz().getContenido().getBit());
                }
                
                else
                {
                    concatenar = concatenar + arbol.getIzquierdo().getRaiz().getContenido().getBit();
                    return ( generadorDeCodigo(arbol.getIzquierdo(), letraBuscada , concatenar) );
                }   
            }
        }
        
        else
        {
            return null;
        }
    }
    

    //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    /***
     * Este método retorna el caracter equivalente a cierta cadena de bits
     * @param arbol arbol binario de huffman
     * @param codigo secuencia de unos y ceros
     * @return 
     */
    public static String generadorDeCaracteres(ArbolBinarioBusqueda arbol, String codigo)
    {
        if(arbol == null || codigo.equals(""))
        {
            return null;
        }
        
        Character caracter = codigo.charAt(0);
        
        if( caracter == '0')
        {
            ArbolBinarioBusqueda subarbolIzquierdo = arbol.getIzquierdo();
            
            if(subarbolIzquierdo.esHoja())
            {   
                return subarbolIzquierdo.getRaiz().getContenido().getContenido();
            }
            else
            {
                return generadorDeCaracteres(subarbolIzquierdo, codigo.substring(1));
            }
        }
        else if (caracter == '1' )
        {
            ArbolBinarioBusqueda subarbolDerecho = arbol.getDerecho();
            
            if(subarbolDerecho.esHoja())
            {
                return subarbolDerecho.getRaiz().getContenido().getContenido();
            }
            else
            {
                return generadorDeCaracteres(subarbolDerecho, codigo.substring(1));
            }
        }
        return null;
    }
    
    
    
    
}

