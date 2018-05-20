package com.wagner.cursomc.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToMany
    //Anotação que define quem vai fazer o muito para muito no banco
    @JoinTable(name= "PRODUTO_CATEGORIA",//Nome da tabela nome da tabela associativa
            joinColumns = @JoinColumn(name="produto"),//Chave estrangeira correspondente ao Produto
            inverseJoinColumns = @JoinColumn(name ="categoria"))//chave estrangeira da categoria
    @JsonBackReference//Anotação que diz que já foram buscados os produtos pela outra assciação
    private List<Categoria> categorias = new ArrayList<>();
    private String nome;
    private Double preco;

    public Produto() {
    }

    public Produto(Integer id, String nome, Double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
