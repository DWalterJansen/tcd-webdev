package io.anneeikedavid.controllers;

import io.anneeikedavid.empresa.Empresa;
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

    public NewUserController() {
        usuario = new Usuario();
        empresa = new Empresa();
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

    //</editor-fold>
    
    public String save() {
        empresa.setCnpj("000100021000");
        empresa.setPix("000100021000");
        empresa.setRaioEntrega(0);
        empresa.setEmailCorporativo("empresa@email.com");
        empresa.setTempoMedioEntrega(0.0);
        empresa.setPrecoEntregaBase(new BigDecimal(0));
        empresa.setPrecoEntregaExtraKm(new BigDecimal(0));
        usuario = dataService.criarUsuario(usuario.getEmail(), usuario.getNome(), usuario.getTelefone(), usuario.getPassword(), "admin", empresa);
        System.out.println("Chegou aqui");
        return "/webapp/login.xhtml";
    }
    
}