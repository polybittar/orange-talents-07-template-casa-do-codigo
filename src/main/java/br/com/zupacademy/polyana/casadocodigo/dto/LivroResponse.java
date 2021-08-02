package br.com.zupacademy.polyana.casadocodigo.dto;


import br.com.zupacademy.polyana.casadocodigo.domain.Livro;

public class LivroResponse {

    private Long id;
    private String titulo;

    public LivroResponse(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
