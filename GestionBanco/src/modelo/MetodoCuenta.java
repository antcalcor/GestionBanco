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
public class MetodoCuenta extends Conexion {

    public DefaultTableModel cogerCuentasBBDD() throws SQLException {

        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = this.getConnection();
        String[] columnas = {"Cod Cuenta", "Cod Sucursal", "Cod Banco", "Saldo Actual","Saldo Medio","Tipo Amortizacion","Cod Cliente"};
        DefaultTableModel tablemodel = new DefaultTableModel();

        int i = 0;

        String q = "SELECT COUNT(COD_CUENTA) c FROM T_CUENTA";
        ps = conn.prepareStatement(q);
        rs = ps.executeQuery();
        rs.next();
        int filas = rs.getInt(1);
        rs.close();
        ps.close();

        Object[][] datos = new String[filas][7];

        q = "SELECT COD_CUENTA,(COD_SUCUR).COD_SUCUR COD_SUCUR, COD_BANCO,SALDO_ACT,SALDO_MEDIO, TIPO_AMORT,(COD_CLIENTE).COD_CLIENTE COD_CLIENTE FROM T_CUENTA";
        ps = conn.prepareStatement(q);
        rs = ps.executeQuery();

        while (rs.next()) {

            datos[i][0] = rs.getString("COD_CUENTA");
            datos[i][1] = rs.getString("COD_SUCUR");
            datos[i][2] = rs.getString("COD_BANCO");
            datos[i][3] = rs.getString("SALDO_ACT");
            datos[i][4] = rs.getString("SALDO_MEDIO");
            datos[i][5] = rs.getString("TIPO_AMORT");
            datos[i][6] = rs.getString("COD_CLIENTE");

            i++;
        }
        tablemodel.setDataVector(datos, columnas);
        rs.close();
        ps.close();
        conn.close();
        return tablemodel;

    }

}
