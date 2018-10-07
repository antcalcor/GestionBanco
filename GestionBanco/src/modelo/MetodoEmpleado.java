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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author carde
 */
public class MetodoEmpleado extends Conexion {

    public DefaultTableModel cogerEmpleadosBBDD() throws SQLException{
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = this.getConnection();
        String[] columnas = {"DNI", "Nombre", "Fecha Nacimiento", "Sexo","Codigo Sucursal"};
        DefaultTableModel tablemodel = new DefaultTableModel();

        int i = 0;

        String q = "SELECT COUNT(*) c FROM T_EMPLEADO";
        ps = conn.prepareStatement(q);
        rs = ps.executeQuery();
        rs.next();
        int filas = rs.getInt(1);
        rs.close();
        ps.close();

        Object[][] datos = new String[filas][5];

        q = "SELECT DNI,NOMBRE,FECHA_NAC,SEXO,(SUCUR).COD_SUCUR COD_SUCUR FROM T_EMPLEADO";
        ps = conn.prepareStatement(q);
        rs = ps.executeQuery();

        while (rs.next()) {

            datos[i][0] = rs.getString("DNI");
            datos[i][1] = rs.getString("NOMBRE");
            datos[i][2] = rs.getString("FECHA_NAC");
            datos[i][3] = rs.getString("SEXO");
            datos[i][4] = rs.getString("COD_SUCUR");

            i++;
        }
        tablemodel.setDataVector(datos, columnas);
        rs.close();
        ps.close();
        conn.close();
        return tablemodel;

    }

}
