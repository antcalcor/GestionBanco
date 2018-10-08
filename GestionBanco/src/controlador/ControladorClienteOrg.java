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
    public MetodoDireccion mDirec = new MetodoDireccion();
    
    public ControladorClienteOrg(VistaClienteOrg vco){
        
        this.vco=vco;
        
    }
    
    public enum accionesClienteOrg{
        
        AGREGAR,MODIFICAR,BORRAR,VOLVER,DIRECCIONES;
        
    }
    
    public void Iniciar() throws SQLException{
        
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
        vco.jButton5.setActionCommand("DIRECCIONES");
        vco.jButton5.addActionListener(this);
        
        vco.jTable1.setModel(mco.cogerClientesOrgBBDD());
        vco.jTable3.setModel(mDirec.cogerDireccionesBBDD("DIREC_ORG"));
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
