package com.rafael.bookstore.Dtos;

import java.io.Serializable;

import com.rafael.bookstore.domain.Categoria;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

public class CategoriaDTO implements Serializable{


    private Integer id;

    @NotEmpty(message = "Campo NOME é requerido")
    @Length(min = 3, max = 100, message = "Campo NOME deve ter entre 3 e 100 caracteres")
    private String nome;


    @NotEmpty(message = "Campo DESCRIÇÃO é requerido")
    @Length(min = 3, max = 200, message = "Campo DESCRIÇÃO deve ter entre 3 e 200 caracteres")
    private String descricao;


    public CategoriaDTO() {

    }

    public CategoriaDTO(Categoria obj) {
        super();
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.descricao = obj.getDescricao();
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
}
