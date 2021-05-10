/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.anneeikedavid.produto;

import javax.ejb.Local;

/**
 *
 * @author David Jansen <davidwalterjansen@gmail.com>
 */
@Local
public interface ProdutoBeanLocal {

    void salvar(Produto produto);

    void atualizar(Produto produto);

    Produto buscar(Long id);

    void apagar(Produto produto);

    void aumentarQuantidadeEstoque(Produto produto, Integer quantidade);
    
    Boolean diminuirQuantidadeEstoque(Produto produto, Integer quantidade);
    
}
