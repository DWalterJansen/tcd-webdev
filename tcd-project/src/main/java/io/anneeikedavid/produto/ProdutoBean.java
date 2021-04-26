/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.anneeikedavid.produto;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author David Jansen <davidwalterjansen@gmail.com>
 */
@Stateless
public class ProdutoBean implements ProdutoBeanLocal {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void salvar(Produto produto) {
    }

    @Override
    public void atualizar(Produto produto) {
    }

    @Override
    public Produto buscar(Long id) {
        return null;
    }

    @Override
    public void apagar(Produto produto) {
    }

    @Override
    public void aumentarQuantidadeEstoque(Produto produto, Integer quantidade) {
    }
    
    @Override
    public Boolean diminuirQuantidadeEstoque(Produto produto, Integer quantidade) {
        return true;
    }
    
    
}
