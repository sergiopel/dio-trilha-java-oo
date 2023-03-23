package one.digitalinnovation.collection.map.exercicio1;

import java.util.HashMap;
import java.util.Map;

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
        Map<String, Integer> populacaoEstados = new HashMap<>(){{
            put("PE", 9616621);
            put("AL", 3351543);
            put("CE", 9187103);
            put("RN", 3534265);
        }};
        /*
        for (Map<String, Integer> populacao: populacaoEstados) {
            System.out.println(populacao);
        }
        */

        
        

    }
}
