/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.anneeikedavid.cupom;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author David Jansen <davidwalterjansen@gmail.com>
 */
@Stateless
public class CupomBean implements CupomBeanLocal {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void salvar(Cupom cupom) {
    }

    @Override
    public void atualizar(Cupom cupom) {
    }

    @Override
    public Cupom buscar(Long id) {
        return null;
    }

    @Override
    public void apagar(Cupom cupom) {
    }
}
