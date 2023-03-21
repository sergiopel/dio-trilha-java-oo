package one.digitalinnovation.collections.set;

import java.util.*;

/*
Dadas as seguintes informações sobre minhas séries favoritas,
crie um conjunto e ordene este conjunto exibindo:
(nome - gênero - tempo de episódio)

Série 1 = nome: got, genero: fantasia, tempoEpisodio: 60
Série 2 = nome: dark, genero: drama, tempoEpisodio: 60
Série 3 = nome: that '70s show, genero: comédia, tempoEpisodio: 25
 */
public class ExemploOrdenacaoSet {
    public static void main(String[] args) {

        System.out.println("--\tOrdem aleatória\t--");
        Set<Serie> minhasSeries = new HashSet<>(){{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("dark","drama", 60));
            add(new Serie("that '70s show","comédia", 25));
        }};
        for (Serie serie: minhasSeries) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() +
                    " - " + serie.getTempoEpisodio());
        }

        System.out.println("--\tOrdem inserção\t--");
        // Utilizar LinkedHashSet
        Set<Serie> minhasSeries2 = new LinkedHashSet<>(){{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("dark","drama", 60));
            add(new Serie("that '70s show","comédia", 25));
        }};
        for (Serie serie: minhasSeries2) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() +
                    " - " + serie.getTempoEpisodio());
        }

        System.out.println("--\tOrdem natural (TempoEpisodio)\t--");
        // Utilizar TreeSet
        Set<Serie> minhasSeries3 = new TreeSet<>(minhasSeries2);
        //System.out.println(minhasSeries3);
        // dará, erro, então a partir desse momento deverei criar um
        // Comparable para a minha classe Serie
        for (Serie serie: minhasSeries3) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() +
                    " - " + serie.getTempoEpisodio());
        }
        // no foreach acima não sairá o 'dark', pois possui o mesmo TempoEpisodio de 60
        // e o Set não recebe objetos iguais, então foi preciso mudar a sobrescrita
        // compareTo da classe Serie

        System.out.println("--\tOrdem Nome/Gênero/TempoEpisodio\t--");
        // precisa criar uma classe comparator
        Set<Serie> minhasSeries4 = new TreeSet<>(new ComparatorNomeGeneroTempoEpisodio());
        minhasSeries4.addAll(minhasSeries);
        for (Serie serie: minhasSeries4) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() +
                    " - " + serie.getTempoEpisodio());
        }

        // para fazer depois:
        //System.out.println("--\tOrdem Gênero\t--");
        //System.out.println("--\tOrdem TempoEpisodio\t--");


    }
}

class Serie implements Comparable<Serie>{
    private String nome;
    private String genero;
    private Integer tempoEpisodio;



    public Serie(String nome, String genero, Integer tempoEpisodio) {
        this.nome = nome;
        this.genero = genero;
        this.tempoEpisodio = tempoEpisodio;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public Integer getTempoEpisodio() {
        return tempoEpisodio;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", tempoEpisodio=" + tempoEpisodio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie serie = (Serie) o;
        return nome.equals(serie.nome) && genero.equals(serie.genero) && tempoEpisodio.equals(serie.tempoEpisodio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, genero, tempoEpisodio);
    }

    @Override
    public int compareTo(Serie serie) {
        int tempoEpisodio = Integer.compare(this.getTempoEpisodio(), serie.getTempoEpisodio());
        // se os tempos dos episódios comparados forem diferentes
        if (tempoEpisodio != 0) return tempoEpisodio;

        return this.getGenero().compareTo(serie.getGenero());

    }
}


class ComparatorNomeGeneroTempoEpisodio implements Comparator<Serie>{

    @Override
    public int compare(Serie s1, Serie s2) {
        // se os nomes forem diferentes, vou comparar por nome
        int nome = s1.getNome().compareTo(s2.getNome());
        if (nome != 0) return nome;

        // se os generos forem diferentes, vou comparar por genero
        int genero = s1.getGenero().compareTo(s2.getGenero());
        if (genero != 0) return genero;

        // por ultimo, vou comparar por tempo do episodio
        return Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());
    }
}