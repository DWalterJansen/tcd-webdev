/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.anneeikedavid.usuario;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author David Jansen <davidwalterjansen@gmail.com>
 */
@Stateless
public class UsuarioBean implements UsuarioBeanLocal {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void salvar(Usuario usuario) {
        entityManager.persist(usuario);
    }

    @Override
    public void atualizar(Usuario usuario) {
        entityManager.merge(usuario);
    }
    
    @Override
    public void apagar(Usuario usuario) {
        entityManager.remove(usuario);
    }
    
    @Override
    public Usuario buscar(Long id) {
        Usuario usuario = entityManager.find(Usuario.class, id);
        return usuario;
    }    
}
