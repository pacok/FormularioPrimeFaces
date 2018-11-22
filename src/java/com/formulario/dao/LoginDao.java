package com.formulario.dao;

import com.formulario.model.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDao extends Dao{
    boolean existe=false;
    public boolean comprobarLogin(String login, String password) throws SQLException{
        try{
            this.conectar();
            Statement instruccionSQL = this.getCn().createStatement();
            ResultSet resultadosConsulta = instruccionSQL.executeQuery ("SELECT * FROM usuario WHERE login='"+login+"' AND password='"+ password+"'");
            System.out.println("SELECT * FROM usuario WHERE login='"+login+"' AND password='"+ password+"'");
            System.out.println(resultadosConsulta.first());
            if( resultadosConsulta.first() ) {
                // si es valido el primer reg. hay una fila, tons el usuario y su pw existen
                existe=true;        //usuario validado correctamente
            }else{
                existe=false;  }      //usuario validado incorrectamente
        }catch(Exception e){
            
        }finally{
            this.cerrar();  
        }
        
        return existe;
    }
    
}