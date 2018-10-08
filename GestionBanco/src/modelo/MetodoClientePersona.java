/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import db.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carde
 */
public class MetodoClientePersona extends Conexion{

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
            datos[i][2] = rs.getString("FECHA_NACI");
            datos[i][3] = rs.getString("SEXO");

            i++;
        }
        tablemodel.setDataVector(datos, columnas);
        rs.close();
        ps.close();
        conn.close();
        return tablemodel;

    }

}
