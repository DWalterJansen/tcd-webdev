/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.anneeikedavid.categoria;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author David Jansen <davidwalterjansen@gmail.com>
 */
@Stateless
public class CategoriaBean implements CategoriaBeanLocal {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void salvar(Categoria categoria) {
        entityManager.persist(categoria);
    }

    @Override
    public void atualizar(Categoria categoria) {
        entityManager.merge(categoria);
    }

    @Override
    public Categoria buscar(Long id) {
        Categoria categoria = entityManager.find(Categoria.class, id);
        return categoria;
    }

    @Override
    public void apagar(Categoria categoria) {
        entityManager.remove(categoria);
    }
}
