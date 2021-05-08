package io.anneeikedavid.controllers;

import io.anneeikedavid.usuario.Usuario;
import java.util.List;
import java.util.Optional;
import javax.ejb.Local;

@Local
public interface DataServiceBeanLocal {
    
    public User createUser(String empresa, String telefone, String nome, String group, String email, String senha);
    
}