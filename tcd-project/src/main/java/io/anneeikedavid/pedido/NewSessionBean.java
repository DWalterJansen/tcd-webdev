/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.anneeikedavid.pedido;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author David Jansen <davidwalterjansen@gmail.com>
 */
@Stateless
public class NewSessionBean implements NewSessionBeanLocal {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void salvar(Pedido pedido) {
    }
}
