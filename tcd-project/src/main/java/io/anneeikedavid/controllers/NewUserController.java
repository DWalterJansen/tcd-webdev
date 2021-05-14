package io.anneeikedavid.controllers;

import io.anneeikedavid.empresa.Empresa;
import io.anneeikedavid.endereco.Endereco;
import io.anneeikedavid.services.DataServiceBeanLocal;
import io.anneeikedavid.usuario.Usuario;
import java.math.BigDecimal;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@Named
@RequestScoped
public class NewUserController {
    
    @Inject
    DataServiceBeanLocal dataService;
    
    private Usuario usuario;
    private Empresa empresa;
    private Endereco endereco;

    public NewUserController() {
        usuario = new Usuario();
        empresa = new Empresa();
        endereco = new Endereco();
    }

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    //</editor-fold>
    
    public String save() {
        empresa.setEndereco(endereco);
        usuario = dataService.criarUsuario(usuario.getEmail(), usuario.getNome(), usuario.getPassword(), "admin", empresa);
        return "/login.xhtml";
    }
    
}