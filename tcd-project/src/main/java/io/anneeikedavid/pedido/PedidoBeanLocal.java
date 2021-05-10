/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.anneeikedavid.pedido;

import io.anneeikedavid.item.Item;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author David Jansen <davidwalterjansen@gmail.com>
 */
@Local
public interface PedidoBeanLocal {

    void salvar(Pedido pedido);

    void atualizar(Pedido pedido);

    Pedido buscar(Long id);

    void apagar(Pedido pedido);

    List<Item> buscarItens(Pedido pedido);
}
