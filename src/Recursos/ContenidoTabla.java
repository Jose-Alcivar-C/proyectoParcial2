package Recursos;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ContenidoTabla 
{
    private StringProperty letra; 
    private StringProperty codigo;
    private IntegerProperty frecuencia;
    
    public ContenidoTabla(String letra, String codigo, Integer frecuencia)
    {
        this.letra = new SimpleStringProperty(letra);
        this.codigo = new SimpleStringProperty(codigo);
        this.frecuencia = new SimpleIntegerProperty(frecuencia);
    }
    
    public String getLetra() 
    {
        return letra.get();
    }

    public void setLetra(String letra) 
    {
        this.letra.set(letra);
    }

    public String getCodigo() 
    {
        return codigo.get();
    }

    public void setCodigo(String codigo) 
    {
        this.codigo.set(codigo);
    }

    public Integer getFrecuencia() 
    {
        return frecuencia.get();
    }

    public void setFrecuencia(Integer frecuencia) 
    {
        this.frecuencia.set(frecuencia);
    }
}
