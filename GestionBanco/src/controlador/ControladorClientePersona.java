/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import vista.*;
import modelo.*;

/**
 *
 * @author carde
 */
public class ControladorClientePersona implements ActionListener, MouseListener {

    public VistaClientePersona vcp = new VistaClientePersona();
    public MetodoClientePersona mcp = new MetodoClientePersona();
    public VistaInicial vi = new VistaInicial();
    public MetodoDireccion mDirec = new MetodoDireccion();

    public ControladorClientePersona(VistaClientePersona vcp) {

        this.vcp = vcp;

    }

    public enum accionesClientePersona {

        AGREGAR, MODIFICAR, BORRAR, VOLVER, DIRECCIONES;

    }

    public void Iniciar() throws SQLException {

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(vcp);
            vcp.setVisible(true);
            vcp.setLocationRelativeTo(null);
        } catch (UnsupportedLookAndFeelException ex) {
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        }

        vcp.jTable1.addMouseListener(this);
        vcp.jTable1.setModel(new DefaultTableModel());

        vcp.jButton1.setActionCommand("AGREGAR");
        vcp.jButton1.addActionListener(this);
        vcp.jButton2.setActionCommand("MODIFICAR");
        vcp.jButton2.addActionListener(this);
        vcp.jButton3.setActionCommand("BORRAR");
        vcp.jButton3.addActionListener(this);
        vcp.jButton4.setActionCommand("VOLVER");
        vcp.jButton4.addActionListener(this);
        vcp.jButton5.setActionCommand("DIRECCIONES");
        vcp.jButton5.addActionListener(this);
        
        vcp.jTable1.setModel(mcp.cogerClientesPersonaBBDD());
        vcp.jTable3.setModel(mDirec.cogerDireccionesBBDD("DIREC_PERS"));
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (accionesClientePersona.valueOf(e.getActionCommand())) {

            case VOLVER:

                vcp.setVisible(false);
                new ControladorInicial(vi).Iniciar();

                break;

            case AGREGAR:

                break;

            case BORRAR:

                break;

            case MODIFICAR:

                break;

            case DIRECCIONES:
                
                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
