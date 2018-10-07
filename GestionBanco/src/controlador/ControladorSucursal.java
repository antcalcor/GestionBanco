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
import javax.swing.JOptionPane;
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
public class ControladorSucursal implements ActionListener, MouseListener {

    public VistaSucursal vs = new VistaSucursal();
    public MetodoSucursal ms = new MetodoSucursal();
    public VistaInicial vi = new VistaInicial();

    public ControladorSucursal(VistaSucursal vs) {

        this.vs = vs;

    }

    public enum accionesSucursal {

        AGREGAR, MODIFICAR, BORRAR, VOLVER;

    }

    public void Iniciar() throws SQLException {

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(vs);
            vs.setVisible(true);
            vs.setLocationRelativeTo(null);
        } catch (UnsupportedLookAndFeelException ex) {
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        }

        vs.jTable1.addMouseListener(this);
        vs.jTable1.setModel(new DefaultTableModel());

        vs.jButton1.setActionCommand("AGREGAR");
        vs.jButton1.addActionListener(this);
        vs.jButton2.setActionCommand("MODIFICAR");
        vs.jButton2.addActionListener(this);
        vs.jButton3.setActionCommand("BORRAR");
        vs.jButton3.addActionListener(this);
        vs.jButton4.setActionCommand("VOLVER");
        vs.jButton4.addActionListener(this);

        vs.jTable1.setModel(ms.cogerSucursalesBBDD());

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (accionesSucursal.valueOf(e.getActionCommand())) {

            case VOLVER:

                vs.setVisible(false);
                new ControladorInicial(vi).Iniciar();

                break;

            case AGREGAR:

                int codSuc = Integer.parseInt(vs.jFormattedTextField1.getText());
                String calle = vs.jFormattedTextField2.getText();
                int codPost = Integer.parseInt(vs.jFormattedTextField3.getText());
                String ciudad = vs.jFormattedTextField4.getText();

                ms.nuevaSucursal(codSuc, calle, codPost, ciudad);

                vs.jFormattedTextField1.setText("");
                vs.jFormattedTextField2.setText("");
                vs.jFormattedTextField3.setText("");
                vs.jFormattedTextField4.setText("");

                 {
                    try {
                        vs.jTable1.setModel(ms.cogerSucursalesBBDD());
                    } catch (SQLException ex) {
                        Logger.getLogger(ControladorSucursal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

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
            int fila = this.vs.jTable1.rowAtPoint(e.getPoint());
            if (fila > -1) {

                vs.jFormattedTextField1.setText(String.valueOf(vs.jTable1.getValueAt(fila, 0)));
                vs.jFormattedTextField2.setText(String.valueOf(vs.jTable1.getValueAt(fila, 1)));
                vs.jFormattedTextField3.setText(String.valueOf(vs.jTable1.getValueAt(fila, 2)));
                vs.jFormattedTextField4.setText(String.valueOf(vs.jTable1.getValueAt(fila, 3)));

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
