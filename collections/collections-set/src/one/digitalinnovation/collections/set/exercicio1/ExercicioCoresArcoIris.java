package one.digitalinnovation.collections.set.exercicio1;

import java.util.*;

public class ExercicioCoresArcoIris {
    public static void main(String[] args) {
        Set<String> cores = new HashSet<>(Arrays.asList(
                "vermelho", "laranja", "amarelo", "verde", "azul",
                "anil", "violeta"
        ));
        System.out.println("--\tImprimir todas as cores, uma abaixo da outra\t--");
        for (String cor: cores) {
            System.out.println(cor);
        }

        System.out.println("--\tQuantidade de cores: " + cores.size());

        System.out.println("--\tCores em ordem alfabética\t--");
        Set<String> coresOrdemAlfabetica = new TreeSet<>(cores);
        for (String cor: coresOrdemAlfabetica) {
            System.out.println(cor);
        }


        System.out.println("--\tExiba as cores na ordem inversa das que foram informadas:\t--");
        Set<String> cores2 = new LinkedHashSet<>(
                Arrays.asList("vermelho", "laranja", "amarelo", "verde", "azul",
                        "anil", "violeta")
        );
        List<String> cores3 = new ArrayList<>(cores2);
        Collections.reverse(cores3);
        System.out.println(cores3);


        System.out.println("--\tExibir todas as cores que começam com a letra 'v'\t--");
        /*
        Iterator<String> iterator = cores.iterator();
        while(iterator.hasNext()){
            String next = iterator.next();
            if(next.startsWith("v")) {
                System.out.println(next);
            }
        }
        */
        for (String cor: cores) {
            if(cor.startsWith("v")) System.out.println(cor);
        }

        System.out.println("--\tRemova todas as cores que não começam com a letra 'v': ");
        Iterator<String> iterator = cores.iterator();
        while(iterator.hasNext()){
            String next = iterator.next();
            if(!next.startsWith("v")) {
                iterator.remove();
            }
        }
        System.out.println(cores);


        System.out.println("Limpe o conjunto: ");
        cores.clear();

        System.out.println("Confira de o conjunto está vazio: " + cores.isEmpty());

    }
}
