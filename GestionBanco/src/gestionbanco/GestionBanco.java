/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionbanco;

import controlador.ControladorInicial;
import vista.VistaInicial;

/**
 *
 * @author carde
 */
public class GestionBanco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new ControladorInicial(new VistaInicial()).Iniciar();
    }
    
}
