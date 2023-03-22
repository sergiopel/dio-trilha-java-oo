package one.digitalinnovation.collections.set;

import java.util.*;

public class ExemploSet {
    public static void main(String[] args) {
        System.out.println("Crie um conjunto e adicione as notas: ");
        Set<Double> notas = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
        // diferenças para o List:
        // na impressão abaixo, os valores não serão mostrados na ordem de inclusão
        // e não mostrará valores repetidos
        System.out.println(notas);

        // Com o Set não consigo trabalhar com índices.
        // Com o Set, não consigo exibir a posição de um elemento, nem
        // adicionar um elemento numa determinada posição. Também não
        // tem como substituir um elemento por outro

        System.out.println("Confira se a nota 5.0 está no conjunto: " + notas.contains(5d));

        // Seu funciomento é análogo ao exemplo do List
        System.out.println("Exiba a menor nota: " + Collections.min(notas));

        // Seu funciomento é análogo ao exemplo do List
        System.out.println("Exiba a maior nota: " + Collections.max(notas));

        // Seu funciomento é análogo ao exemplo do List
        System.out.println("Exiba a soma dos valores: ");
        Iterator<Double> iterator = notas.iterator();
        Double soma = 0.0;
        while(iterator.hasNext()){
            Double next = iterator.next();
            soma += next;
        }
        System.out.println("A soma dos valores é: " + soma);

        // Seu funciomento é análogo ao exemplo do List
        System.out.println("Exiba a média das notas: " + (soma / notas.size()));

        // Seu funciomento é análogo ao exemplo do List, exceto que não acessa o índice, mas somente o valor
        System.out.println("Remova a nota 0: ");
        notas.remove(0d);
        System.out.println(notas);

        // Seu funciomento é análogo ao exemplo do List
        System.out.println("Remova as notas menores que 7 e exiba a lista: ");
        Iterator<Double> iterator1 = notas.iterator();
        while(iterator1.hasNext()){
            Double next = iterator1.next();
            if (next < 7) iterator1.remove();
        }
        System.out.println(notas);

        //Para exibir as notas na ordem em que foram informadas, é preciso
        // usar o LinkedHashSet
        System.out.println("Exiba todas as notas na ordem que foram informadas: ");
        Set<Double> notas2 = new LinkedHashSet<>();
        notas2.add(7d);
        notas2.add(8.5);
        notas2.add(9.3);
        notas2.add(5d);
        notas2.add(7d);
        notas2.add(0d);
        notas2.add(3.6);
        // como visto anteriormente o Set não permite incluir valor repetido,
        // por isso a ide já identifica erro
        System.out.println(notas2);

        // TreeSet organiza com a ordem natural dos elementos, então como notas2 é um Set
        // do tipo Double, já implementa o Comparable
        System.out.println("Exiba todas as notas na ordem crescente: ");
        Set<Double> notas3 = new TreeSet<>(notas2);
        System.out.println(notas3);
        // O TreeSet acima só funcionou porque o notas2 tem Double que tem
        // Comparable

        //Seu funciomento é análogo ao exemplo do List
        System.out.println("Apague todo o conjunto");
        notas.clear();
        System.out.println("Confira se o conjunto está vazio: " + notas.isEmpty());


    }
}
