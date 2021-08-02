package br.com.zupacademy.polyana.casadocodigo.controller;

import br.com.zupacademy.polyana.casadocodigo.domain.Livro;
import br.com.zupacademy.polyana.casadocodigo.dto.LivroRequest;
import br.com.zupacademy.polyana.casadocodigo.repository.LivroRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/livros")
public class LivroController {


    private LivroRepository livroRepository;
    @PersistenceContext
    private EntityManager manager;

    public LivroController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }


    @PostMapping
    @Transactional
    public ResponseEntity<Livro> cadastrar(@RequestBody @Valid LivroRequest livroRequest) {

        Livro livro = livroRequest.converter(manager);
        livroRepository.save(livro);

         return ResponseEntity.ok().build();
    }

}
