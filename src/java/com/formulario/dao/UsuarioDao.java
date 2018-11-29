package com.formulario.dao;

import com.formulario.model.Usuario;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

public class UsuarioDao extends Dao{
    
    public static Blob convertirImagenABlob ( Usuario us ) throws SQLException {
      Blob imagenBlob = null; 
      byte [] imagenByte = us.getFoto();
      try {
         imagenBlob = new SerialBlob ( imagenByte );
      } catch ( SerialException se ) {
         se.printStackTrace ();
      } catch ( SQLException sqle ) {
         sqle.printStackTrace ();
      }
      return imagenBlob;
   }
    
    public void registrar(Usuario us) throws Exception{
        System.out.println("UsuarioDao.registrar()");
        System.out.println(us.getFoto());
        try{
            this.conectar();
            PreparedStatement st=this.getCn().prepareStatement("INSERT INTO usuario (nombre, apellido, email, login, password, cargo, foto, activo) values(?,?,?,?,?,?,?,?)");
            st.setString(1, us.getNombre());
            st.setString(2, us.getApellido());
            st.setString(3, us.getEmail());
            st.setString(4, us.getLogin());
            st.setString(5, us.getPassword());
            st.setString(6, us.getCargo());
            st.setBlob(7, convertirImagenABlob(us));
            st.setBoolean(8, us.isActivo());
            st.executeUpdate();
            System.out.println(st);
        }catch(Exception e){
            throw e;
        }finally{
            this.cerrar();        
    }
        
        
    }
    
    
}