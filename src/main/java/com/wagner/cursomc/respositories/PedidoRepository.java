package com.wagner.cursomc.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wagner.cursomc.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}
