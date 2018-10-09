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
public class ControladorEmpleado implements ActionListener, MouseListener {

    public VistaEmpleado ve = new VistaEmpleado();
    public MetodoEmpleado me = new MetodoEmpleado();
    public VistaInicial vi = new VistaInicial();

    public ControladorEmpleado(VistaEmpleado ve) {

        this.ve = ve;

    }

    public enum accionesEmpleado {

        AGREGAR, MODIFICAR, BORRAR, VOLVER;

    }

    public void Iniciar() throws SQLException {

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(ve);
            ve.setVisible(true);
            ve.setLocationRelativeTo(null);
        } catch (UnsupportedLookAndFeelException ex) {
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        }

        ve.jTable1.addMouseListener(this);
        ve.jTable1.setModel(new DefaultTableModel());

        ve.jButton1.setActionCommand("AGREGAR");
        ve.jButton1.addActionListener(this);
        ve.jButton2.setActionCommand("MODIFICAR");
        ve.jButton2.addActionListener(this);
        ve.jButton3.setActionCommand("BORRAR");
        ve.jButton3.addActionListener(this);
        ve.jButton4.setActionCommand("VOLVER");
        ve.jButton4.addActionListener(this);

        ve.jTable1.setModel(me.cogerEmpleadosBBDD());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (accionesEmpleado.valueOf(e.getActionCommand())) {

            case VOLVER:

                ve.setVisible(false);
                new ControladorInicial(vi).Iniciar();

                break;

            case AGREGAR:

                String dni = ve.jFormattedTextField1.getText();
                String nombre = ve.jFormattedTextField2.getText();
                String fecha = ve.jFormattedTextField3.getText();
                String sexo = ve.jFormattedTextField4.getText();
                int cod_sucur = Integer.parseInt(ve.jFormattedTextField5.getText());

                me.nuevoEmpleado(dni, nombre, fecha, sexo, cod_sucur);

                ve.jFormattedTextField1.setText("");
                ve.jFormattedTextField2.setText("");
                ve.jFormattedTextField3.setText("");
                ve.jFormattedTextField4.setText("");
                ve.jFormattedTextField5.setText("");

                try {
                    ve.jTable1.setModel(me.cogerEmpleadosBBDD());
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorSucursal.class.getName()).log(Level.SEVERE, null, ex);

                }
                break;

            case BORRAR:
                
                dni = ve.jFormattedTextField1.getText();

                me.borrarEmpleado(dni);

                ve.jFormattedTextField1.setText("");
                ve.jFormattedTextField2.setText("");
                ve.jFormattedTextField3.setText("");
                ve.jFormattedTextField4.setText("");
                ve.jFormattedTextField5.setText("");

                try {
                    ve.jTable1.setModel(me.cogerEmpleadosBBDD());
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorSucursal.class.getName()).log(Level.SEVERE, null, ex);

                }

                break;

            case MODIFICAR:

                dni = ve.jFormattedTextField1.getText();
                nombre = ve.jFormattedTextField2.getText();
                fecha = ve.jFormattedTextField3.getText();
                sexo = ve.jFormattedTextField4.getText();
                cod_sucur = Integer.parseInt(ve.jFormattedTextField5.getText());

                me.modificarEmpleado(dni, nombre, fecha, sexo, cod_sucur);

                ve.jFormattedTextField1.setText("");
                ve.jFormattedTextField2.setText("");
                ve.jFormattedTextField3.setText("");
                ve.jFormattedTextField4.setText("");
                ve.jFormattedTextField5.setText("");

                try {
                    ve.jTable1.setModel(me.cogerEmpleadosBBDD());
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorSucursal.class.getName()).log(Level.SEVERE, null, ex);

                }

                break;
        }

    }

    private void presionarJTable1(java.awt.event.MouseEvent e) {

        if (e.getButton() == 1)// boton izquierdo
        {
            int fila = this.ve.jTable1.rowAtPoint(e.getPoint());
            if (fila > -1) {

                ve.jFormattedTextField1.setText(String.valueOf(ve.jTable1.getValueAt(fila, 0)));
                ve.jFormattedTextField2.setText(String.valueOf(ve.jTable1.getValueAt(fila, 1)));
                ve.jFormattedTextField3.setText(String.valueOf(ve.jTable1.getValueAt(fila, 2)));
                ve.jFormattedTextField4.setText(String.valueOf(ve.jTable1.getValueAt(fila, 3)));
                ve.jFormattedTextField5.setText(String.valueOf(ve.jTable1.getValueAt(fila, 4)));

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
