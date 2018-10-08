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
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carde
 */
public class MetodoDireccion extends Conexion {

    public DefaultTableModel cogerDireccionesBBDD(int cod_cliente,String tipo_cliente) throws SQLException {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = this.getConnection();
        String[] columnas = {"Calle", "Codigo Postal", "Ciudad"};
        DefaultTableModel tablemodel = new DefaultTableModel();

        int i = 0;

        String q = "SELECT COUNT(*) c FROM " + tipo_cliente  + " T,TABLE (T.DIREC) TT WHERE T.COD_CLIENTE=" + cod_cliente;
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
