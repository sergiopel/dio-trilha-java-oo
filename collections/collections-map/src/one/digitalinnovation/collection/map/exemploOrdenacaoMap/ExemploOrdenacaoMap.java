package one.digitalinnovation.collection.map.exemploOrdenacaoMap;

import com.sun.source.tree.Tree;

import java.util.*;

/*
Dadas as seguintes informações sobre meus livros favoritos e seus autores, crie
 um dicionário e ordene este dicionário exibindo:
 (Nome Autor - Nome Livro)

 Autor = Hawking, Stephen - Livro = nome: Uma breve história do tempo - páginas: 256
 Autor = Duhigg, Charles - Livro = nome: O poder do hábito, páginas: 408
 Author = Harari, Yuval Noah - Livro = 21 lições para o século 21, páginas: 432
 */
public class ExemploOrdenacaoMap {
    public static void main(String[] args) {
        //1o. criar a classe Livro
        // Deverá imprimir (Nome Autor - Nome Livro)
        System.out.println("--\tOrdem Aleatória\t--");
        // ordem aleatória, usar hashmap
        Map<String, Livro> meusLivros = new HashMap<>(){{
            // relembrando sintexe: put(chave, valor)
            // então: put (Autor, Livro)
            put("Hawking, Stephen", new Livro("Uma breve história do tempo", 256));
            put("Duhigg, Charles", new Livro("O poder do hábito", 408));
            put("Harari, Yuval Noah", new Livro("21 lições para o século 21", 432));
        }};

        // para trabalhar com elementos separadamente, deve-se usar o método entrySet,
        // pois eu só quero pegar a chave e o valor sendo somente o nome do livro, mas não o nr.paginas
        for (Map.Entry<String, Livro> livro : meusLivros.entrySet()) {
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
        }


        System.out.println("--\tOrdem Inserção\t--");
        // Ordem de inserção utilizar LinkedHashMap
        Map<String, Livro> meusLivros2 = new LinkedHashMap<>(){{
            put("Hawking, Stephen", new Livro("Uma breve história do tempo", 256));
            put("Duhigg, Charles", new Livro("O poder do hábito", 408));
            put("Harari, Yuval Noah", new Livro("21 lições para o século 21", 432));
        }};

        for (Map.Entry<String, Livro> livro : meusLivros2.entrySet()) {
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
        }


        System.out.println("--\tOrdem Alfabética Autores\t--");
        // Ou seja, de acordo com a ordem das chaves. Utilizar TreeMap
        Map<String, Livro> meusLivros3 = new TreeMap<>(meusLivros2);

        for (Map.Entry<String, Livro> livro : meusLivros3.entrySet()) {
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
        }


        System.out.println("--\tOrdem Alfabética Nomes dos Livros\t--");
        // Aqui o nome dos livro está na parte dos valores ("chave", valor), então
        // preciso usar o Set e TreeSet, pois preciso passar um Comparator
        Set<Map.Entry<String, Livro>> meusLivros4 = new TreeSet<>(new ComparatorNome());
        meusLivros4.addAll(meusLivros.entrySet());
        for (Map.Entry<String, Livro> livro : meusLivros4) {
            System.out.println(livro.getKey() + " - " + livro.getValue().getNome());
        }


        System.out.println("--\tOrdem Número de Página\t--");
        // Aqui o número das páginas dos livros estão na parte dos valores ("chave", valor), então
        // preciso usar o Set e TreeSet, pois preciso passar um Comparator
        Set<Map.Entry<String, Livro>> meusLivros5 = new TreeSet<>(new ComparatorNrPaginas());
        meusLivros5.addAll(meusLivros.entrySet());
        for (Map.Entry<String, Livro> livro : meusLivros5) {
            System.out.println(livro.getKey() + " - " + livro.getValue().getPaginas());
        }

    }
}

class Livro {
    private String nome;
    private Integer paginas;

    public Livro(String nome, Integer paginas) {
        this.nome = nome;
        this.paginas = paginas;
    }

    public String getNome() {
        return nome;
    }

    public Integer getPaginas() {
        return paginas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return nome.equals(livro.nome) && paginas.equals(livro.paginas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, paginas);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "nome='" + nome + '\'' +
                ", paginas=" + paginas +
                '}';
    }
}

class ComparatorNome implements Comparator<Map.Entry<String, Livro>>{

    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return l1.getValue().getNome().compareToIgnoreCase(l2.getValue().getNome());
    }
}

class ComparatorNrPaginas implements Comparator<Map.Entry<String, Livro>>{

    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return l1.getValue().getPaginas().compareTo(l2.getValue().getPaginas());
    }
}