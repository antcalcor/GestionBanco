/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author carde
 */
public class Conexion {
            
              /* DATOS PARA LA CONEXION */
  private String login = "BANCO";
  private String password = "BANCO";
  private String url = "jdbc:oracle:thin:@localhost:1521:xe";
  private Connection conn = null;
//___________________________________________________________________________________ 
   public Conexion(){
      try{
         //obtenemos el driver de para mysql
         Class.forName("oracle.jdbc.driver.OracleDriver");
         //com.mysql.cj.jdbc.Driver
         //obtenemos la conexión
         conn = DriverManager.getConnection(url,login,password);
         if (conn!=null){
            System.out.println("OK base de datos lista");
         }
      }catch(SQLException e){
         System.out.println(e);
      }catch(ClassNotFoundException e){
         System.out.println(e);
      }
    }
//___________________________________________________________________________________ 
    public Connection getConnection()
    {
        return this.conn;
    }
    
}
