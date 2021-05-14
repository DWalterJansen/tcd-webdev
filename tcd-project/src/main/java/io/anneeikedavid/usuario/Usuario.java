/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.anneeikedavid.usuario;

import io.anneeikedavid.empresa.Empresa;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 *
 * @author David Jansen <davidwalterjansen@gmail.com>
 */
@NamedQueries({
    @NamedQuery(name = "Usuario.findByEmail", 
            query = "SELECT u FROM Usuario u WHERE u.email = :email"),
})
@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50, unique = true)
    private String email;
    
    @Column(length = 100)
    private String nome;

    
    @Column(name = "senha", nullable = false)
    private String password;
    
    @Column(name = "usuario_grupo", nullable = false)
    private String group;
    
    //empresa
    @OneToOne(mappedBy = "usuario")
    private Empresa empresa;
    
    //<editor-fold defaultstate="collapsed" desc="Constructors">
    public Usuario() {}

    public Usuario(String email, String nome, String password, 
            String group, Empresa empresa) {
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.group = group;
        this.empresa = empresa;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
    //</editor-fold>
}
