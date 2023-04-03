package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Set;

public class Dev {
    private String nome;
    // lembrando LinkedHashSet é pra guardar na ordem de inclusão
    // lembrando que o Set não guarda valores repetidos
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public void inscreverBootcamp(Bootcamp bootcamp){

    }

    public void progredir(){

    }

    public void calcularTotalXp(){

    }
}
