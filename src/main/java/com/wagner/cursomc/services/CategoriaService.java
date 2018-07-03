package com.wagner.cursomc.services;

import com.wagner.cursomc.domain.Categoria;
import com.wagner.cursomc.respositories.CategoriaRepository;
import com.wagner.cursomc.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria find(Integer id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class));
    }

    public Categoria insert(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria update(Categoria categoria) {
        find(categoria.getId());
        //metodo do SpringData utiliza método save tanto para inserir quanto atualizar a direfença é que ele ferifica se o id vem null
        return categoriaRepository.save(categoria);
    }
}
