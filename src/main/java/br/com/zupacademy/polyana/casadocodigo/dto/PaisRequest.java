package br.com.zupacademy.polyana.casadocodigo.dto;

import br.com.zupacademy.polyana.casadocodigo.domain.Pais;
import br.com.zupacademy.polyana.casadocodigo.validator.UniqueValue;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class PaisRequest {

    @NotBlank(message = "Nome é um campo obrigatório")
    @UniqueValue(fieldName = "nome", domainClass = Pais.class)
    private String nome;

    @JsonCreator
    public PaisRequest(@JsonProperty("nome") String nome) {
        this.nome = nome;
    }

    public Pais converter() {
        return new Pais(this.nome);
    }
}
