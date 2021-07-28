package br.com.zupacademy.polyana.casadocodigo.dto;

import br.com.zupacademy.polyana.casadocodigo.domain.Autor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class AutorRequest {

    @NotBlank
    private String nome;
    @NotBlank @Email
    private String email;
    @NotBlank @Length(max=400)
    private String descricao;

    public AutorRequest(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getDescricao() {
        return descricao;
    }

    public Autor converter() {
        return new Autor(this.nome, this.email, this.descricao);
    }
}
