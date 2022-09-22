package com.rafael.bookstore.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.bookstore.domain.Categoria;
import com.rafael.bookstore.domain.Livro;
import com.rafael.bookstore.repository.CategoriaRepository;
import com.rafael.bookstore.repository.LivroRepository;

@Service
public class DBService{
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private LivroRepository livroRepository;

    public void instanciaBaseDeDados() {

        Categoria cat1 = new Categoria(null, "Informática", "Livros de TI");
		Categoria cat2 = new Categoria(null, "Arquitetura", "Livros de Arquitetura");

		Livro l1 = new Livro(null, "Clean code", "Robert Martin", "Lorem", cat1);
		Livro l2 = new Livro(null, "Livro teste", "Rafael Lira", "Lorem ipsum", cat1);
		Livro l3 = new Livro(null, "Arquitetura de Computadores", "Robert Maier", "lorem", cat2);
		Livro l4 = new Livro(null, "Engenharia Descomplicada", "Jeff Boss", "Lorem ipsum", cat2);

		cat1.getLivros().addAll(Arrays.asList(l1, l2));
		cat2.getLivros().addAll(Arrays.asList(l3, l4));

		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4));
    }
}
