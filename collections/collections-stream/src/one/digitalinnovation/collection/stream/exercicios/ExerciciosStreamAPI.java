package one.digitalinnovation.collection.stream.exercicios;

import javax.management.MBeanAttributeInfo;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;

public class ExerciciosStreamAPI {
    public static void main(String[] args) {
        List<String> numerosAleatorios =
                Arrays.asList("1", "0", "4", "1", "2", "3", "9", "9", "6", "5");

        System.out.println("Imprima todos os elementos dessa lista de String: ");

/*
        // forEach é a operação final
        numerosAleatorios.stream().forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
*/

        // Transformando o código acima em LAMBDA para simplificar:
        //numerosAleatorios.stream().forEach(s -> System.out.println(s));
        // O próprio List tem o forEach, sem precisa usar o stream:
        //numerosAleatorios.forEach(s -> System.out.println(s));
        //Depois a ide informa que o Lambda pode ser substituído por method reference:
        numerosAleatorios.forEach(System.out::println);

        System.out.println("--------------------------------------------------");
        System.out.println("Pegue os 5 primeiros números e coloque dentro de um Set: ");
        numerosAleatorios.stream()
                .limit(5)
                .collect(Collectors.toSet())
                .forEach(System.out::println);
        // o Set não pega repetido, por isso só imprimiu 4 elementos, pois o 1 repetia


        System.out.println("--------------------------------------------------");
        System.out.println("Transforme esta lista de String em uma lista de números inteiros: ");
        // o map abaixo não tem nada a ver com o Map do Collection
        List<Integer> collectList = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        //.forEach(System.out::println);


        System.out.println("--------------------------------------------------");
        System.out.println("Pegue os números pares e maiores que 2 e coloque em uma lista: ");
/*
        List<Integer> listParesMaioresQue2 = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer i) {
                        if (i % 2 == 0 && i > 2) return true;
                        return false;
                    }
                }).collect(Collectors.toList());
        System.out.println(listParesMaioresQue2);
*/

        // Refatorando o código acima usando LAMBDA:
        List<Integer> listParesMaioresQue2 = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter(i -> (i % 2 == 0 && i > 2))
                .collect(Collectors.toList());
        System.out.println(listParesMaioresQue2);


        System.out.println("--------------------------------------------------");
        System.out.println("Mostre a média dos números: ");
        /*numerosAleatorios.stream().mapToInt(new ToIntFunction<String>() {
            @Override
            public int applyAsInt(String s) {
                return Integer.parseInt(s);
            }
        });*/
        // Refatorando para LAMBDA:
        //numerosAleatorios.stream()
        // .mapToInt(s -> Integer.parseInt(s));
        // Refatorando para Reference Method:
        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .average() // vai tentar fazer a média
                /*.ifPresent(new DoubleConsumer() {  // se a média existir, retorna
                    @Override
                    public void accept(double v) {
                        System.out.println(v);
                    }
                });*/

                //Refatorando para Lambda
                //.ifPresent(v -> System.out.println(v));
                // Refatorando para Reference Method
                .ifPresent(System.out::println);


        System.out.println("--------------------------------------------------");
        System.out.println("Remova os valores ímpares: ");
        // Stream não modifica a nossa fonte
        // Para remover eu tenho que trabalhar com a lista de Integer
        // Tenho então que transformar de stream para Integer
        List<Integer> numerosAleatoriosInteger = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
/*
        numerosAleatoriosInteger.removeIf(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if (integer %2 !=0) return true;
                return false;
            }
        });
*/

        // Refatorando
        numerosAleatoriosInteger.removeIf(integer -> integer %2 !=0);
        System.out.println(numerosAleatoriosInteger);



    }
}
