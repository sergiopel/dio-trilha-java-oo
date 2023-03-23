package one.digitalinnovation.collection.map.exercicio1;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

/*
Dada a população estimada de alguns Estados do NE brasileiro, faça:
Estado = PE - População = 9.616.621
Estado = AL - População = 3.351.543
Estado = CE - População = 9.187.103
Estado = RN - População = 3.534.265

- Crie um dicionário e relacione os Estados e suas populações;
- Substitua a população do Estado do RN por 3.534.165;
- Confira se o Estado PB está no dicionário, caso não adicione:
 PB - 4.039.277;
- Exiba a população PE;
- Exiba todos os Estados e suas populações na ordem que foi informado;
- Exiba os Estados e suas populações em ordem alfabética;
- Exiba o Estado com a menor população e sua quantidade;
- Exiba o Estado com a maiorr população e sua quantidade;
- Exiba a soma da população nesses Estados;
- Exiba a média da população deste dicionário de Estados;
- Remova os Estados com a população menor que 4.000.000;
- Apague o dicionário de Estados;
- Confira se o dicionário está vazio.

 */
public class ExercicioPropostoUm {
    public static void main(String[] args) {
        //chave e valor
        System.out.println("Crie um dicionário e relacione os Estados e suas populações: ");
        Map<String, Integer> populacaoEstados = new HashMap<>(){{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
        }};
        for (Map.Entry<String, Integer> populacao: populacaoEstados.entrySet()) {
            System.out.println(populacao);
        }

        System.out.println();
        System.out.println("Substitua a população do Estado do RN por 3.534.165: ");
        populacaoEstados.put("RN", 3534165);
        System.out.println(populacaoEstados);

        System.out.println();
        System.out.println("Confira se o Estado PB está no dicionário, caso não, adicione: PB - 4.039.277: ");
        if(!populacaoEstados.containsKey("PB")) populacaoEstados.put("PB", 4039277);
        System.out.println(populacaoEstados);

        System.out.println();
        System.out.println("Exiba a população de PE: " + populacaoEstados.get("PE"));

        System.out.println();
        System.out.println("Exiba todos os Estados e suas populações na ordem que foi informado: ");
        Map<String, Integer> populacaoEstados2 = new LinkedHashMap<>(){{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
        }};
        System.out.println(populacaoEstados2);

        System.out.println();
        System.out.println("Exiba os Estados e suas populações em ordem alfabética: ");
        Map<String, Integer> populacaoEstados3 = new TreeMap<>(populacaoEstados2);
        System.out.println(populacaoEstados3);

        System.out.println();
        System.out.println("Exiba o Estado com a menor população e sua quantidade: ");
        Integer menorPopulacao = Collections.min(populacaoEstados.values());
        for (Map.Entry<String, Integer> populacao: populacaoEstados.entrySet()) {
            if(populacao.getValue().equals(menorPopulacao)){
                System.out.println(populacao);
            }
        }


        System.out.println();
        System.out.println("Exiba o Estado com a maior população e sua quantidade: ");
        Integer maiorPopulacao = Collections.max(populacaoEstados.values());
        for (Map.Entry<String, Integer> populacao: populacaoEstados.entrySet()) {
            if(populacao.getValue().equals(maiorPopulacao)){
                System.out.println(populacao);
            }
        }


        // Soma da população de todos os Estados
        System.out.println();
        Set<Map.Entry<String, Integer>> entries = populacaoEstados.entrySet();
        Integer somaPopulacao = 0;
        for(Map.Entry<String, Integer> populacao2: entries){
            somaPopulacao += populacao2.getValue();
        }
        System.out.println("Exiba a soma da população desses Estados: " + somaPopulacao);


        System.out.println();
        System.out.println("Exiba a média da população deste dicionário de Estados: " +
                (somaPopulacao / populacaoEstados.size()));


        System.out.println();
        System.out.println("Remova os Estados com a população menor que 4.000.000");
        Iterator<Integer> iterator = populacaoEstados.values().iterator();
        while(iterator.hasNext()){
            Integer next = iterator.next();
            if(next < 4000000) iterator.remove();
        }
        System.out.println(populacaoEstados);

        System.out.println();
        System.out.println("Apague o dicionário: ");
        populacaoEstados.clear();
        System.out.println(populacaoEstados);
        System.out.println("Está vazio? " + populacaoEstados.isEmpty());
    }
}
