/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import GUI.GUI;

/**
 *
 * @author Alisoft
 */
public interface ClaveInterfaz {
    public void modificarClave(GUI gui);
    public String getNombre();
    public boolean isEditable();
    public String cifrar(String m);
    public String cifrar(String m, String separador);
    public String descifrar(String c);    
    public String descifrar(String c, String separador);
    public void mostrarEstructura(GUI gui);
    @Override
    public String toString();
}
