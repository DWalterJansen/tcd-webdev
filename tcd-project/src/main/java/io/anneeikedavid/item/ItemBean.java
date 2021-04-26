/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.anneeikedavid.item;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author David Jansen <davidwalterjansen@gmail.com>
 */
@Stateless
public class ItemBean implements ItemBeanLocal {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void Salvar(Item item) {
    }

    @Override
    public void atualizar(Item item) {
    }
    
    @Override
    public Item buscar(Long id) {
        return null;
    }

    @Override
    public void apagar(Item item) {
    }
    
}
