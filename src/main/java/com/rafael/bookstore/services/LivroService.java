package com.rafael.bookstore.services;

import com.rafael.bookstore.domain.Livro;
import com.rafael.bookstore.exceptions.ObjectNotFoundException;
import com.rafael.bookstore.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    @Autowired
    private CategoriaService categoriaService;

    public List<Livro> findAll(Integer id_cat) {
        categoriaService.findById(id_cat);
        return repository.findAllByCategoria(id_cat);
    }

    public Livro findById(Integer id) {
        Optional<Livro> livro = repository.findById(id);
        return livro.orElseThrow(() -> new ObjectNotFoundException("Livro não encontrado!" +
                " Id:"+ id+", Tipo: "+ Livro.class.getName()));
    }

    public Livro create(Livro livro) {
        livro.setId(null);
        return repository.save(livro);
    }

    public Livro update(Integer id, Livro obj) {
        Livro newObj = findById(id);
        updateData(newObj, obj);
        return repository.save(newObj);
    }

    private void updateData(Livro newObj, Livro obj) {
        newObj.setTitulo(obj.getTitulo());
        newObj.setNomeAutor(obj.getNomeAutor());
        newObj.setTexto(obj.getTexto());
    }
}
