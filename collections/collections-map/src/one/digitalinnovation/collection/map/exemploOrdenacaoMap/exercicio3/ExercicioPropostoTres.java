package one.digitalinnovation.collection.map.exemploOrdenacaoMap.exercicio3;

import com.sun.source.tree.Tree;

import java.util.*;

/*Dadas as seguintes informações  de id e contato, crie um dicionário e
ordene este dicionário exibindo (Nome id - Nome contato);
id = 1 - Contato = nome: Simba, numero: 2222;
id = 4 - Contato = nome: Cami, numero: 5555;
id = 3 - Contato = nome: Jon, numero: 1111;
*/
public class ExercicioPropostoTres {
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
        // id é a chave então para ordenar por ordem de chave é só usar o TreeMap
        Map<Integer, Contato> meusContatos3 = new TreeMap<>(){{
            put(1, new Contato("Simba", 2222));
            put(4, new Contato("Cami", 5555));
            put(3, new Contato("Jon", 1111));
        }};
        System.out.println(meusContatos3);
        for (Map.Entry<Integer, Contato> contato1: meusContatos3.entrySet()) {
            System.out.println("Id: " + contato1.getKey() + " - " + "Nome: " + contato1.getValue().getContato());
        }


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

        System.out.println("--\tOrdem nome contato\t--");
        Set<Map.Entry<Integer, Contato>> meusContatos5 = new TreeSet<>(new ComparatorNome());
        meusContatos5.addAll(meusContatos.entrySet());
        System.out.println(meusContatos5);
        for (Map.Entry <Integer, Contato> contato1: meusContatos5){
            System.out.println("Id: " + contato1.getKey() + " - " + "Nome: " + contato1.getValue().getContato()
                    + " - " + contato1.getValue().getTelefone());
        }

    }
}

class ComparatorNumeroTelefone implements Comparator<Map.Entry<Integer, Contato>> {
    @Override
    public int compare(Map.Entry<Integer, Contato> c1, Map.Entry<Integer, Contato> c2) {
        return c1.getValue().getTelefone().compareTo(c2.getValue().getTelefone());
    }
}

class ComparatorNome implements Comparator<Map.Entry<Integer, Contato>> {
    @Override
    public int compare(Map.Entry<Integer, Contato> c1, Map.Entry<Integer, Contato> c2) {
        return c1.getValue().getContato().compareTo(c2.getValue().getContato());
    }
}