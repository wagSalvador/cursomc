package com.wagner.cursomc.domain;

import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable//É pra dizer que é um subtipo
public class ItemPedidoPK {

    @ManyToOne
    @JoinColumn(name = "pedido")
    private Pedido pedido;


    @ManyToOne
    @JoinColumn(name = "produto")
    private  Produto produto;

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemPedidoPK that = (ItemPedidoPK) o;
        return Objects.equals(pedido, that.pedido) && Objects.equals(produto, that.produto);
    }

    @Override
    public int hashCode() {

        return Objects.hash(pedido, produto);
    }
}