package com.rafael.bookstore.Dtos;

import com.rafael.bookstore.domain.Livro;

import java.io.Serializable;

public class LivroDTO implements Serializable {

    private Integer id;
    private String titulo;

    public LivroDTO(Livro obj) {
        super();
        this.id = obj.getId();
        this.titulo = obj.getTitulo();
    }

    public LivroDTO() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
