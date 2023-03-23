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
        //Como usa a Set, a implementação HashSet tem por default mostrar pela ordem aleatória
        // 1o. Criar a classe Serie
        // 2o. Criar a Set e inserir os minhas séries conforme está sendo pedido
        Set<Serie> minhasSeries = new HashSet<>(){{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("dark","drama", 60));
            add(new Serie("that '70s show","comédia", 25));
        }};
        for (Serie serie: minhasSeries) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() +
                    " - " + serie.getTempoEpisodio());
        }

        // A implementação LinkedHashSet mantém a ordem da inserção
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
        // dará, erro, então a partir desse momento deverei implementar a interface
        // Comparable na minha classe Serie, sendo que o método obrigatório
        // compareTo deverá comparar o tempoEpisodio
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
        System.out.println("--\tOrdem Gênero\t--");
        Set<Serie> minhasSeries5 = new TreeSet<>(new ComparatorGenero());
        minhasSeries5.addAll(minhasSeries);
        for (Serie serie:minhasSeries5) {
            System.out.println(serie.getNome() + " - " + serie.getGenero() +
                    " - " + serie.getTempoEpisodio());
        }

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

    // Quando estiver implementando interfaces que no nome tem a palavra "Hash",
    // é importante sobrescrever o equals e o hashCode
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
        // no Set não apresenta duplicidade, então se o tempo do episodio se repetir só sairá um deles
        // neste caso
        int tempoEpisodio = Integer.compare(this.getTempoEpisodio(), serie.getTempoEpisodio());
        // se os tempos dos episódios comparados forem diferentes
        if (tempoEpisodio != 0) return tempoEpisodio; // se não forem iguais retorna aqui

        // se forem iguais compara com gênero para poder sair todos
        return this.getGenero().compareTo(serie.getGenero());

    }
}


class ComparatorNomeGeneroTempoEpisodio implements Comparator<Serie>{

    @Override
    public int compare(Serie s1, Serie s2) {
        // se os nomes forem diferentes, vou comparar por nome
        int nome = s1.getNome().compareTo(s2.getNome());
        if (nome != 0) return nome; // se não são iguais, retorna o nome

        // se os nomes acima forem iguais, vem pra cá e compara os generos
        int genero = s1.getGenero().compareTo(s2.getGenero());
        if (genero != 0) return genero; // se os generos não forem iguais, retorna o genero

        // por ultimo, se os generos acima forem iguais, vem pra cá e compara os tempo dos episodios
        return Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());
    }
}

class ComparatorGenero implements Comparator<Serie>{

    @Override
    public int compare(Serie s1, Serie s2) {
        return s1.getGenero().compareToIgnoreCase(s2.getGenero());

    }
}