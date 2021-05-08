package io.anneeikedavid.controllers;

import io.anneeikedavid.usuario.Usuario;
import io.anneeikedavid.DataServiceBeanLocal;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@Named
@RequestScoped
public class NewUserController {
    
    @Inject
    DataServiceBeanLocal dataService;
    
    private Usuario user;

    /**
     * Creates a new instance of NewUserController
     */
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
        user = dataService.createUser(
                user.GetEmpresa(),
                user.getTelefone(),
                user.getNome(), 
                user.getSenha(), 
                user.getGroup());

        return "/webapp/login.xhtml";
    }
    
}