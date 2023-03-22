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

        //Como usa a List, o default é sempre mostrar pela ordem de inserção
        System.out.println("--\tOrdem de Inserção\t--");
        // 1o. Criar a classe Gatos
        // 2o. Criar a lista e inserir os gatos conforme está sendo pedido

        List<Gato> meusGatos = new ArrayList<>(){{
            add(new Gato("John", 18, "preto"));
            add(new Gato("Simba", 6, "tigrado"));
            add(new Gato("John", 12, "amarelo"));

        }};
        // Caso o método toString não seja sobrescrito, irá apresentar os endereços de
        // memória na impressão da tela
        System.out.println(meusGatos);


        // é preciso utilizar a classe Collections
        System.out.println("--\tOrdem aleatória\t--");
        Collections.shuffle(meusGatos);
        System.out.println(meusGatos);

        // Nesse exercício eu precisei implementar a interface Comparable
        // na minha classe Gato
        System.out.println("--\tOrdem Natural (Nome)\t--");
        Collections.sort(meusGatos);
        System.out.println(meusGatos);

        // Utilizando agora a Interface Comparator nos 3 exemplos abaixo.
        // Não consigo usar o Comparable, pq eu já implementei o Comparable
        // na classe Gato para ordenar por Nome, no exercício acima.
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
Criar classe gato, com construtor, getters e toString
Ao longo dos exercícios, a classe implementará a Interface Comparable
com o uso obrigatório do método compareTo
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


    /*
    retorna um int,
     quando for 0, é pq os nomes são iguais
     quando for 1, é pq o nome que estou comparando é maior
     quando for -1, é pq o nome que estou comparando é menor
     */
    @Override
    public int compareTo(Gato gato)
    {
        return this.getNome().compareToIgnoreCase(gato.getNome());
        // o resultado dessa comparação retorna um int
        // se for = 0, significa que os gatos comparados são iguais
        // se for = -1, o gato comparado é menor (diferente)
        // se for = 1, o gato comparado é maior (diferente)
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
        //return String.CASE_INSENSITIVE_ORDER.compare(g1.getCor(), g2.getCor());
        // retorna um int
        // se as cores forem iguais, retorna 0
        // se a cor do gato1 for maior que a cor do gato2, retorna 1
        // se a cor do gato1 for menor que a cor do gato2, retorna -1
    }
}

class ComparatorNomeCorIdade implements Comparator<Gato>{

    @Override
    public int compare(Gato g1, Gato g2) {
        int nome = g1.getNome().compareToIgnoreCase(g2.getNome());
        if (nome != 0) return nome; //se forem diferentes (1 ou -1), ordenar por nome

        // se vier pra cá, significa que os nomes são iguais e o critério de desempate passa a ser a cor
        int cor = g1.getCor().compareToIgnoreCase(g2.getCor());
        if (cor != 0) return cor; //se forem diferentes (1 ou -1), ordenar por cor

        // se vier pra cá, também significa que as cores são iguais, então o critério
        // de desempate passará a ser a idade
        return Integer.compare(g1.getIdade(), g2.getIdade());
    }
}