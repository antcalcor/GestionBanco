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
import java.util.ArrayList;
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
    public int codigo = -1;

    public ControladorClientePersona(VistaClientePersona vcp) {

        this.vcp = vcp;

    }

    public enum accionesClientePersona {

        AGREGAR, MODIFICAR, BORRAR, VOLVER, DIRECCIONES, AGREGAR_D, MODIFICAR_D, BORRAR_D, VOLVER_D;

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
        vcp.jTable3.addMouseListener(this);
        vcp.jTable3.setModel(new DefaultTableModel());

        vcp.jButton1.setActionCommand("AGREGAR");
        vcp.jButton1.addActionListener(this);
        vcp.jButton2.setActionCommand("MODIFICAR");
        vcp.jButton2.addActionListener(this);
        vcp.jButton3.setActionCommand("BORRAR");
        vcp.jButton3.addActionListener(this);
        vcp.jButton4.setActionCommand("VOLVER");
        vcp.jButton4.addActionListener(this);
        vcp.jButton6.setActionCommand("AGREGAR_D");
        vcp.jButton6.addActionListener(this);
        vcp.jButton7.setActionCommand("MODIFICAR_D");
        vcp.jButton7.addActionListener(this);
        vcp.jButton8.setActionCommand("BORRAR_D");
        vcp.jButton8.addActionListener(this);
        vcp.jButton9.setActionCommand("VOLVER_D");
        vcp.jButton9.addActionListener(this);
        vcp.jButton5.setActionCommand("DIRECCIONES");
        vcp.jButton5.addActionListener(this);

        vcp.jTable1.setModel(mcp.cogerClientesPersonaBBDD());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (accionesClientePersona.valueOf(e.getActionCommand())) {

            case VOLVER:

                vcp.setVisible(false);
                new ControladorInicial(vi).Iniciar();

                break;

            case AGREGAR:

                int cod_cli = Integer.parseInt(vcp.jFormattedTextField1.getText());
                String nom = vcp.jFormattedTextField2.getText();
                String telef1 = vcp.jFormattedTextField12.getText();
                String telef2 = vcp.jFormattedTextField13.getText();
                String telef3 = vcp.jFormattedTextField5.getText();
                String fecha = vcp.jFormattedTextField7.getText();
                String sexo = vcp.jFormattedTextField3.getText();

                mcp.nuevoClientePersona(cod_cli, nom, telef1, telef2, telef3, fecha, sexo);

                vcp.jFormattedTextField1.setText("");
                vcp.jFormattedTextField2.setText("");
                vcp.jFormattedTextField12.setText("");
                vcp.jFormattedTextField13.setText("");
                vcp.jFormattedTextField5.setText("");
                vcp.jFormattedTextField7.setText("");
                vcp.jFormattedTextField3.setText("");

                try {
                    vcp.jTable1.setModel(mcp.cogerClientesPersonaBBDD());
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorSucursal.class.getName()).log(Level.SEVERE, null, ex);

                }

                break;

            case BORRAR:

                cod_cli = Integer.parseInt(vcp.jFormattedTextField1.getText());

                mcp.borrarClientePersona(cod_cli);

                vcp.jFormattedTextField1.setText("");
                vcp.jFormattedTextField2.setText("");
                vcp.jFormattedTextField12.setText("");
                vcp.jFormattedTextField13.setText("");
                vcp.jFormattedTextField5.setText("");
                vcp.jFormattedTextField7.setText("");
                vcp.jFormattedTextField3.setText("");

                try {
                    vcp.jTable1.setModel(mcp.cogerClientesPersonaBBDD());
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorSucursal.class.getName()).log(Level.SEVERE, null, ex);

                }

                break;

            case MODIFICAR:

                cod_cli = Integer.parseInt(vcp.jFormattedTextField1.getText());
                nom = vcp.jFormattedTextField2.getText();
                telef1 = vcp.jFormattedTextField12.getText();
                telef2 = vcp.jFormattedTextField13.getText();
                telef3 = vcp.jFormattedTextField5.getText();
                fecha = vcp.jFormattedTextField7.getText();
                sexo = vcp.jFormattedTextField3.getText();

                mcp.modificarClientePersona(cod_cli, nom, telef1, telef2, telef3, fecha, sexo);

                vcp.jFormattedTextField1.setText("");
                vcp.jFormattedTextField2.setText("");
                vcp.jFormattedTextField12.setText("");
                vcp.jFormattedTextField13.setText("");
                vcp.jFormattedTextField5.setText("");
                vcp.jFormattedTextField7.setText("");
                vcp.jFormattedTextField3.setText("");

                try {
                    vcp.jTable1.setModel(mcp.cogerClientesPersonaBBDD());
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorSucursal.class.getName()).log(Level.SEVERE, null, ex);

                }

                break;

            case DIRECCIONES:

                if (codigo != -1) {
                    vcp.setVisible(false);
                    vcp.jDialog1.setVisible(true);
                    vcp.jDialog1.setLocationRelativeTo(null);

                    try {
                        vcp.jTable3.setModel(mDirec.cogerDireccionesBBDD(codigo, "T_PERSONA"));
                    } catch (SQLException ex) {
                        Logger.getLogger(ControladorClientePersona.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                break;

            case AGREGAR_D:

                String cal = String.valueOf(vcp.jFormattedTextField10.getText());
                String ciudad = String.valueOf(vcp.jFormattedTextField8.getText());
                int cod_post = Integer.parseInt(vcp.jFormattedTextField9.getText());

                mDirec.nuevaDireccionPersona(codigo, cal, ciudad, cod_post);

                vcp.jFormattedTextField10.setText("");
                vcp.jFormattedTextField8.setText("");
                vcp.jFormattedTextField9.setText("");

                try {
                    vcp.jTable3.setModel(mDirec.cogerDireccionesBBDD(codigo, "T_PERSONA"));
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorClientePersona.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;

            case MODIFICAR_D:

                cal = String.valueOf(vcp.jFormattedTextField10.getText());
                ciudad = String.valueOf(vcp.jFormattedTextField8.getText());
                cod_post = Integer.parseInt(vcp.jFormattedTextField9.getText());

                mDirec.modificarDireccionPersona(codigo, cal, ciudad, cod_post);

                vcp.jFormattedTextField10.setText("");
                vcp.jFormattedTextField8.setText("");
                vcp.jFormattedTextField9.setText("");

                try {
                    vcp.jTable3.setModel(mDirec.cogerDireccionesBBDD(codigo, "T_PERSONA"));
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorClientePersona.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;

            case BORRAR_D:

                String calle = String.valueOf(vcp.jFormattedTextField10.getText());
                mDirec.borrarDireccionPersona(codigo, calle);

                vcp.jFormattedTextField10.setText("");
                vcp.jFormattedTextField8.setText("");
                vcp.jFormattedTextField9.setText("");

                try {
                    vcp.jTable3.setModel(mDirec.cogerDireccionesBBDD(codigo, "T_PERSONA"));
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorClientePersona.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;

            case VOLVER_D:

                vcp.jDialog1.setVisible(false);
                vcp.setVisible(true);
                vcp.jTable3.setModel(new DefaultTableModel());

                break;
        }
    }

    private void presionarJTable1(java.awt.event.MouseEvent e) throws SQLException {

        if (e.getButton() == 1)// boton izquierdo
        {
            int fila = this.vcp.jTable1.rowAtPoint(e.getPoint());
            if (fila > -1) {

                codigo = Integer.parseInt(String.valueOf(vcp.jTable1.getValueAt(fila, 0)));
                vcp.jFormattedTextField1.setText(String.valueOf(vcp.jTable1.getValueAt(fila, 0)));
                vcp.jFormattedTextField2.setText(String.valueOf(vcp.jTable1.getValueAt(fila, 1)));
                vcp.jFormattedTextField7.setText(String.valueOf(vcp.jTable1.getValueAt(fila, 2)));
                vcp.jFormattedTextField3.setText(String.valueOf(vcp.jTable1.getValueAt(fila, 3)));

                ArrayList<Integer> prueba = mcp.cogerTelefonosBBDD(codigo, "T_PERSONA");

                vcp.jFormattedTextField12.setText(String.valueOf(prueba.get(0)));
                vcp.jFormattedTextField13.setText(String.valueOf(prueba.get(1)));
                vcp.jFormattedTextField5.setText(String.valueOf(prueba.get(2)));

            }

        }

    }

    private void presionarJTable3(java.awt.event.MouseEvent e) throws SQLException {

        if (e.getButton() == 1)// boton izquierdo
        {
            int fila = this.vcp.jTable3.rowAtPoint(e.getPoint());
            if (fila > -1) {

                vcp.jFormattedTextField10.setText(String.valueOf(vcp.jTable3.getValueAt(fila, 0)));
                vcp.jFormattedTextField9.setText(String.valueOf(vcp.jTable3.getValueAt(fila, 1)));
                vcp.jFormattedTextField8.setText(String.valueOf(vcp.jTable3.getValueAt(fila, 2)));

            }

        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

        try {
            presionarJTable1(e);
            presionarJTable3(e);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorClientePersona.class.getName()).log(Level.SEVERE, null, ex);
        }
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
