package br.com.zupacademy.polyana.casadocodigo.controller;

import br.com.zupacademy.polyana.casadocodigo.domain.Livro;
import br.com.zupacademy.polyana.casadocodigo.dto.LivroRequest;
import br.com.zupacademy.polyana.casadocodigo.dto.LivroResponse;
import br.com.zupacademy.polyana.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.polyana.casadocodigo.repository.CategoriaRepository;
import br.com.zupacademy.polyana.casadocodigo.repository.LivroRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/livros")
public class LivroController {


    private LivroRepository livroRepository;
    private AutorRepository autorRepository;
    private CategoriaRepository categoriaRepository;

    public LivroController(LivroRepository livroRepository, AutorRepository autorRepository, CategoriaRepository categoriaRepository) {
        this.livroRepository = livroRepository;
        this.autorRepository = autorRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Livro> cadastrar(@RequestBody @Valid LivroRequest livroRequest) {

        Livro livro = livroRequest.converter(autorRepository, categoriaRepository);
        livroRepository.save(livro);

         return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List> visualizar() {
        List<LivroResponse> livros = new ArrayList<>();

        livroRepository.findAll().forEach(
                livro -> { livros.add(new LivroResponse(livro));
                }
        );
        return ResponseEntity.ok(livros);
    }
}
