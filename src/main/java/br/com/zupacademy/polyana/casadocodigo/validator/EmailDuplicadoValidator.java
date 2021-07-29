package br.com.zupacademy.polyana.casadocodigo.validator;

import br.com.zupacademy.polyana.casadocodigo.domain.Autor;
import br.com.zupacademy.polyana.casadocodigo.dto.AutorRequest;
import br.com.zupacademy.polyana.casadocodigo.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class EmailDuplicadoValidator implements Validator {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return AutorRequest.class.isAssignableFrom(aClass); //verifica se a classe que ta chegando no parametro é a request ou filha
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(errors.hasErrors()){   //verifica os erros de validação já verificados antes pelo spring
            return;
        }
        AutorRequest autorRequest = (AutorRequest) o;  //objeto que apresenta o formulario
        Optional<Autor> procuraAutor = autorRepository.findByEmail(autorRequest.getEmail());
        if(procuraAutor.isPresent()){
            errors.rejectValue("email", null, "Email já cadastrado: "+ autorRequest.getEmail()); //rejeita o email, errorcode indefinido, e deixa mensagem
        }
    }
}
