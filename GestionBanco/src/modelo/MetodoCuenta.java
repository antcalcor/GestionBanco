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
public class MetodoCuenta extends Conexion {

        public void nuevoEmpleado(String dni, String nombre, String fecha, String sexo, int cod_sucur) {

        try {
            Connection conn = this.getConnection();
            String q = "{call INSERTAR_EMPLEADO ('" + dni + "','" + nombre + "','" + fecha + "','" + sexo + "'," + cod_sucur + ")}";
            CallableStatement storedProc = conn.prepareCall(q);
            storedProc.execute();
            storedProc.close();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Hay valores incorrectos");
        }
    }

    public void modificarEmpleado(String dni, String nombre, String fecha, String sexo, int cod_sucur) {

        try {
            Connection conn = this.getConnection();
            String q = "{call MODIFICAR_EMPLEADO ('" + dni + "','" + nombre + "','" + fecha + "','" + sexo + "'," + cod_sucur + ")}";
            CallableStatement storedProc = conn.prepareCall(q);
            storedProc.execute();
            storedProc.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hay valores incorrectos");
        }
    }

    public void borrarEmpleado(String dni) {

        try {
            Connection conn = this.getConnection();
            String q = "{call BORRAR_EMPLEADO ('" + dni + "')}";
            CallableStatement storedProc = conn.prepareCall(q);
            storedProc.execute();
            storedProc.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hay valores incorrectos");
        }
    }
    
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
        
        return tablemodel;

    }

}
