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
import vista.*;

/**
 *
 * @author carde
 */
public class ControladorInicial implements ActionListener, MouseListener {

    public VistaInicial vi = new VistaInicial();
    public VistaCliente vc = new VistaCliente();
    public VistaCuenta vcu = new VistaCuenta();
    public VistaSucursal vs = new VistaSucursal();
    public VistaEmpleado ve = new VistaEmpleado();

    public enum accionesVi {

        CLIENTE, CUENTA, SUCURSAL, EMPLEADO;

    }

    public ControladorInicial(VistaInicial vi) {
        this.vi = vi;
    }

    public void Iniciar() {

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(vi);
            vi.setVisible(true);
            vi.setLocationRelativeTo(null);
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
        }

        vi.jButton1.setActionCommand("CLIENTE");
        vi.jButton1.addActionListener(this);
        vi.jButton2.setActionCommand("CUENTA");
        vi.jButton2.addActionListener(this);
        vi.jButton3.setActionCommand("SUCURSAL");
        vi.jButton3.addActionListener(this);
        vi.jButton4.setActionCommand("EMPLEADO");
        vi.jButton4.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         
        switch(accionesVi.valueOf(e.getActionCommand())){
            
            case CLIENTE:
                
                vi.setVisible(false);
                new ControladorCliente (vc).Iniciar();
                
                break;
                
            case CUENTA:
                
                vi.setVisible(false);
                new ControladorCuenta (vcu).Iniciar();
                
                break;
                
            case SUCURSAL:
                
                vi.setVisible(false);
        {
            try {
                new ControladorSucursal (vs).Iniciar();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorInicial.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                
                break;
            
            case EMPLEADO:
                
                vi.setVisible(false);
        {
            try {
                new ControladorEmpleado (ve).Iniciar();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorInicial.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                
                break;
        }
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
