/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.anneeikedavid.controllers;

import io.anneeikedavid.item.ItemBeanLocal;
import io.anneeikedavid.pedido.Pedido;
import io.anneeikedavid.pedido.PedidoBeanLocal;
import io.anneeikedavid.produto.ProdutoBeanLocal;
import java.math.BigDecimal;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author David Jansen <davidwalterjansen@gmail.com>
 */
@Named(value = "pedidoControllerBean")
@RequestScoped
public class PedidoControllerBean {
    
    @Inject
    PedidoBeanLocal pedidoBeanLocal;
    
    @Inject
    ProdutoBeanLocal produtoBeanLocal;
    
    @Inject
    ItemBeanLocal itemBeanLocal;
    
    /**
     * Creates a new instance of PedidoControllerBean
     */
    public PedidoControllerBean() {
    }
    
    public Boolean registrarPedido(Pedido pedido) {
        return true; // Falta implementar
    }
    
    public Boolean alterarStatusPedido(Pedido pedido, String novoStatus) {
        return true; // Falta implementar
    }
    
    public BigDecimal calcularPrecoPedido(Pedido pedido) {
        return null; // TODO: Falta implementar
    }
}
