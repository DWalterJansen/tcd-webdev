package io.anneeikedavid.controllers;

import io.anneeikedavid.services.DataServiceBeanLocal;
import io.anneeikedavid.usuario.Usuario;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@Named
@RequestScoped
public class NewUserController {
    
    @Inject
    DataServiceBeanLocal dataService;
    
    private Usuario user;

    public NewUserController() {
        user = new Usuario();
    }

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    //</editor-fold>
    
    public String save() {
        // user = dataService.criarUsuario(email, nome, telegone, password, group, empresa);

        return "/webapp/login.xhtml";
    }
    
}