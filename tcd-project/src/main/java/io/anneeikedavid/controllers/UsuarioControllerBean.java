/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.anneeikedavid.controllers;

import io.anneeikedavid.empresa.EmpresaBeanLocal;
import io.anneeikedavid.usuario.Usuario;
import io.anneeikedavid.usuario.UsuarioBeanLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.inject.Inject;

/**
 *
 * @author David Jansen <davidwalterjansen@gmail.com>
 */
@Named(value = "usuarioControllerBean")
@SessionScoped
public class UsuarioControllerBean implements Serializable {

    private Usuario usuario;
    private Boolean isLogado;
    
    @Inject
    UsuarioBeanLocal usuarioBeanLocal;
    
    @Inject
    EmpresaBeanLocal empresaBeanLocal;
    /**
     * Creates a new instance of UsuarioControllerBean
     */
    public UsuarioControllerBean() {
    }
    
    public Boolean login(String email, String senha) {
        return true; // TODO: Falta implementar
    }
    
    public Boolean logout(){
        return true; // TODO: Falta implementar
    }
    
    public Boolean realizarCadastro(Usuario usuario) {
        return true; // TODO: Falta implementar
    }
    
    public Boolean atualizarCadastro(Usuario usuario) {
        return true; // TODO: Falta implementar
    }
    
}
