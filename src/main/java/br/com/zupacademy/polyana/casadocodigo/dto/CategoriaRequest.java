package br.com.zupacademy.polyana.casadocodigo.dto;

import br.com.zupacademy.polyana.casadocodigo.domain.Categoria;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;

public class CategoriaRequest {

    @NotBlank(message = "Nome é um campo obrigatório")
    private String nome;

    @JsonCreator
    public CategoriaRequest(@JsonProperty("nome") String nome) {
        this.nome = nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Categoria converter() {
        return new Categoria(this.nome);
    }

}
