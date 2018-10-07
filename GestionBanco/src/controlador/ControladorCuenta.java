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
public class ControladorCuenta implements ActionListener, MouseListener {

    public VistaCuenta vcu = new VistaCuenta();
    public MetodoCuenta mcu = new MetodoCuenta();
    public VistaInicial vi = new VistaInicial();

    public ControladorCuenta(VistaCuenta vcu) {

        this.vcu = vcu;

    }

    public enum accionesCuenta {

        AGREGAR, MODIFICAR, BORRAR, VOLVER;

    }

    public void Iniciar() throws SQLException {

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(vcu);
            vcu.setVisible(true);
            vcu.setLocationRelativeTo(null);
        } catch (UnsupportedLookAndFeelException ex) {
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        }

        vcu.jTable1.addMouseListener(this);
        vcu.jTable1.setModel(new DefaultTableModel());

        vcu.jButton1.setActionCommand("AGREGAR");
        vcu.jButton1.addActionListener(this);
        vcu.jButton2.setActionCommand("MODIFICAR");
        vcu.jButton2.addActionListener(this);
        vcu.jButton3.setActionCommand("BORRAR");
        vcu.jButton3.addActionListener(this);
        vcu.jButton4.setActionCommand("VOLVER");
        vcu.jButton4.addActionListener(this);

        vcu.jTable1.setModel(mcu.cogerCuentasBBDD());
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
                switch (accionesCuenta.valueOf(e.getActionCommand())) {

            case VOLVER:

                vcu.setVisible(false);
                new ControladorInicial(vi).Iniciar();

                break;

            case AGREGAR:

                break;

            case BORRAR:

                break;

            case MODIFICAR:

                break;
        }
    }
    
        private void presionarJTable1(java.awt.event.MouseEvent e) {

        if (e.getButton() == 1)// boton izquierdo
        {
            int fila = this.vcu.jTable1.rowAtPoint(e.getPoint());
            if (fila > -1) {

                vcu.jFormattedTextField3.setText(String.valueOf(vcu.jTable1.getValueAt(fila, 0)));
                vcu.jFormattedTextField4.setText(String.valueOf(vcu.jTable1.getValueAt(fila, 1)));
                vcu.jFormattedTextField6.setText(String.valueOf(vcu.jTable1.getValueAt(fila, 2)));
                vcu.jFormattedTextField7.setText(String.valueOf(vcu.jTable1.getValueAt(fila, 3)));
                vcu.jFormattedTextField8.setText(String.valueOf(vcu.jTable1.getValueAt(fila, 4)));
                vcu.jFormattedTextField9.setText(String.valueOf(vcu.jTable1.getValueAt(fila, 5)));

            }

        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
        presionarJTable1(e);
        
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
