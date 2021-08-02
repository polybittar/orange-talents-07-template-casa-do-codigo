package br.com.zupacademy.polyana.casadocodigo.dto;


import br.com.zupacademy.polyana.casadocodigo.domain.Autor;


public class DetalhesAutorResponse{

        private String nome;
        private String descricao;

    public DetalhesAutorResponse(Autor autor) {

        nome = autor.getNome();
        descricao = autor.getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
