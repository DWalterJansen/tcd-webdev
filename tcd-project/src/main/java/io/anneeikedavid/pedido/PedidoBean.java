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
import javax.persistence.TypedQuery;

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
        entityManager.persist(pedido);
    }

    @Override
    public void atualizar(Pedido pedido) {
        entityManager.merge(pedido);
    }

    @Override
    public Pedido buscar(Long id) {
        Pedido pedido = entityManager.find(Pedido.class, id);
        return pedido;
    }

    @Override
    public void apagar(Pedido pedido) {
        entityManager.remove(pedido);
    }    

    @Override
    public List<Item> buscarItens(Pedido pedido) {
        TypedQuery<Item> query = 
            entityManager.createNamedQuery("ItemFromPedido.findAll", Item.class);
        query.setParameter("id", pedido.getId());
        List<Item> itens = query.getResultList();
        return itens;
    }
}
