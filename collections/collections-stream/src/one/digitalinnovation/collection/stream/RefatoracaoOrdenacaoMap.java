package one.digitalinnovation.collection.stream;

import java.util.*;
import java.util.function.Function;

public class RefatoracaoOrdenacaoMap
{
    public static void main(String[] args) {
        // Criei classe Contato
        System.out.println("--\tOrdem aleatória\t--");
        // Lembrando que o Map usa chave e valor
        Map<Integer, Contato> meusContatos = new HashMap<>(){{
            put(1, new Contato("Simba", 2222));
            put(4, new Contato("Cami", 5555));
            put(3, new Contato("Jon", 1111));
        }};
        System.out.println(meusContatos );
        //Para manipular os elementos separadamente eu preciso usar o método entrySet
        Set<Map.Entry<Integer, Contato>> entries = meusContatos.entrySet();
        for (Map.Entry<Integer, Contato> contato1: entries) {
            System.out.println("Id: " + contato1.getKey() + " - " + "Nome: " + contato1.getValue().getContato());
        }

        System.out.println("--\tOrdem Inserção\t--");
        Map<Integer, Contato> meusContatos2 = new LinkedHashMap<>(){{
            put(1, new Contato("Simba", 2222));
            put(4, new Contato("Cami", 5555));
            put(3, new Contato("Jon", 1111));
        }};
        System.out.println(meusContatos2);
        //Para manipular os elementos separadamente eu preciso usar o método entrySet
        for (Map.Entry<Integer, Contato> contato1: meusContatos2.entrySet()) {
            System.out.println("Id: " + contato1.getKey() + " - " + "Nome: " + contato1.getValue().getContato());
        }


        System.out.println("--\tOrdem id\t--");
        // id é a chave então para ordenar por ordem de chave é só usar o TreeMap,
        // que já organiza como default de acordo com a chave
        Map<Integer, Contato> meusContatos3 = new TreeMap<>(){{
            put(1, new Contato("Simba", 2222));
            put(4, new Contato("Cami", 5555));
            put(3, new Contato("Jon", 1111));
        }};
        System.out.println(meusContatos3);
        for (Map.Entry<Integer, Contato> contato1: meusContatos3.entrySet()) {
            System.out.println("Id: " + contato1.getKey() + " - " + "Nome: " + contato1.getValue().getContato());
        }


/*
        System.out.println("--\tOrdem número telefone\t--");
        // Precisar usar TreeSet, que retorna Set e Map.Entry, enviando o objeto da classe a criar,
        // que implementa o Comparator
        Set<Map.Entry<Integer, Contato>> meusContatos4 = new TreeSet<>(new ComparatorNumeroTelefone());
        meusContatos4.addAll(meusContatos.entrySet());
        System.out.println(meusContatos4);
        for (Map.Entry <Integer, Contato> contato1: meusContatos4){
            System.out.println("Id: " + contato1.getKey() + " - " + "Nome: " + contato1.getValue().getContato()
                    + " - " + contato1.getValue().getTelefone());
        }
*/

        System.out.println("--\tOrdem número telefone\t--");
        // Refatorando 1
        // Usando classe anônima, cujo objetivo é passar a classe que havia antes para executar
        // aqui mesmo
/*
        Set<Map.Entry<Integer, Contato>> meusContatos4 = new TreeSet<>(new Comparator<Map.Entry<Integer, Contato>>() {
            @Override
            public int compare(Map.Entry<Integer, Contato> c1, Map.Entry<Integer, Contato> c2) {
                return Integer.compare(c1.getValue().getTelefone(), c2.getValue().getTelefone());
            }
        });

*/
        // Refatorando 2
        // Também dá pra fazer dessa outra forma usando o método static comparing do Comparator
        // O método comparing permite fazer comparações passando uma interace funcional, que
        // aqui no caso é a Function
/*
        Set<Map.Entry<Integer, Contato>> meusContatos4 = new TreeSet<>(Comparator.comparing(
                new Function<Map.Entry<Integer, Contato>, Integer>() {
                    @Override
                    public Integer apply(Map.Entry<Integer, Contato> cont) {
                        return cont.getValue().getTelefone();
                    }
                }));
*/



        //Refatorando 3
        // Dá para simplificar ainda mais usando o LAMBDA: ( argumento -> corpo )
        Set<Map.Entry<Integer, Contato>> meusContatos4 = new TreeSet<>(Comparator.comparing(
                cont -> cont.getValue().getTelefone()));

        meusContatos4.addAll(meusContatos.entrySet());
        System.out.println(meusContatos4);
        for (Map.Entry <Integer, Contato> contato1: meusContatos4){
            System.out.println("Id: " + contato1.getKey() + " - " + "Nome: " + contato1.getValue().getContato()
                    + " - " + contato1.getValue().getTelefone());
        }




        System.out.println("--\tOrdem nome contato\t--");
//        Set<Map.Entry<Integer, Contato>> meusContatos5 = new TreeSet<>(new ComparatorNome());

        //Refatorando 1 - classe anônima
/*
        Set<Map.Entry<Integer, Contato>> meusContatos5 = new TreeSet<>(new Comparator<Map.Entry<Integer, Contato>>() {
            @Override
            public int compare(Map.Entry<Integer, Contato> c1, Map.Entry<Integer, Contato> c2) {
                return c1.getValue().getContato().compareTo(c2.getValue().getContato());
            }
        });
*/

        // Refatorando 2 - usando o comparing
/*
        Set<Map.Entry<Integer, Contato>> meusContatos5 = new TreeSet<>(Comparator.comparing(
                // nesse new, após a vírgula é o retorno, é o tipo que eu quero comparar
                new Function<Map.Entry<Integer, Contato>, String>() {
                    @Override
                    public String apply(Map.Entry<Integer, Contato> cont) {
                        return cont.getValue().getContato();
                    }
                }));
*/

        //Refatorando 3 - usando o Lambda
        Set<Map.Entry<Integer, Contato>> meusContatos5 = new TreeSet<>(Comparator.comparing(
                cont -> cont.getValue().getContato()));

        meusContatos5.addAll(meusContatos.entrySet());
        System.out.println(meusContatos5);
        for (Map.Entry <Integer, Contato> contato1: meusContatos5){
            System.out.println("Id: " + contato1.getKey() + " - " + "Nome: " + contato1.getValue().getContato()
                    + " - " + contato1.getValue().getTelefone());
        }
    }
}

/*
class ComparatorNumeroTelefone implements Comparator<Map.Entry<Integer, Contato>> {
    @Override
    public int compare(Map.Entry<Integer, Contato> c1, Map.Entry<Integer, Contato> c2) {
        //return c1.getValue().getTelefone().compareTo(c2.getValue().getTelefone());
        // como é uma comparação numérica posso fazer dessa maneira:
        return Integer.compare(c1.getValue().getTelefone(), c2.getValue().getTelefone());
    }
}
*/

/*
class ComparatorNome implements Comparator<Map.Entry<Integer, Contato>> {
    @Override
    public int compare(Map.Entry<Integer, Contato> c1, Map.Entry<Integer, Contato> c2) {
        return c1.getValue().getContato().compareTo(c2.getValue().getContato());
    }
}
*/

