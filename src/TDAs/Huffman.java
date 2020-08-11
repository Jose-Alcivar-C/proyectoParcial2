package TDAs;

public class Huffman 
{
    private String contenido;
    private int frecuencia; //cuantas veces está el caracter
    private int bit; //contiene valor de 1 ó 0;

    public Huffman(String contenido, int frecuencia, int bit)
    {
        this.contenido = contenido;
        this.frecuencia = frecuencia;
        this.bit = bit;
    }
    
    public Huffman(String contenido, int frecuencia)
    {
        this.contenido = contenido;
        this.frecuencia = frecuencia;
    }
    
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public String getContenido() 
    {
        return contenido;
    }

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void setContenido(String contenido) 
    {
        this.contenido = contenido;
    }

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public int getFrecuencia() 
    {
        return frecuencia;
    }

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void setFrecuencia(int frecuencia) 
    {    
        this.frecuencia = frecuencia;
    }

    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public int getBit()
    {
        return bit;
    }
    
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    public void setBit(int bit) 
    {
        this.bit = bit;
    }
}
