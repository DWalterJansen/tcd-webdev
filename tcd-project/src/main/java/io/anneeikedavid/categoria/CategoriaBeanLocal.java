/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.anneeikedavid.categoria;

import javax.ejb.Local;

/**
 *
 * @author David Jansen <davidwalterjansen@gmail.com>
 */
@Local
public interface CategoriaBeanLocal {

    void salvar(Categoria categoria);

    void atualizar(Categoria categoria);

    Categoria buscar(Long id);

    void apagar(Categoria categoria);
    
}
