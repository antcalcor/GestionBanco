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

                /*int codSuc = Integer.parseInt(vs.jFormattedTextField1.getText());
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
        }*/
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        presionarJTable1(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
