package com.formulario.bean;

import com.formulario.dao.UsuarioDao;
import com.formulario.model.Usuario;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

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
            RequestContext.getCurrentInstance().update("growl");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacion realizada", "Datos Guardados"));
        }catch (Exception e){
            
        }
    }
  
}