/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.anneeikedavid.pedido;

import io.anneeikedavid.empresa.Empresa;
import io.anneeikedavid.item.Item;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author David Jansen <davidwalterjansen@gmail.com>
 */
@NamedQueries({
    @NamedQuery(
        name="ItemFromPedido.findAll",
        query="SELECT i FROM Pedido p JOIN p.itens i WHERE p.id = :id"
    ),
})
@Entity
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column()
    private String status;
    
    @Column()
    private String uuidCliente;
    
    @Column()
    private Date date;
    
    // Lista Itens
    
    @Column()
    private BigDecimal precoEntrega;
    
    @Column()
    private BigDecimal valorTotalItens;
    
    @Column()
    private String formaPagamento;
    
    @Column()
    private String obersvacao;
    
    // empresa
    @ManyToOne(
        fetch = FetchType.LAZY,
        cascade = CascadeType.ALL
    )
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
    
    // List Item
    @OneToMany(
        mappedBy = "pedido",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<Item> itens;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUuidCliente() {
        return uuidCliente;
    }

    public void setUuidCliente(String uuidCliente) {
        this.uuidCliente = uuidCliente;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BigDecimal getPrecoEntrega() {
        return precoEntrega;
    }

    public void setPrecoEntrega(BigDecimal precoEntrega) {
        this.precoEntrega = precoEntrega;
    }

    public BigDecimal getValorTotalItens() {
        return valorTotalItens;
    }

    public void setValorTotalItens(BigDecimal valorTotalItens) {
        this.valorTotalItens = valorTotalItens;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getObersvacao() {
        return obersvacao;
    }

    public void setObersvacao(String obersvacao) {
        this.obersvacao = obersvacao;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
    
    public BigDecimal calcularValorTotal() {
        return null; // TODO: Falta implementar
    }
}
