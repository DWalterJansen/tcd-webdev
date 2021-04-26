/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.anneeikedavid.endereco;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author David Jansen <davidwalterjansen@gmail.com>
 */
@Stateless
public class EnderecoBean implements EnderecoBeanLocal {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void salvar(Endereco endereco) {
    }

    @Override
    public void atualizar(Endereco endereco) {
    }

    @Override
    public Endereco buscar(Long id) {
        return null;
    }

    @Override
    public void apagar(Endereco endereco) {
    }
}
