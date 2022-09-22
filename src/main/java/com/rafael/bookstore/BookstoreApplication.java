package com.rafael.bookstore;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rafael.bookstore.domain.Categoria;
import com.rafael.bookstore.domain.Livro;
import com.rafael.bookstore.repository.CategoriaRepository;
import com.rafael.bookstore.repository.LivroRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private LivroRepository livroRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática", "Livros de TI");

		Livro l1 = new Livro(null, "Clean code", "Robert Martin", "Lorem ipsum", cat1);
		Livro l2 = new Livro(null, "Livro teste", "Rafael Lira", "Lorem ipsum", cat1);

		cat1.getLivros().addAll(Arrays.asList(l1, l2));

		this.categoriaRepository.saveAll(Arrays.asList(cat1));
		this.livroRepository.saveAll(Arrays.asList(l1, l2));
	}
}
