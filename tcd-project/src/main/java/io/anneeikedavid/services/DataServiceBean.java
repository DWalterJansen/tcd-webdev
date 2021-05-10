package io.anneeikedavid.services;

import io.anneeikedavid.empresa.Empresa;
import io.anneeikedavid.usuario.Usuario;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

@Stateless
public class DataServiceBean implements DataServiceBeanLocal {

    @PersistenceContext(unitName = "tcdDS")
    EntityManager em;

    @Inject
    Pbkdf2PasswordHash passwordHasher;

    @Override
    public Usuario criarUsuario(String email, String nome, String telegone, String password, String group, Empresa empresa) {
        // @see ApplicationConfig
        Map<String, String> parameters = new HashMap<>();
        parameters.put("Pbkdf2PasswordHash.Iterations", "3071");
        parameters.put("Pbkdf2PasswordHash.Algorithm", "PBKDF2WithHmacSHA512");
        parameters.put("Pbkdf2PasswordHash.SaltSizeBytes", "64");
        passwordHasher.initialize(parameters);
        
        Usuario usuario = new Usuario(
                email,
                nome,
                telegone,
                passwordHasher.generate(password.toCharArray()),
                group,
                empresa
        );
        empresa.setUsuario(usuario);
        em.persist(empresa);
        return usuario;
    }

    @Override
    public Optional<Usuario> getUsuario(String email) {
         return em.createNamedQuery("Usuario.findByEmail", Usuario.class)
                .setParameter("email", email)
                .getResultList()
                .stream()
                .findFirst();
    }

    
}