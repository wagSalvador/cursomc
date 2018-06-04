package com.wagner.cursomc;

import com.wagner.cursomc.domain.*;
import com.wagner.cursomc.enums.EstadoPagamento;
import com.wagner.cursomc.enums.TipoCliente;
import com.wagner.cursomc.respositories.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private PagamentoRepoistory pagamentoRepoistory;

    public static void main(String[] args) {
        SpringApplication.run(CursomcApplication.class, args);
    }

    /**
     * Método para popular a base com dados ao ser iniciado o sistema.
     *
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        Categoria categoria1 = new Categoria(null, "Informática");
        Categoria categoria2 = new Categoria(null, "Escritório");

        Produto produto1 = new Produto(null, "Computador", 2000.00);
        Produto produto2 = new Produto(null, "Impressora", 800.00);
        Produto produto3 = new Produto(null, "Mouse", 80.00);

        categoria1.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3));
        categoria2.getProdutos().addAll(Arrays.asList(produto2));

        produto1.getCategorias().addAll(Arrays.asList(categoria1));
        produto2.getCategorias().addAll(Arrays.asList(categoria1, categoria2));
        produto3.getCategorias().addAll(Arrays.asList(categoria1));

        categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));
        produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3));

        Estado estado1 = new Estado(null, "São Paulo");
        Estado estado2 = new Estado(null, "Minas Gerais");

        Cidade cidade1 = new Cidade(null, "Uberlândia", estado2);
        Cidade cidade2 = new Cidade(null, "São Paulo", estado1);
        Cidade cidade3 = new Cidade(null, "Campinas", estado1);

        estado1.getCidades().addAll(Arrays.asList(cidade2, cidade3));
        estado2.getCidades().addAll(Arrays.asList(cidade1));

        estadoRepository.saveAll(Arrays.asList(estado1, estado2));
        cidadeRepository.saveAll(Arrays.asList(cidade1, cidade2, cidade3));

        Cliente cliente = new Cliente(null, "Marina Silva", "marina@gmail.com", "123456789", TipoCliente.PESSOA_FISICA);

        Endereco endereco1 = new Endereco(null, "Rua Flores", "300", "Apto 203", "Jardim", "8913000", cliente, cidade1);
        Endereco endereco2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "8913000", cliente, cidade2);

        cliente.getEnderecos().addAll(Arrays.asList(endereco1, endereco2));
        cliente.getTelefones().addAll(Arrays.asList("3333333", "9999999"));

        clienteRepository.saveAll(Arrays.asList(cliente));
        enderecoRepository.saveAll(Arrays.asList(endereco1, endereco2));

        Pedido pedido1 = new Pedido(null, LocalDate.of(2017, 9, 30), cliente, endereco1);
        Pedido pedido2 = new Pedido(null, LocalDate.of(2017, 10, 10), cliente, endereco2);

        Pagamento pagamentoComCartao = new PagamentoComCartao(null, EstadoPagamento.QUITADO, pedido1, 6);
        pedido1.setPagamento(pagamentoComCartao);

        Pagamento pagamentoComBoleto = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, pedido2, LocalDate.of(2017, Month.OCTOBER, 20), null);
        pedido2.setPagamento(pagamentoComBoleto);

        cliente.getPedidos().addAll(Arrays.asList(pedido1, pedido2));

        pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2));
        pagamentoRepoistory.saveAll(Arrays.asList(pagamentoComBoleto, pagamentoComCartao));

    }
}
