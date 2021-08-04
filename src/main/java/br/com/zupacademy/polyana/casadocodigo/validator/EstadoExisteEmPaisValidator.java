package br.com.zupacademy.polyana.casadocodigo.validator;

import br.com.zupacademy.polyana.casadocodigo.dto.ClienteRequest;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
public class EstadoExisteEmPaisValidator implements Validator {

    @PersistenceContext
    EntityManager manager;

    @Override
    public boolean supports(Class<?> aClass) {
        return ClienteRequest.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        ClienteRequest clienteRequest = (ClienteRequest) o;
        Query query = manager.createQuery("select 1 from Estado where pais.id=:value");
        query.setParameter("value", clienteRequest.getPaisId());
        List<?> list = query.getResultList();

        if (list.size() >= 1) {
            query = manager.createQuery("select 1 from Estado where pais.id=:value and id=:valueestado");
            query.setParameter("value", clienteRequest.getPaisId());
            query.setParameter("valueestado", clienteRequest.getIdEstado());
            list = query.getResultList();
            if (list.size() == 0) {
                errors.rejectValue("paisId", null, "O pais não possui o estado: "+clienteRequest.getIdEstado());
            }
        } else {
            if (clienteRequest.getIdEstado() != null) {
                errors.rejectValue("paisId", null, "O pais não possui nenhum estado");
            }
        }
    }
}
