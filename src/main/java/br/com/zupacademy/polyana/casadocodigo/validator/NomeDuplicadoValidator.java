package br.com.zupacademy.polyana.casadocodigo.validator;

import br.com.zupacademy.polyana.casadocodigo.domain.Categoria;
import br.com.zupacademy.polyana.casadocodigo.dto.CategoriaRequest;
import br.com.zupacademy.polyana.casadocodigo.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class NomeDuplicadoValidator implements Validator {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return CategoriaRequest.class.isAssignableFrom(aClass); //verifica se a classe que ta chegando no parametro é a request ou filha
    }

    @Override
    public void validate(Object o, Errors errors) {
        if(errors.hasErrors()){   //verifica os erros de validação já verificados antes pelo spring
            return;
        }
        CategoriaRequest categoriaRequest = (CategoriaRequest) o;  //objeto que apresenta o formulario
        Optional<Categoria> procuraCategoria = categoriaRepository.findByNome(categoriaRequest.getNome());
        if(procuraCategoria.isPresent()){
            errors.rejectValue("nome", null, "Nome já cadastrado: "+ categoriaRequest.getNome()); //rejeita o email, errorcode indefinido, e deixa mensagem
        }
    }
}
