package com.wagner.cursomc;

import com.wagner.cursomc.domain.Categoria;
import com.wagner.cursomc.respositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public static void main(String[] args) {
        SpringApplication.run(CursomcApplication.class, args);
    }

    /**
     * Método para popular a base com dados ao ser iniciado o sistema.
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        Categoria categoria1 = new Categoria(null, "Informática");
        Categoria categoria2 = new Categoria(null, "Escritório");
        categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));

    }
}
