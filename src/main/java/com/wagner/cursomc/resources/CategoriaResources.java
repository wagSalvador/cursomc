package com.wagner.cursomc.resources;

import com.wagner.cursomc.domain.Categoria;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResources {

    @RequestMapping(method = RequestMethod.GET)
    public List<Categoria> listarCategorias() {
        Categoria categoria1 =  new Categoria(1,"Informática");
        Categoria categoria2 =  new Categoria(2,"Escritório");
        List<Categoria> categorias = new ArrayList<>();
        categorias.add(categoria1);
        categorias.add(categoria2);
        return categorias;
    }

}
