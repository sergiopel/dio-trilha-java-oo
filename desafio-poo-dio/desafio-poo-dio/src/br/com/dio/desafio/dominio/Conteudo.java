package br.com.dio.desafio.dominio;

/**
 *  Quando eu crio um método abstrato, significa que as classes filhas que estenderem essa classe,
 *  serão obrigadas a implementar esse método abstrato.
 *  Quando eu crio um método abstrato, a classe obrigatoriamente tem que ser abstrata.
 *  Quando a classe é abstrata, impossibilita de qualquer outra classe instanciá-la.
 *
 */
public abstract class Conteudo {

    protected static final double XP_PADRAO = 10d;

    private String titulo;
    private String descricao;

    public abstract double calcularXp();

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
