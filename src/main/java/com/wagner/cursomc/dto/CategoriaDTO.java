package com.wagner.cursomc.dto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.wagner.cursomc.domain.Categoria;

public class CategoriaDTO {

    private Integer id;

    @NotBlank(message = "Preenchimento obrigátorio")
    @Length(min = 5, max = 80, message = "O tamnanho deve ser entre 5 e 80 caracteres")
    private String nome;

    public CategoriaDTO() {
    }

    public CategoriaDTO(Categoria categoria) {
        id = categoria.getId();
        nome = categoria.getNome();
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
}
