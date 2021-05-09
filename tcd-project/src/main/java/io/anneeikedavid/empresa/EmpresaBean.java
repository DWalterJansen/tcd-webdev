/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.anneeikedavid.empresa;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author David Jansen <davidwalterjansen@gmail.com>
 */
@Stateless
public class EmpresaBean implements EmpresaBeanLocal {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void salvar(Empresa empresa) {
        entityManager.persist(empresa);
    }

    @Override
    public void atualizar(Empresa empresa) {
        entityManager.merge(empresa);
    }

    @Override
    public Empresa buscar(Long id) {
        Empresa empresa = entityManager.find(Empresa.class, id);
        return empresa;
    }

    @Override
    public void apagar(Empresa empresa) {
        entityManager.remove(empresa);
    }  
    
}
