package com.formulario.dao;

import com.formulario.model.Usuario;
import java.sql.PreparedStatement;

public class UsuarioDao extends Dao{
    
    public void registrar(Usuario us) throws Exception{
        try{
            this.conectar();
            PreparedStatement st=this.getCn().prepareStatement("INSERT INTO usuario (nombre, apellido, email, login, password, cargo, foto, activo) values(?,?,?,?,?,?,?,?)");
            st.setString(1, us.getNombre());
            st.setString(2, us.getApellido());
            st.setString(3,us.getEmail());
            st.setString(4, us.getLogin());
            st.setString(5, us.getPassword());
            st.setString(6, us.getCargo());
            st.setString(7, us.getFoto());
            st.setBoolean(8, us.isActivo());
            st.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.cerrar();        
    }
        
        
    }
    
    
}