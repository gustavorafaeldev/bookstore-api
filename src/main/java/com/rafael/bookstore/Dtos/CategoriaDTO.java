package com.rafael.bookstore.Dtos;

import java.io.Serializable;

import com.rafael.bookstore.Dtos.domain.Categoria;

public class CategoriaDTO implements Serializable{


    private Integer id;

    private String nome;

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
