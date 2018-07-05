package com.wagner.cursomc.services;

import com.wagner.cursomc.domain.Categoria;
import com.wagner.cursomc.domain.Cliente;
import com.wagner.cursomc.dto.CategoriaDTO;
import com.wagner.cursomc.dto.ClienteDTO;
import com.wagner.cursomc.respositories.ClienteRepository;
import com.wagner.cursomc.services.exceptions.DataIntegrityException;
import com.wagner.cursomc.services.exceptions.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente find(Integer id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class));
    }

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return clienteRepository.findAll(pageRequest);
    }

    public void update(ClienteDTO clienteDTO) {
        Cliente cliente = find(clienteDTO.getId());
        clienteRepository.save(cliente);
    }

    public void delete(Integer id) {
        try {
            clienteRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityException("Não é possivel excluir uma categoria que possui produtos");
        }
    }

    public Cliente fromDTO(ClienteDTO clienteDTO) {
        throw new UnsupportedOperationException();
    }
}
