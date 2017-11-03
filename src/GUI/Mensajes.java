/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Alisoft
 */
public class Mensajes {
    public void mostrarMensajeGuardar(String m) {
        JOptionPane.showMessageDialog(null, m, "", JOptionPane.INFORMATION_MESSAGE,
                new ImageIcon(getClass().getResource("/imagenes/icons8-Guardar-25.png"))
        );
    }
    
    public void mostrarMensaje(String m,String rutaIcono) {
        JOptionPane.showMessageDialog(null, m, "", JOptionPane.INFORMATION_MESSAGE,
                new ImageIcon(getClass().getResource(rutaIcono))
        );
    }
    
    public void mostrarMensaje(String m,String rutaIcono, String title) {
        JOptionPane.showMessageDialog(null, m, title, JOptionPane.INFORMATION_MESSAGE,
                new ImageIcon(getClass().getResource(rutaIcono))
        );
    }
}
