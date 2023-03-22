package one.digitalinnovation.collection.list;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class ExemploList {
    public static void main(String[] args) {
        // Dada uma lista com 7 notas, de um aluno [7d, 8.5, 9.3, 5d, 7d, 0d, 3.6], faça:
        //Crie uma lista e adicione 7 notas

        //Forma antiga de iniciar uma List - antes do java5
        //List notas = new ArrayList();

        //Depois do java5, para iniciar uma List, começou-se a usar o
        // conceito de generics.
        // Essa forma abaixo é a mais usada, voltada à interface
        //List<Double> notas = new ArrayList<>();

        //na maioria das vezes é recomendável programar voltado à interface e
        // não à implementação, então essa forma abaixo não é recomendável
        //ArrayList<Double> notas = new ArrayList<>();

        // Forma de incluir em uma lista:
        //List<Double> notas = new ArrayList<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));

        // Essa forma também é válida, mas é limitada, aqui eu não
        // posso incluir nem retirar elementos, depois...
        //List<Double> notas = Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6);

        // Essa outra forma também não permite nem adicionar, nem remover, depois...
        //List<Double> notas = List.of(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6);
        //notas.add(1d);

        System.out.println("Crie uma lista e adicione as sete notas: ");

        List<Double> notas = new ArrayList<>();

        // adicionando elementos à lista da forma mais convencional,
        // utilizando o método add
        // quando o double for por exemplo 7.0, pode ser incluído
        // como 7.0 ou 7d
        notas.add(7d);
        notas.add(8.5);
        notas.add(9.3);
        notas.add(5.0);
        notas.add(7.0);
        notas.add(0.0);
        notas.add(3.6);

        // Para imprimir a lista pode ser colocando somente a variável (notas),
        // ou a variável com toString, notas.toString(), tanto faz.
        System.out.println(notas.toString());

        System.out.println("Exiba a posição da nota 5.0: " + notas.indexOf(5.0));

        System.out.println("Adicione na lista a nota 8.0 na posição 4: ");
        notas.add(4, 8d);
        System.out.println(notas);

        System.out.println("Substitua a nota 5.0 pela nota 6.o");
        notas.set(notas.indexOf(5d), 6d);
        System.out.println(notas);

        System.out.println("Verifique se a nota 5.0 está na lista: " + notas.contains(5d));

        System.out.println("Exiba todas as notas na ordem em que foram informados: ");
        //Como estamos utilizando o list, então ele já exibe os elementos na ordme
        // em que foram incluídos
        //System.out.println(notas);
        // se eu quiser imprimir uma em baixo da outra, é só usar o foreach:
        for (Double nota : notas) System.out.println(nota);

        System.out.println("Exiba a terceira nota adicionada: " + notas.get(2));

        // Aqui não existe um método nativo no List
        // Então é preciso pegar da classe Collections
        // Para fazer a comparação dos valores da lista notas, internamente
        // ele utiliza a Interface Comparable, e como a minha lista é do tipo
        // Double ela implementa a interface Comparable
        // Para observar isso, abrir a classe Double
        System.out.println("Exiba a menor nota: " + Collections.min(notas));

        System.out.println("Exiba a maior nota: " + Collections.max(notas));

        // Não existe um método sum da lista para fazer a soma de uma só vez
        // É preciso utilizar o método iterator para apresentar a soma uma por uma dos
        // valores da lista
        Iterator<Double> iterator = notas.iterator();
        Double soma = 0d;
        while (iterator.hasNext()){ //enquanto tiver próximo elemento
            Double next = iterator.next();
            soma += next;
        }
        System.out.println("Exiba a soma dos valores: " + soma);

        System.out.println("Quantidade de elementos da lista: " + notas.size());

        // Para saber a quantidade de elementos da lista utilizar o método size
        System.out.println("Exiba a média dos valores: " + (soma/notas.size()));

        // Sabemos que a lista é de double, então se eu colocar um valor que seja
        // inteiro, irá remover por índice. Então para remover por valor (objeto),
        // tem que colocar o valor como double
        System.out.println("Remova a nota 0: " + notas.remove(0d));
        System.out.println(notas.toString());

        System.out.println("Remova a nota na posição 0: ");
        notas.remove(0);
        System.out.println(notas);

        // No método remove abaixo não tem nenhum argumento pq o iterator1 já
        // contém o valor.
        System.out.println("Remova as notas menores que 7 e exiba a lista: ");
        Iterator<Double> iterator1 = notas.iterator();
        while(iterator1.hasNext()){
            Double next = iterator1.next();
            if (next < 7) iterator1.remove();
        }
        System.out.println(notas);

        System.out.println("Apague toda a lista");
        notas.clear();
        System.out.println(notas);

        System.out.println("Verificar se a lista está vazia: " + notas.isEmpty());


//Resolva esses exercícios utilizando os métodos da implementação LinkedList

        System.out.println("Crie uma lista chamada notas2, implementando LinkedList " +
                  "e coloque todos os elementos da list ArrayList nessa nova Lista: ");

        notas.add(7d);
        notas.add(8.5);
        notas.add(9.3);
        notas.add(5.0);
        notas.add(7.0);
        notas.add(0.0);
        notas.add(3.6);
        List<Double> notas2 = new LinkedList<>();
        Iterator<Double> iterator2 = notas.iterator();
        while (iterator2.hasNext()){ //enquanto tiver próximo elemento
            Double next = iterator2.next();
            notas2.add(next);
        }
        System.out.println("Elementos da lista nota2 com a implementação LinkedList: " + notas2);

        System.out.println("Mostre a primeira nota da nova lista sem removê-lo: " + notas2.get(0));
        System.out.println("Mostre a primeira nota da nova lista removendo-o: " + notas2.remove(0));
        System.out.println("Lista com a primeira posição removida: " + notas2);

    }
}
