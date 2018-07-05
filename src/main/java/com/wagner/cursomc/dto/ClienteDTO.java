package com.wagner.cursomc.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.wagner.cursomc.domain.Cliente;

public class ClienteDTO {

    private Integer id;

    @NotEmpty(message = "Preenchimento Obrigatório")
    @Length(min = 5)
    private String nome;

    @NotEmpty
    @Email(message = "Email invalido")
    private String email;

    public ClienteDTO() {
    }

    public ClienteDTO(Cliente cliente) {
        id = cliente.getId();
        nome = cliente.getNome();
        email = cliente.getEmail();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
