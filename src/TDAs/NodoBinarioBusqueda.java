package TDAs;

public class NodoBinarioBusqueda 
{
    private Huffman contenido;
    private ArbolBinarioBusqueda derecho;
    private ArbolBinarioBusqueda izquierdo;

    public NodoBinarioBusqueda()
    {
        this.contenido = null;
        this.derecho = null;
        this.izquierdo = null;
    }
    
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public NodoBinarioBusqueda(Huffman contenido)
    {
        this.contenido = contenido;
        this.derecho = null;
        this.izquierdo = null;
    }
    
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public Huffman getContenido() 
    {
        return contenido;
    }

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void setContenido(Huffman contenido) 
    {
        this.contenido = contenido;
    }

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public ArbolBinarioBusqueda getDerecho() 
    {
        return derecho;
    }

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void setDerecho(ArbolBinarioBusqueda derecho) 
    {
        this.derecho = derecho;
    }

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public ArbolBinarioBusqueda getIzquierdo() 
    {
        return izquierdo;
    }
  
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void setIzquierdo(ArbolBinarioBusqueda izquierdo) 
    {
        this.izquierdo = izquierdo;
    }
    
}
