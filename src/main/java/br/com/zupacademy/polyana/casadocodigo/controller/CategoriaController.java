package br.com.zupacademy.polyana.casadocodigo.controller;

import br.com.zupacademy.polyana.casadocodigo.domain.Categoria;
import br.com.zupacademy.polyana.casadocodigo.dto.CategoriaRequest;
import br.com.zupacademy.polyana.casadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<Categoria> cadastrar(@RequestBody @Valid CategoriaRequest categoriaRequest) {

        Categoria categoria = categoriaRequest.converter();
        categoriaRepository.save(categoria);

         return ResponseEntity.ok().build();
    }

}
