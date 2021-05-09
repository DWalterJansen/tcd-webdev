package io.anneeikedavid.services;

import io.anneeikedavid.empresa.Empresa;
import io.anneeikedavid.usuario.Usuario;
import java.util.Optional;
import javax.ejb.Local;

@Local
public interface DataServiceBeanLocal {
    
    public Usuario criarUsuario(String email, String nome, String telegone, String password, String group, Empresa empresa);
    
    public Optional<Usuario> getUsuario(String email);
}