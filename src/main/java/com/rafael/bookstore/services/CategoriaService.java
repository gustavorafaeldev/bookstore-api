package com.rafael.bookstore.services;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafael.bookstore.domain.Categoria;
import com.rafael.bookstore.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;
    
    public Categoria findById(Integer id) {
        Optional<Categoria> obj = categoriaRepository.findById(id);
        return obj.orElseThrow(() -> new com.rafael.bookstore.exceptions.ObjectNotFoundException("Objeto não encontrado! Id: "+ id+ ", Tipo: "+ Categoria.class.getName()));
    }
}
