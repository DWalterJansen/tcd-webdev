/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.anneeikedavid.pedido;

import io.anneeikedavid.item.Item;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author David Jansen <davidwalterjansen@gmail.com>
 */
@Stateless
public class PedidoBean implements PedidoBeanLocal {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void salvar(Pedido pedido) {
    }

    @Override
    public void atualizar(Pedido pedido) {
    }

    @Override
    public Pedido buscar(Long id) {
        return null;
    }

    @Override
    public void apagar(Pedido pedido) {
    }    

    @Override
    public List<Item> buscarItens(Pedido pedido) {
        return null;
    }
}
