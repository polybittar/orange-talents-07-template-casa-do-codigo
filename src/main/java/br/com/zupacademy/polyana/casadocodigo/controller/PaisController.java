package br.com.zupacademy.polyana.casadocodigo.controller;

import br.com.zupacademy.polyana.casadocodigo.domain.Pais;
import br.com.zupacademy.polyana.casadocodigo.dto.PaisRequest;
import br.com.zupacademy.polyana.casadocodigo.repository.PaisRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/paises")
public class PaisController {

    private PaisRepository paisRepository;

    public PaisController(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Pais> cadastrar(@RequestBody @Valid PaisRequest paisRequest) {

        Pais pais = paisRequest.converter();
        paisRepository.save(pais);

        return ResponseEntity.ok().build();
    }
}
