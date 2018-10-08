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
public class MetodoDireccion extends Conexion{
    
    public DefaultTableModel cogerDireccionesBBDD(String tipo_cliente) throws SQLException{
        
                PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = this.getConnection();
        String[] columnas = {"Codigo Sucursal","Calle","Codigo Postal","Ciudad"};
        DefaultTableModel tablemodel = new DefaultTableModel();
        
        int i = 0;
        
        String q = "SELECT COUNT(*) c FROM T_SUCURSAL";
        ps = conn.prepareStatement(q);
        rs = ps.executeQuery();
        rs.next();
        int filas = rs.getInt(1);
        rs.close();
        ps.close();
        
        Object[][] datos = new String[filas][4];
        
        q = "SELECT COD_SUCUR,(DIREC).CALLE CALLE,(DIREC).COD_POST COD_POST,(DIREC).CIUDAD CIUDAD FROM T_SUCURSAL";
        ps = conn.prepareStatement(q);
        rs = ps.executeQuery();
        
        while (rs.next()){
            
            datos[i][0] = rs.getString("COD_SUCUR");
            datos[i][1] = rs.getString("CALLE");
            datos[i][2] = rs.getString("COD_POST");
            datos[i][3] = rs.getString("CIUDAD");
            
            i++;
        }
        tablemodel.setDataVector(datos, columnas);
        rs.close();
        ps.close();
        conn.close();
        return tablemodel;
        
    }
    
}
