/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.anneeikedavid.controllers;

import io.anneeikedavid.empresa.Empresa;
import io.anneeikedavid.empresa.EmpresaBeanLocal;
import io.anneeikedavid.services.DataServiceBeanLocal;
import io.anneeikedavid.usuario.Usuario;
import io.anneeikedavid.usuario.UsuarioBeanLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Optional;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.security.enterprise.SecurityContext;
import javax.servlet.ServletException;

/**
 *
 * @author David Jansen <davidwalterjansen@gmail.com>
 */
@Named(value = "usuarioControllerBean")
@SessionScoped
public class UsuarioControllerBean implements Serializable {
    
    @Inject
    DataServiceBeanLocal dataService;

    @Inject
    SecurityContext securityContext;

    @Inject
    FacesContext facesContext;
    
    @Inject
    UsuarioBeanLocal usuarioBeanLocal;
    
    @Inject
    EmpresaBeanLocal empresaBeanLocal;
    
    private Optional<Usuario> usuario;
    private Empresa empresa;
    
    
    @PostConstruct
    public void initialize() {
        String email = securityContext.getCallerPrincipal().getName();
        this.usuario = dataService.getUsuario(email);
        this.usuario.ifPresent(user -> {
            this.empresa = usuario.get().getEmpresa();
        });
    }
    
    public UsuarioControllerBean() {
    }
    
    public Usuario getCurrentUser() {
        return usuario.orElse(null);
    }

    public boolean isAuthenticated() {
        return securityContext.getCallerPrincipal() != null;
    }

    public boolean isAdmin() {
        return securityContext.isCallerInRole("admin");
    }

    public String logout() throws ServletException {
        facesContext.getExternalContext()
                .invalidateSession();
        return "/login?faces-redirect=true";
    }
    
}
