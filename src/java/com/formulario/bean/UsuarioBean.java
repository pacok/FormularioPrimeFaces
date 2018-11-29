package com.formulario.bean;

import com.formulario.dao.UsuarioDao;
import com.formulario.model.Usuario;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@ManagedBean
@RequestScoped

public class UsuarioBean{
    
    private Usuario usuario= new Usuario();
    
    private UploadedFile uploadedFile;

    public UploadedFile getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

    public void upload() throws IOException {
        System.out.println("Upload");
        String fileName = uploadedFile.getFileName();
        System.out.println(fileName);
        String contentType = uploadedFile.getContentType();
        
        //InputStream initialStream = new ByteArrayInputStream(new byte[] { 0, 1, 2 });
        InputStream initialStream=uploadedFile.getInputstream();
        byte[] targetArray = new byte[initialStream.available()];
        initialStream.read(targetArray);
        
        
        
        
        System.out.println(contentType);
        //byte[] contents = uploadedFile.getContents(); // Or getInputStream()
    // ... Save it, now!
    
    this.usuario.setFoto(targetArray);
    System.out.println(targetArray);
    registrar();
}

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
//    public void handleFileUpload(FileUploadEvent event) throws IOException {
//         byte[] content = event.getFile().getContents();
//         this.usuario.setFoto(content);
//         System.out.println("com.formulario.bean.UsuarioBean.handleFileUpload()");
//    }
    
    public void registrar(){
        System.out.println("estoy en registrar()");
        UsuarioDao dao;
        try{
            System.out.println(usuario.getApellido()+usuario.getFoto());
            
            dao= new UsuarioDao();
            dao.registrar(usuario);
            
            RequestContext.getCurrentInstance().update("growl");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Operacion realizada", "Datos Guardados"));
        }catch (Exception e){
            
        }
        
    }
  
}