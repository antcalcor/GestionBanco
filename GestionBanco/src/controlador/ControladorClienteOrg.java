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
public class ControladorClienteOrg implements ActionListener, MouseListener {

    public VistaClienteOrg vco = new VistaClienteOrg();
    public MetodoClienteOrg mco = new MetodoClienteOrg();
    public VistaInicial vi = new VistaInicial();
    public MetodoClientePersona mcp = new MetodoClientePersona();
    public MetodoDireccion mDirec = new MetodoDireccion();
    public int codigo = -1;

    public ControladorClienteOrg(VistaClienteOrg vco) {

        this.vco = vco;

    }

    public enum accionesClienteOrg {

        AGREGAR, MODIFICAR, BORRAR, VOLVER, DIRECCIONES, AGREGAR_D, MODIFICAR_D, BORRAR_D, VOLVER_D;

    }

    public void Iniciar() throws SQLException {

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(vco);
            vco.setVisible(true);
            vco.setLocationRelativeTo(null);
        } catch (UnsupportedLookAndFeelException ex) {
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        }

        vco.jTable1.addMouseListener(this);
        vco.jTable1.setModel(new DefaultTableModel());
        vco.jTable3.addMouseListener(this);
        vco.jTable3.setModel(new DefaultTableModel());

        vco.jButton1.setActionCommand("AGREGAR");
        vco.jButton1.addActionListener(this);
        vco.jButton2.setActionCommand("MODIFICAR");
        vco.jButton2.addActionListener(this);
        vco.jButton3.setActionCommand("BORRAR");
        vco.jButton3.addActionListener(this);
        vco.jButton4.setActionCommand("VOLVER");
        vco.jButton4.addActionListener(this);
        vco.jButton6.setActionCommand("AGREGAR_D");
        vco.jButton6.addActionListener(this);
        vco.jButton7.setActionCommand("MODIFICAR_D");
        vco.jButton7.addActionListener(this);
        vco.jButton8.setActionCommand("BORRAR_D");
        vco.jButton8.addActionListener(this);
        vco.jButton9.setActionCommand("VOLVER_D");
        vco.jButton9.addActionListener(this);
        vco.jButton5.setActionCommand("DIRECCIONES");
        vco.jButton5.addActionListener(this);

        vco.jTable1.setModel(mco.cogerClientesOrgBBDD());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (accionesClienteOrg.valueOf(e.getActionCommand())) {

            case VOLVER:

                vco.setVisible(false);
                new ControladorInicial(vi).Iniciar();

                break;

            case AGREGAR:

                int cod_cli = Integer.parseInt(vco.jFormattedTextField1.getText());
                String nom = vco.jFormattedTextField2.getText();
                String telef1 = vco.jFormattedTextField12.getText();
                String telef2 = vco.jFormattedTextField13.getText();
                String telef3 = vco.jFormattedTextField5.getText();
                String tipo_org = vco.jFormattedTextField4.getText();
                String repres = vco.jFormattedTextField6.getText();
                int numEmple = Integer.parseInt(vco.jFormattedTextField11.getText());

                mco.nuevoClienteOrg(cod_cli, nom, telef1, telef2, telef3, tipo_org, repres, numEmple);

                vco.jFormattedTextField1.setText("");
                vco.jFormattedTextField2.setText("");
                vco.jFormattedTextField12.setText("");
                vco.jFormattedTextField13.setText("");
                vco.jFormattedTextField5.setText("");
                vco.jFormattedTextField4.setText("");
                vco.jFormattedTextField6.setText("");
                vco.jFormattedTextField11.setText("");

                try {
                    vco.jTable1.setModel(mco.cogerClientesOrgBBDD());
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorSucursal.class.getName()).log(Level.SEVERE, null, ex);

                }

                break;

            case BORRAR:

                cod_cli = Integer.parseInt(vco.jFormattedTextField1.getText());

                mco.borrarClienteOrg(cod_cli);

                vco.jFormattedTextField1.setText("");
                vco.jFormattedTextField2.setText("");
                vco.jFormattedTextField12.setText("");
                vco.jFormattedTextField13.setText("");
                vco.jFormattedTextField5.setText("");
                vco.jFormattedTextField4.setText("");
                vco.jFormattedTextField6.setText("");
                vco.jFormattedTextField11.setText("");

                try {
                    vco.jTable1.setModel(mco.cogerClientesOrgBBDD());
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorSucursal.class.getName()).log(Level.SEVERE, null, ex);

                }

                break;

            case MODIFICAR:

                cod_cli = Integer.parseInt(vco.jFormattedTextField1.getText());
                nom = vco.jFormattedTextField2.getText();
                telef1 = vco.jFormattedTextField12.getText();
                telef2 = vco.jFormattedTextField13.getText();
                telef3 = vco.jFormattedTextField5.getText();
                tipo_org = vco.jFormattedTextField4.getText();
                repres = vco.jFormattedTextField6.getText();
                numEmple = Integer.parseInt(vco.jFormattedTextField11.getText());

                mco.modificarClienteOrg(cod_cli, nom, telef1, telef2, telef3, tipo_org, repres, numEmple);

                vco.jFormattedTextField1.setText("");
                vco.jFormattedTextField2.setText("");
                vco.jFormattedTextField12.setText("");
                vco.jFormattedTextField13.setText("");
                vco.jFormattedTextField5.setText("");
                vco.jFormattedTextField4.setText("");
                vco.jFormattedTextField6.setText("");
                vco.jFormattedTextField11.setText("");

                try {
                    vco.jTable1.setModel(mco.cogerClientesOrgBBDD());
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorSucursal.class.getName()).log(Level.SEVERE, null, ex);

                }

                break;

            case DIRECCIONES:

                if (codigo != -1) {
                    vco.setVisible(false);
                    vco.jDialog1.setVisible(true);
                    vco.jDialog1.setLocationRelativeTo(null);

                    try {
                        vco.jTable3.setModel(mDirec.cogerDireccionesBBDD(codigo, "T_ORGANIZACION"));
                    } catch (SQLException ex) {
                        Logger.getLogger(ControladorClientePersona.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                break;

            case AGREGAR_D:

                String cal = String.valueOf(vco.jFormattedTextField10.getText());
                String ciudad = String.valueOf(vco.jFormattedTextField8.getText());
                int cod_post = Integer.parseInt(vco.jFormattedTextField9.getText());

                mDirec.nuevaDireccionOrg(codigo, cal, ciudad, cod_post);

                vco.jFormattedTextField10.setText("");
                vco.jFormattedTextField8.setText("");
                vco.jFormattedTextField9.setText("");

                try {
                    vco.jTable3.setModel(mDirec.cogerDireccionesBBDD(codigo, "T_ORGANIZACION"));
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorClientePersona.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;

            case MODIFICAR_D:

                cal = String.valueOf(vco.jFormattedTextField10.getText());
                ciudad = String.valueOf(vco.jFormattedTextField8.getText());
                cod_post = Integer.parseInt(vco.jFormattedTextField9.getText());

                mDirec.modificarDireccionOrg(codigo, cal, ciudad, cod_post);

                vco.jFormattedTextField10.setText("");
                vco.jFormattedTextField8.setText("");
                vco.jFormattedTextField9.setText("");

                try {
                    vco.jTable3.setModel(mDirec.cogerDireccionesBBDD(codigo, "T_ORGANIZACION"));
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorClientePersona.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;

            case BORRAR_D:

                String calle = String.valueOf(vco.jFormattedTextField10.getText());
                mDirec.borrarDireccionOrg(codigo, calle);

                vco.jFormattedTextField10.setText("");
                vco.jFormattedTextField8.setText("");
                vco.jFormattedTextField9.setText("");

                try {
                    vco.jTable3.setModel(mDirec.cogerDireccionesBBDD(codigo, "T_ORGANIZACION"));
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorClientePersona.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;

            case VOLVER_D:

                vco.jDialog1.setVisible(false);
                vco.setVisible(true);
                vco.jTable3.setModel(new DefaultTableModel());

                break;
        }
    }

    private void presionarJTable1(java.awt.event.MouseEvent e) throws SQLException {

        if (e.getButton() == 1)// boton izquierdo
        {
            int fila = this.vco.jTable1.rowAtPoint(e.getPoint());
            if (fila > -1) {

                codigo = Integer.parseInt(String.valueOf(vco.jTable1.getValueAt(fila, 0)));
                vco.jFormattedTextField1.setText(String.valueOf(vco.jTable1.getValueAt(fila, 0)));
                vco.jFormattedTextField2.setText(String.valueOf(vco.jTable1.getValueAt(fila, 1)));
                vco.jFormattedTextField4.setText(String.valueOf(vco.jTable1.getValueAt(fila, 2)));
                vco.jFormattedTextField6.setText(String.valueOf(vco.jTable1.getValueAt(fila, 3)));
                vco.jFormattedTextField11.setText(String.valueOf(vco.jTable1.getValueAt(fila, 4)));

                ArrayList<Integer> prueba = mcp.cogerTelefonosBBDD(codigo, "T_ORGANIZACION");

                vco.jFormattedTextField12.setText(String.valueOf(prueba.get(0)));
                vco.jFormattedTextField13.setText(String.valueOf(prueba.get(1)));
                vco.jFormattedTextField5.setText(String.valueOf(prueba.get(2)));

            }

        }

    }

    private void presionarJTable3(java.awt.event.MouseEvent e) throws SQLException {

        if (e.getButton() == 1)// boton izquierdo
        {
            int fila = this.vco.jTable3.rowAtPoint(e.getPoint());
            if (fila > -1) {

                vco.jFormattedTextField10.setText(String.valueOf(vco.jTable3.getValueAt(fila, 0)));
                vco.jFormattedTextField9.setText(String.valueOf(vco.jTable3.getValueAt(fila, 1)));
                vco.jFormattedTextField8.setText(String.valueOf(vco.jTable3.getValueAt(fila, 2)));

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
            Logger.getLogger(ControladorClienteOrg.class.getName()).log(Level.SEVERE, null, ex);
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
