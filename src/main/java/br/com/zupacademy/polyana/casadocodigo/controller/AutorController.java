package br.com.zupacademy.polyana.casadocodigo.controller;

import br.com.zupacademy.polyana.casadocodigo.domain.Autor;
import br.com.zupacademy.polyana.casadocodigo.dto.AutorRequest;
import br.com.zupacademy.polyana.casadocodigo.repository.AutorRepository;
import br.com.zupacademy.polyana.casadocodigo.validator.EmailDuplicadoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private EmailDuplicadoValidator emailDuplicadoValidator;

    @InitBinder //colocar validações custumizadas
    public void init(WebDataBinder binder){  //utilizado quando um request é feito para fazer config adicionais
        binder.addValidators(emailDuplicadoValidator);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Autor> cadastrar(@RequestBody @Valid AutorRequest autorRequest) {

        Autor autor = autorRequest.converter();
        autorRepository.save(autor);

         return ResponseEntity.ok().build();
    }

}
