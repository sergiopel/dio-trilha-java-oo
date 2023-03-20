package one.digitalinnovation.collection.list;

import java.util.*;

/*
Dadas as seguintes informações sobre meus gatos, crie uma lista
o ordene esta lista exibindo:
(nome - idade - cor)

Gato 1 = nome: John, idade: 18, cor: preto
Gato 2 - nome: Simba, idade: 6, cor: tigrado
Gato 3 - nome: John, idade: 12, cor: amarelo
 */
public class ExemploOrdenacaoList {
    public static void main(String[] args) {
        // já criei a minha classe Gatoa abaixo, e agora
        // preciso colocá-los numa lista
        List<Gato> meusGatos = new ArrayList<>(){{
            add(new Gato("John", 18, "preto"));
            add(new Gato("Simba", 6, "tigrado"));
            add(new Gato("John", 12, "amarelo"));

        }};
        // nessa impressão, irá mostrar os endereços de memória,
        // então eu preciso sobrescrever dentro da classe Gato o toString
        System.out.println(meusGatos);

        //Como usa a List, o default é sempre mostrar pela ordem de inserção
        System.out.println("--\tOrdem de Inserção\t--");
        System.out.println(meusGatos);

        // é preciso utilizar a classe Collections
        System.out.println("--\tOrdem aleatória\t--");
        Collections.shuffle(meusGatos);
        System.out.println(meusGatos);

        System.out.println("--\tOrdem Natural (Nome)\t--");
        Collections.sort(meusGatos);
        System.out.println(meusGatos);

        // Utilizando agora a Interface Comparator
        System.out.println("--\tOrdem de Idade\t--");
        // um dos 2 sort abaixo funciona
        //Collections.sort(meusGatos, new ComparatorIdade());
        meusGatos.sort(new ComparatorIdade());
        System.out.println(meusGatos);

        System.out.println("--\tOrdem de cor\t--");
        meusGatos.sort(new ComparatorCor());
        System.out.println(meusGatos);

        System.out.println("--\tOrdem de Nome/Cor/Idade\t--");
        //meusGatos.sort(new ComparatorNomeCorIdade());
        Collections.sort(meusGatos, new ComparatorNomeCorIdade());
        System.out.println(meusGatos);





    }
}

/*
Criar classe gato, com construtor, getters
 */
class Gato implements Comparable<Gato>{
    private String nome;
    private Integer idade;
    private String cor;

    public Gato(String nome, Integer idade, String cor) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public String getCor() {
        return cor;
    }

    @Override
    public String toString() {
        return "{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cor='" + cor + '\'' +
                '}';
    }

    @Override
    /*
    retorna um int,
     quando for 0, é pq os nomes são iguais
     quando for 1, é pq o nome que estou comparando é maior
     quando for -1, é pq o nome que estou comparando é menor
     */
    public int compareTo(Gato gato) {
        return this.getNome().compareToIgnoreCase(gato.getNome());
    }
}

class ComparatorIdade implements Comparator<Gato> {

    @Override
    public int compare(Gato g1, Gato g2) {
        return Integer.compare(g1.getIdade(), g2.getIdade());
    }
}

class ComparatorCor implements Comparator<Gato>{

    @Override
    public int compare(Gato g1, Gato g2) {
        return g1.getCor().compareToIgnoreCase(g2.getCor());
    }
}

class ComparatorNomeCorIdade implements Comparator<Gato>{

    @Override
    public int compare(Gato g1, Gato g2) {
        int nome = g1.getNome().compareToIgnoreCase(g2.getNome());
        if (nome != 0) return nome; //se forem diferentes

        int cor = g1.getCor().compareToIgnoreCase(g2.getCor());
        if (cor != 0) return cor; //se forem diferentes

        return Integer.compare(g1.getIdade(), g2.getIdade());
    }
}