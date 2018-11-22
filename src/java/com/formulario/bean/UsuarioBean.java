package com.formulario.bean;

import com.formulario.dao.UsuarioDao;
import com.formulario.model.Usuario;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped

public class UsuarioBean{
    
    private Usuario usuario= new Usuario();

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void registrar(){
        UsuarioDao dao;
        try{
            dao= new UsuarioDao();
            dao.registrar(usuario);
        }catch (Exception e){
            
        }
    }
    
}