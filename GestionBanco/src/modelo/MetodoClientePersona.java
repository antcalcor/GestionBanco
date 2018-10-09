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
public class MetodoClientePersona extends Conexion {

    public void nuevoClientePersona(int cod_cli, String nom, String telef1, String telef2, String telef3, String fecha, String sexo) {

        if (telef1.equals("")) {
            telef1 = "null";
        }
        if (telef2.equals("")) {
            telef2 = "null";
        }
        if (telef3.equals("")) {
            telef3 = "null";
        }

        try {
            Connection conn = this.getConnection();
            String q = "{call INSERTAR_PERSONA (" + cod_cli + ",'" + nom + "'," + telef1 + "," + telef2 + "," + telef3 + ",'" + fecha + "','" + sexo + "')}";
            CallableStatement storedProc = conn.prepareCall(q);
            storedProc.execute();
            storedProc.close();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Hay valores incorrectos");
        }
    }

    public void modificarClientePersona(int cod_cli, String nom, String telef1, String telef2, String telef3, String fecha, String sexo) {

        if (telef1.equals("")) {
            telef1 = "null";
        }
        if (telef2.equals("")) {
            telef2 = "null";
        }
        if (telef3.equals("")) {
            telef3 = "null";
        }

        try {
            Connection conn = this.getConnection();
            String q = "{call MODIFICAR_PERSONA (" + cod_cli + ",'" + nom + "'," + telef1 + "," + telef2 + "," + telef3 + ",'" + fecha + "','" + sexo + "')}";
            CallableStatement storedProc = conn.prepareCall(q);
            storedProc.execute();
            storedProc.close();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Hay valores incorrectos");
        }
    }

    public void borrarClientePersona(int cod_cliente) {

        try {
            Connection conn = this.getConnection();
            String q = "{call BORRAR_PERSONA ('" + cod_cliente + "')}";
            CallableStatement storedProc = conn.prepareCall(q);
            storedProc.execute();
            storedProc.close();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Hay valores incorrectos");
        }
    }

    public DefaultTableModel cogerClientesPersonaBBDD() throws SQLException {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = this.getConnection();
        String[] columnas = {"Codigo Cliente", "Nombre", "Fecha Nacimiento", "Sexo"};
        DefaultTableModel tablemodel = new DefaultTableModel();

        int i = 0;

        String q = "SELECT COUNT(*) c FROM T_PERSONA";
        ps = conn.prepareStatement(q);
        rs = ps.executeQuery();
        rs.next();
        int filas = rs.getInt("c");
        rs.close();
        ps.close();

        Object[][] datos = new String[filas][4];

        q = "SELECT COD_CLIENTE,NOMBRE,FECHA_NACI,SEXO FROM T_PERSONA";
        ps = conn.prepareStatement(q);
        rs = ps.executeQuery();

        while (rs.next()) {

            datos[i][0] = rs.getString("COD_CLIENTE");
            datos[i][1] = rs.getString("NOMBRE");
            datos[i][2] = rs.getDate("FECHA_NACI").toLocalDate().toString();
            datos[i][3] = rs.getString("SEXO");

            i++;
        }
        tablemodel.setDataVector(datos, columnas);
        rs.close();
        ps.close();

        return tablemodel;

    }

    public ArrayList cogerTelefonosBBDD(int cod_cliente, String tipo_cliente) throws SQLException {

        String q = "SELECT TT.* FROM " + tipo_cliente + " T,TABLE (T.TELEF) TT WHERE T.COD_CLIENTE  = " + cod_cliente;

        ArrayList<Integer> tlf = new ArrayList<Integer>();

        Connection conn = this.getConnection();
        PreparedStatement ps = conn.prepareStatement(q);
        ResultSet rs = ps.executeQuery(q);

        while (rs.next()) {

            tlf.add(rs.getInt(1));

        }

        rs.close();
        ps.close();

        return tlf;

    }

}
