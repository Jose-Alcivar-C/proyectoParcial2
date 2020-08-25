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
    
    public StringProperty getLetra() 
    {
        return letra;
    }

    public void setLetra(SimpleStringProperty letra) 
    {
        this.letra = letra;
    }

    public StringProperty getCodigo() 
    {
        return codigo;
    }

    public void setCodigo(SimpleStringProperty codigo) 
    {
        this.codigo = codigo;
    }

    public IntegerProperty getFrecuencia() 
    {
        return frecuencia;
    }

    public void setFrecuencia(SimpleIntegerProperty frecuencia) 
    {
        this.frecuencia = frecuencia;
    }
}
