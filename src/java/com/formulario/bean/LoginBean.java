package com.formulario.bean;

import com.formulario.dao.LoginDao;
import com.formulario.dao.UsuarioDao;
import com.formulario.model.Usuario;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

@ManagedBean
@RequestScoped

public class LoginBean{
    
    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

  
    
    public String comprobar(){
        LoginDao dao;
        boolean entra=false;
        try{
            dao= new LoginDao();
            dao.comprobarLogin(login, password);
            if(dao.comprobarLogin(login, password)){
                entra=true;
            }
        }catch (Exception e){
            
        }
        if(entra){
            System.out.println("index.xhtml?faces-redirect=true");
            return "index.xhtml?faces-redirect=true";
        }else{
            RequestContext.getCurrentInstance().update("growl");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error de acceso"));
            return "";
        }
        
    }
    
}