/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.anneeikedavid.empresa;

import io.anneeikedavid.cupom.Cupom;
import io.anneeikedavid.endereco.Endereco;
import io.anneeikedavid.pedido.Pedido;
import io.anneeikedavid.produto.Produto;
import io.anneeikedavid.usuario.Usuario;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author David Jansen <davidwalterjansen@gmail.com>
 */
@Entity
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column()
    private String cnpj;
    
    
    @Column()
    private String emailCorporativo;
    
    // usuario
    @OneToOne(
        fetch = FetchType.EAGER,
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private Usuario usuario;
    
    //Endereco
    @OneToOne(
        fetch = FetchType.EAGER,
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private Endereco endereco;
    
    //Lista Produto
    @OneToMany(
        mappedBy = "empresa",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Produto> produtos;
    
    //Lista Pedido
    @OneToMany(
        mappedBy = "empresa",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Pedido> pedidos;;
    
    @Column()
    private String pix;
    
    @Column()
    private Integer raioEntrega;
    
    @Column()
    private BigDecimal precoEntregaBase;

    @Column()
    private BigDecimal precoEntregaExtraKm;
    
    @Column()
    private Double tempoMedioEntrega;
    
    // Lista Cupom
    @OneToMany(
        mappedBy = "empresa",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Cupom> cupons;;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmailCorporativo() {
        return emailCorporativo;
    }

    public void setEmailCorporativo(String emailCorporativo) {
        this.emailCorporativo = emailCorporativo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public String getPix() {
        return pix;
    }

    public void setPix(String pix) {
        this.pix = pix;
    }

    public Integer getRaioEntrega() {
        return raioEntrega;
    }

    public void setRaioEntrega(Integer raioEntrega) {
        this.raioEntrega = raioEntrega;
    }

    public BigDecimal getPrecoEntregaBase() {
        return precoEntregaBase;
    }

    public void setPrecoEntregaBase(BigDecimal precoEntregaBase) {
        this.precoEntregaBase = precoEntregaBase;
    }

    public BigDecimal getPrecoEntregaExtraKm() {
        return precoEntregaExtraKm;
    }

    public void setPrecoEntregaExtraKm(BigDecimal precoEntregaExtraKm) {
        this.precoEntregaExtraKm = precoEntregaExtraKm;
    }

    public Double getTempoMedioEntrega() {
        return tempoMedioEntrega;
    }

    public void setTempoMedioEntrega(Double tempoMedioEntrega) {
        this.tempoMedioEntrega = tempoMedioEntrega;
    }

    public List<Cupom> getCupons() {
        return cupons;
    }

    public void setCupons(List<Cupom> cupons) {
        this.cupons = cupons;
    }
}
