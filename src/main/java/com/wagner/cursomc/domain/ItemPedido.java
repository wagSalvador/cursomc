package com.wagner.cursomc.domain;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ItemPedidoPK id= new ItemPedidoPK();

    private Integer quantidade;

    private Double desconto;

    private Double preco;

}
