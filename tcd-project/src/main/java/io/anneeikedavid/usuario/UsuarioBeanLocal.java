/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.anneeikedavid.usuario;

import javax.ejb.Local;

/**
 *
 * @author David Jansen <davidwalterjansen@gmail.com>
 */
@Local
public interface UsuarioBeanLocal {

    void salvar(Usuario usuario);

    void atualizar(Usuario usuario);
    
    void apagar(Usuario usuario);

    Usuario buscar(Long id);
}
