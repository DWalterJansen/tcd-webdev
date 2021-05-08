package io.anneeikedavid;

import io.anneeikedavid.usuario;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

@Stateless
public class DataServiceBean
        implements DataServiceBeanLocal {

    @PersistenceContext(unitName = "secureApp")
    EntityManager em;

    @Inject
    Pbkdf2PasswordHash passwordHasher;

    @Override
    public Usuario createUser(String empresa, String telefone, String nome, String group, String email, String senha) {

        // @see ApplicationConfig
        Map<String, String> parameters = new HashMap<>();
        parameters.put("Pbkdf2PasswordHash.Iterations", "3071");
        parameters.put("Pbkdf2PasswordHash.Algorithm", "PBKDF2WithHmacSHA512");
        parameters.put("Pbkdf2PasswordHash.SaltSizeBytes", "64");
        passwordHasher.initialize(parameters);

        Usuario newUser = new Usuario(
                empresa,
                telefone,
                nome,
                group,
                email,
                passwordHasher.generate(
                        password.toCharArray()),
                group);
        em.persist(newUser);
//        em.flush();
        return newUser;
    }
}