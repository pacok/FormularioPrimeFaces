package com.formulario.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao{
    private Connection cn;
    private String db = "USUARIOS";
  /** usuario */
  private String user = "root";
  /** contraseña de MySql*/
  private String password = "chile";
  /** Cadena de conexion */
  private String url = "jdbc:mysql://localhost/"+db;
  /** variable para trabajar con la conexion a la base de datos */

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }
    
    public void conectar() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        cn=DriverManager.getConnection( this.url, this.user , this.password ); 
        System.out.println("Connection succeed!");
    }
    
    public void cerrar() throws SQLException{
        if(cn!=null){
            if(cn.isClosed() ==false){
                cn.close();
            }
        }
    }
    
}
