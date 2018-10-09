/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import db.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carde
 */
public class MetodoDireccion extends Conexion {

    public void nuevaDireccionPersona(int cod_cli, String calle, String ciudad, int cod_post) {

        try {
            Connection conn = this.getConnection();
            String q = "{call INSERTAR_DIRECCION_PERSONA (" + cod_cli + ",'" + calle + "','" + ciudad + "'," + cod_post + ")}";
            CallableStatement storedProc = conn.prepareCall(q);
            storedProc.execute();
            storedProc.close();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Hay valores incorrectos");
        }
    }

    public void modificarDireccionPersona(int cod_cli, String cal, String ciudad, int cod_post) {

        try {
            Connection conn = this.getConnection();
            String q = "{call MODIFICAR_DIRECCION_PERSONA (" + cod_cli + ",'" + cal + "','" + ciudad + "'," + cod_post + ")}";
            System.out.println(q);
            CallableStatement storedProc = conn.prepareCall(q);
            storedProc.execute();
            storedProc.close();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Hay valores incorrectos");
        }
    }

    public void borrarDireccionPersona(int cod_cliente, String calle) {

        try {
            Connection conn = this.getConnection();
            String q = "{call BORRAR_DIRECCION_PERSONA (" + cod_cliente + ",'" + calle + "')}";
            CallableStatement storedProc = conn.prepareCall(q);
            storedProc.execute();
            storedProc.close();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Hay valores incorrectos");
        }
    }

    public void nuevaDireccionOrg(int cod_cli, String calle, String ciudad, int cod_post) {

        try {
            Connection conn = this.getConnection();
            String q = "{call INSERTAR_DIRECCION_ORG (" + cod_cli + ",'" + calle + "','" + ciudad + "'," + cod_post + ")}";
            CallableStatement storedProc = conn.prepareCall(q);
            storedProc.execute();
            storedProc.close();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Hay valores incorrectos");
        }
    }

    public void modificarDireccionOrg(int cod_cli, String cal, String ciudad, int cod_post) {

        try {
            Connection conn = this.getConnection();
            String q = "{call MODIFICAR_DIRECCION_ORG (" + cod_cli + ",'" + cal + "','" + ciudad + "'," + cod_post + ")}";
            CallableStatement storedProc = conn.prepareCall(q);
            storedProc.execute();
            storedProc.close();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Hay valores incorrectos");
        }
    }

    public void borrarDireccionOrg(int cod_cliente, String calle) {

        try {
            Connection conn = this.getConnection();
            String q = "{call BORRAR_DIRECCION_ORG (" + cod_cliente + ",'" + calle + "')}";
            CallableStatement storedProc = conn.prepareCall(q);
            storedProc.execute();
            storedProc.close();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Hay valores incorrectos");
        }
    }

    public DefaultTableModel cogerDireccionesBBDD(int cod_cliente, String tipo_cliente) throws SQLException {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = this.getConnection();
        String[] columnas = {"Calle", "Codigo Postal", "Ciudad"};
        DefaultTableModel tablemodel = new DefaultTableModel();

        int i = 0;

        String q = "SELECT COUNT(*) c FROM " + tipo_cliente + " T,TABLE (T.DIREC) TT WHERE T.COD_CLIENTE=" + cod_cliente;
        ps = conn.prepareStatement(q);
        rs = ps.executeQuery();
        rs.next();
        int filas = rs.getInt("c");
        rs.close();
        ps.close();

        Object[][] datos = new String[filas][4];

        q = "SELECT TT.CALLE,TT.COD_POST,TT.CIUDAD FROM " + tipo_cliente + " T,TABLE (T.DIREC) TT WHERE T.COD_CLIENTE = " + cod_cliente;
        ps = conn.prepareStatement(q);
        rs = ps.executeQuery();

        while (rs.next()) {

            datos[i][0] = rs.getString("CALLE");
            datos[i][1] = rs.getString("COD_POST");
            datos[i][2] = rs.getString("CIUDAD");

            i++;
        }
        tablemodel.setDataVector(datos, columnas);
        rs.close();
        ps.close();

        return tablemodel;

    }

}
