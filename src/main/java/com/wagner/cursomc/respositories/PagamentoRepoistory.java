package com.wagner.cursomc.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wagner.cursomc.domain.Pagamento;

public interface PagamentoRepoistory extends JpaRepository<Pagamento, Integer> {

}
