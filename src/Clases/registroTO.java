/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.Serializable;

/**
 *
 * @author Angello
 */
public class registroTO implements Serializable{
    String texto,criptograma,clave,fecha;    

    public registroTO(String texto, String criptograma, String clave, String fecha) {
        this.texto = texto;
        this.criptograma = criptograma;
        this.clave = clave;
        this.fecha = fecha;
    }
    
    public String toString(){
        return texto+" "+criptograma+" "+clave+" "+fecha;
    }


    public String getTexto() {
        return texto;
    }

    public String getCriptograma() {
        return criptograma;
    }

    public String getClave() {
        return clave;
    }

    public String getFecha() {
        return fecha;
    }
    
        
    
}
