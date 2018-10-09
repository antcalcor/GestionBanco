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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carde
 */
public class MetodoClienteOrg extends Conexion {

    public void nuevoClienteOrg(int cod_cli, String nom, String telef1, String telef2, String telef3, String tipo_org, String repres, int numEmple) {

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
            String q = "{call INSERTAR_ORG (" + cod_cli + ",'" + nom + "'," + telef1 + "," + telef2 + "," + telef3 + ",'" + tipo_org + "','" + repres + "'," + numEmple + ")}";
            CallableStatement storedProc = conn.prepareCall(q);
            storedProc.execute();
            storedProc.close();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Hay valores incorrectos");
        }
    }

    public void modificarClienteOrg(int cod_cli, String nom, String telef1, String telef2, String telef3, String tipo_org, String repres, int numEmple) {

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
            String q = "{call MODIFICAR_ORG (" + cod_cli + ",'" + nom + "'," + telef1 + "," + telef2 + "," + telef3 + ",'" + tipo_org + "','" + repres + "'," + numEmple + ")}";
            CallableStatement storedProc = conn.prepareCall(q);
            storedProc.execute();
            storedProc.close();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Hay valores incorrectos");
        }
    }

    public void borrarClienteOrg(int cod_cliente) {

        try {
            Connection conn = this.getConnection();
            String q = "{call BORRAR_ORG ('" + cod_cliente + "')}";
            CallableStatement storedProc = conn.prepareCall(q);
            storedProc.execute();
            storedProc.close();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Hay valores incorrectos");
        }
    }

    public DefaultTableModel cogerClientesOrgBBDD() throws SQLException {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = this.getConnection();
        String[] columnas = {"Codigo Cliente", "Nombre", "Tipo Organizacion", "Representante", "Numero Empleados"};
        DefaultTableModel tablemodel = new DefaultTableModel();

        int i = 0;

        String q = "SELECT COUNT(*) c FROM T_ORGANIZACION";
        ps = conn.prepareStatement(q);
        rs = ps.executeQuery();
        rs.next();
        int filas = rs.getInt("c");
        rs.close();
        ps.close();

        Object[][] datos = new String[filas][5];

        q = "SELECT COD_CLIENTE,NOMBRE,TIPO_ORG,REPRESENTANTE,NUM_EMPLE FROM T_ORGANIZACION";
        ps = conn.prepareStatement(q);
        rs = ps.executeQuery();

        while (rs.next()) {

            datos[i][0] = rs.getString("COD_CLIENTE");
            datos[i][1] = rs.getString("NOMBRE");
            datos[i][2] = rs.getString("TIPO_ORG");
            datos[i][3] = rs.getString("REPRESENTANTE");
            datos[i][4] = rs.getString("NUM_EMPLE");

            i++;
        }
        tablemodel.setDataVector(datos, columnas);
        rs.close();
        ps.close();

        return tablemodel;

    }

}
