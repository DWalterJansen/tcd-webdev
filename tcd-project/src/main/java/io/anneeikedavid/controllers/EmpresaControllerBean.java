/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.anneeikedavid.controllers;

import io.anneeikedavid.categoria.CategoriaBeanLocal;
import io.anneeikedavid.cupom.CupomBeanLocal;
import io.anneeikedavid.empresa.Empresa;
import io.anneeikedavid.empresa.EmpresaBeanLocal;
import io.anneeikedavid.endereco.EnderecoBeanLocal;
import io.anneeikedavid.produto.ProdutoBeanLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.inject.Inject;

/**
 *
 * @author David Jansen <davidwalterjansen@gmail.com>
 */
@Named(value = "empresaControllerBean")
@SessionScoped
public class EmpresaControllerBean implements Serializable {
    
    private Empresa empresa;
    
    @Inject
    EmpresaBeanLocal empresaBeanLocal;
    
    @Inject
    EnderecoBeanLocal enderecoBeanLocal;
    
    @Inject
    ProdutoBeanLocal produtoBeanLocal;
    
    @Inject
    CategoriaBeanLocal categoriaBeanLocal;
    
    @Inject
    CupomBeanLocal cupomBeanLocal;

    /**
     * Creates a new instance of EmpresaControllerBean
     */
    public EmpresaControllerBean() {
    }
    
        public Boolean cadastrarEmpresa(Empresa empresa) {
        return true; // TODO: Falta implementar
    }
    
    public Boolean atualizarCadastroEmpresa(Empresa empresa) {
        return true; // TODO: Falta implementar
    }
    
    public BigDecimal calcularPrecoEntrega(Integer distanciaMetros) {
        return null; // TODO: Falta implementar
    }
    
}
