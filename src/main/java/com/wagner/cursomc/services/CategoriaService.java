package com.wagner.cursomc.services;

import com.wagner.cursomc.domain.Categoria;
import com.wagner.cursomc.dto.CategoriaDTO;
import com.wagner.cursomc.respositories.CategoriaRepository;
import com.wagner.cursomc.services.exceptions.DataIntegrityException;
import com.wagner.cursomc.services.exceptions.ObjectNotFoundException;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria find(Integer id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class));
    }

    public Categoria insert(CategoriaDTO categoria) {
        return categoriaRepository.save(fromDTO(categoria));
    }

    public Categoria update(CategoriaDTO categoriaDTO) {
        Categoria categoria = find(fromDTO(categoriaDTO).getId());
        //metodo do SpringData utiliza método save tanto para inserir quanto atualizar a direfença é que ele ferifica se o id vem null
        return categoriaRepository.save(categoria);
    }

    public void delete(Integer id) {
        try {
            categoriaRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possivel excluir uma categoria que possui produtos");
        }
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return categoriaRepository.findAll(pageRequest);
    }

    public Categoria fromDTO(CategoriaDTO categoriaDTO) {
        return new Categoria(categoriaDTO.getId(), categoriaDTO.getNome());
    }
}
