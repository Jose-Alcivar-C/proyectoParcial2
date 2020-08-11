package TDAs;

public class ArbolBinarioBusqueda 
{
    private NodoBinarioBusqueda raiz;
    
    public ArbolBinarioBusqueda()
    {
        this.raiz = new NodoBinarioBusqueda();
    }
    
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public ArbolBinarioBusqueda(Huffman contenido)
    {
        this.raiz = new NodoBinarioBusqueda(contenido);
    }
    
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ 
    public NodoBinarioBusqueda getRaiz() 
    {
        return this.raiz;
    }

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void setRaiz(NodoBinarioBusqueda raiz) 
    {
        this.raiz = raiz;
    }

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void setIzquierdo(ArbolBinarioBusqueda arbol) 
    {
        this.raiz.setIzquierdo(arbol);
    }

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void setDerecho(ArbolBinarioBusqueda arbol) 
    {
        this.raiz.setDerecho(arbol);
    }

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public ArbolBinarioBusqueda getIzquierdo() 
    {
        return this.raiz.getIzquierdo();
    }

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public ArbolBinarioBusqueda getDerecho() 
    {
        return this.raiz.getDerecho();
    }

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public boolean estaVacio() 
    {
        return this.raiz == null;
    }

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public boolean esHoja() 
    {
        return (this.getIzquierdo() == null && this.getDerecho() == null);
    }
}
