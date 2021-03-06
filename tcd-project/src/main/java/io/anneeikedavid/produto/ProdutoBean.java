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
        entityManager.persist(produto);
    }

    @Override
    public void atualizar(Produto produto) {
        entityManager.merge(produto);
    }

    @Override
    public Produto buscar(Long id) {
        Produto produto = entityManager.find(Produto.class, id);
        return produto;
    }

    @Override
    public void apagar(Produto produto) {
        entityManager.remove(produto);
    }

    @Override
    public void aumentarQuantidadeEstoque(Produto produto, Integer quantidade) {
        Integer novaQuantidade = produto.getQuantidadeEstoque() + quantidade;
        produto.setQuantidadeEstoque(novaQuantidade);
        entityManager.merge(produto);
    }
    
    @Override
    public Boolean diminuirQuantidadeEstoque(Produto produto, Integer quantidade) {
        Integer novaQuantidade = produto.getQuantidadeEstoque() - quantidade;
        if (novaQuantidade < 0) {
            return false;
        }
        else {
            produto.setQuantidadeEstoque(novaQuantidade);
            entityManager.merge(produto);
            return true;
        }
    }
}
