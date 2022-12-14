package com.rafael.bookstore.domain;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

@Entity
public class Livro implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Campo TÍTULO requerido")
    @Length(min = 3, max = 255, message = "Campo TÍTULO deve ter entre 3 e 255 caracteres")
    private String titulo;

    @NotEmpty(message = "Campo AUTOR requerido")
    @Length(min = 3, max = 255, message = "Campo AUTOR deve ter entre 3 e 255 caracteres")
    private String nomeAutor;

    @Column(length = 2000000, nullable = false)
    @NotEmpty(message = "Campo TEXTO requerido")
    private String texto;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
    
    public Livro() {
        super();
    }

    
    public Livro(Integer id, String titulo, String nomeAutor, String texto, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.nomeAutor = nomeAutor;
        this.texto = texto;
        this.categoria = categoria;
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

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Livro other = (Livro) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    
}
