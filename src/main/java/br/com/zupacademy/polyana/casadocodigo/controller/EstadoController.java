package br.com.zupacademy.polyana.casadocodigo.controller;

import br.com.zupacademy.polyana.casadocodigo.domain.Estado;
import br.com.zupacademy.polyana.casadocodigo.dto.EstadoRequest;
import br.com.zupacademy.polyana.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.polyana.casadocodigo.repository.PaisRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/estados")
public class EstadoController {

    private EstadoRepository estadoRepository;
    private PaisRepository paisRepository;

    public EstadoController(EstadoRepository estadoRepository,PaisRepository paisRepository) {
        this.estadoRepository = estadoRepository;
        this.paisRepository = paisRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Estado> cadastrar(@RequestBody @Valid EstadoRequest estadoRequest) {

        Estado estado = estadoRequest.converter(paisRepository);
        estadoRepository.save(estado);

        return ResponseEntity.ok().build();
    }
}
