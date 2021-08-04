package br.com.zupacademy.polyana.casadocodigo.controller;

import br.com.zupacademy.polyana.casadocodigo.domain.Cliente;
import br.com.zupacademy.polyana.casadocodigo.dto.ClienteRequest;
import br.com.zupacademy.polyana.casadocodigo.dto.ClienteResponse;
import br.com.zupacademy.polyana.casadocodigo.repository.ClienteRepository;
import br.com.zupacademy.polyana.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.polyana.casadocodigo.repository.PaisRepository;
import br.com.zupacademy.polyana.casadocodigo.validator.EstadoExisteEmPaisValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private ClienteRepository clienteRepository;
    private PaisRepository paisRepository;
    private EstadoRepository estadoRepository;
    private EstadoExisteEmPaisValidator estadoExisteEmPaisValidator;

    public ClienteController(ClienteRepository clienteRepository, PaisRepository paisRepository, EstadoRepository estadoRepository, EstadoExisteEmPaisValidator estadoExisteEmPaisValidator) {
        this.clienteRepository = clienteRepository;
        this.paisRepository = paisRepository;
        this.estadoRepository = estadoRepository;
        this.estadoExisteEmPaisValidator = estadoExisteEmPaisValidator;
    }

    @InitBinder
    public void init(WebDataBinder binder) {
        binder.addValidators(estadoExisteEmPaisValidator);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<ClienteResponse> cadastrar(@RequestBody @Valid ClienteRequest clienteRequest) {

        Cliente cliente = clienteRequest.converter(paisRepository, estadoRepository);
        clienteRepository.save(cliente);

        return ResponseEntity.ok().body(new ClienteResponse(cliente));
    }
}
