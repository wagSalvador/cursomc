package com.wagner.cursomc.resources;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.wagner.cursomc.domain.Cliente;
import com.wagner.cursomc.domain.Cliente;
import com.wagner.cursomc.dto.ClienteDTO;
import com.wagner.cursomc.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

    @Autowired
    private ClienteService clienteService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Cliente> find(@PathVariable Integer id) {
        Cliente cliente = clienteService.find(id);
        return ResponseEntity.ok(cliente);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody ClienteDTO clienteDTO, @PathVariable Integer id) {
        clienteDTO.setId(id);
        clienteService.update(clienteDTO);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<ClienteDTO>> findAll() {
        List<ClienteDTO> clientes = clienteService.findAll().stream().map(ClienteDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(clientes);
    }

    @RequestMapping(value = "page", method = RequestMethod.GET)
    public ResponseEntity<Page<ClienteDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, @RequestParam(value = "orderBy", defaultValue = "nome") String ordeBy, @RequestParam(value = "direction", defaultValue = "ASC") String diretion) {
        Page<Cliente> clientePage = clienteService.findPage(page, linesPerPage, ordeBy, diretion);
        Page<ClienteDTO> ClienteDTOS = clientePage.map(ClienteDTO::new);
        return ResponseEntity.ok().body(ClienteDTOS);

    }
}
