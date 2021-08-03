package br.com.zupacademy.polyana.casadocodigo.dto;

import br.com.zupacademy.polyana.casadocodigo.domain.Estado;
import br.com.zupacademy.polyana.casadocodigo.domain.Pais;
import br.com.zupacademy.polyana.casadocodigo.repository.PaisRepository;
import br.com.zupacademy.polyana.casadocodigo.validator.ExistsId;
import br.com.zupacademy.polyana.casadocodigo.validator.UniqueValue;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public class EstadoRequest {

    @NotBlank(message = "Nome é um campo obrigatório")
    @UniqueValue(fieldName = "nome", domainClass = Estado.class)
    private String nome;
    @NotNull @ExistsId(fieldName = "id", domainClass = Pais.class)
    private Long idPais;

    public EstadoRequest(String nome,Long idPais) {
        this.nome = nome;
        this.idPais = idPais;
    }

    public Estado converter(PaisRepository paisRepository) {
        Optional<Pais> pais = paisRepository.findById(this.idPais);

        return new Estado(nome, pais.get());
    }
}
