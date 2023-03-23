package one.digitalinnovation.collection.map;

import java.util.*;

public class ExemploMap {
    public static void main(String[] args) {
/*
Dado os modelos dos carros e seus respectivos consumos na estrada, faça:
modelo = gol - consumo = 14,4km/l
modelo = uno - consumo = 15,6km/l
modelo = mobi - consumo = 16,1km/l
modelo = hb20 - consumo - 14,5km/l
modelo = kwid - consumo - 15,6km/l

 */

// Algumas formas de iniciar um Map:
    //Map carrosPopulares2020 = new HashMap(); // antes do java5
    //Map<String, Double> carrosPopulares1 = new HashMap<>();
    //HashMap<String, Double> carrosPopulares2 = new HashMap<>();
    //Map<String, Double> carrosPopulares2020 = Map.of("gol", 14.4, "uno", 15.6,
    //        "mobi", 16.1, "hb20", 14.5, "kwid", 15.6);

        System.out.println("Crie um dicionário que relacione os modelos e seus respectivos consumos: ");
        // com o HasMap, a ordem da inserção não necessariamente será a ordem impressa abaixo
        Map<String, Double> carrosPopulares = new HashMap<>(){{ //chave = modelo, valor = consumo
            put("gol", 14.4); //no Map não tem o método add, no lugar dele utilizar o put
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println(carrosPopulares);

        System.out.println("Substitua o consumo do gol por 15,2 km/l: ");
        carrosPopulares.put("gol", 15.2);
        System.out.println(carrosPopulares);

        System.out.println("Confira se o modelo tucson está no dicionário: " +  carrosPopulares.containsKey("tucson"));

        System.out.println("Confira se o modelo mobi está no dicionário: " +  carrosPopulares.containsKey("mobi"));

        System.out.println("Exiba o consumo do uno: " + carrosPopulares.get("uno")); // aqui passou a chave e retorna o valor

        //System.out.println("Exiba o terceiro modelo adicionado: ");
        // não tem esse método

        System.out.println("Exiba os modelos: ");
        Set<String> modelos = carrosPopulares.keySet();  //método keySet retorna um Set
        System.out.println(modelos);

        //o método values retorna ua Collection
        System.out.println("Exiba os consumos dos carros: ");
        Collection<Double> consumos = carrosPopulares.values();
        System.out.println(consumos);

        System.out.println("Exiba o modelo mais econômico e seu consumo: ");
        // seguindo o exemplo acima, preciso pegar os valores, utilizando o método values,
        // que retorna um Collections, aí uso o método max para pegar o valor maior
        Double consumoMaisEficiente = Collections.max(carrosPopulares.values());
        // método entrySet é um método especial, ela retorna um Set e os elementos desse Set
        // é do tipo Entry, com uma string e um double
        Set<Map.Entry<String, Double>> entries = carrosPopulares.entrySet();
        String modeloMaisEficiente = "";
        for (Map.Entry<String, Double> entry: entries) {
            if(entry.getValue().equals(consumoMaisEficiente)) {
                modeloMaisEficiente = entry.getKey();
                System.out.println("Modelo mais eficiente: " + modeloMaisEficiente + " - " + consumoMaisEficiente);
            }
        }

        System.out.println("Exiba o modelo menos econômico e seu consumo: ");
        Double consumoMenosEficiente = Collections.min(carrosPopulares.values());
        Set<Map.Entry<String, Double>> entries2 = carrosPopulares.entrySet();
        String modeloMenosEficiente = "";
        for (Map.Entry<String, Double> entry: entries2) {
            if(entry.getValue().equals(consumoMenosEficiente)) {
                modeloMenosEficiente = entry.getKey();
                System.out.println("Modelo menos eficiente: " + modeloMenosEficiente + " - " + consumoMenosEficiente);
            }
        }

        // Exibir a soma dos consumos:
        // usar iterator, consigo usá-lo pq o retorno é um collection
        Iterator<Double> iterator = carrosPopulares.values().iterator();
        Double soma = 0d;
        while(iterator.hasNext()){
            soma += iterator.next();
        }
        System.out.println("Exiba a soma dos consumos: " + soma);


        System.out.println("Exiba a média dos consumos deste dicionário de carros: " +
                (soma / carrosPopulares.size()));


        System.out.println("Remova os modelos com o consumo igual a 15,6 km/l: ");
        System.out.println(carrosPopulares);
        Iterator<Double> iterator1 = carrosPopulares.values().iterator();
        while(iterator1.hasNext()){
            if(iterator1.next().equals(15.6)) iterator1.remove();
        }
        System.out.println(carrosPopulares);


        System.out.println("Exiba todos os carros na ordem em que foram informados: ");
        // utilizar o LinkedHashMap que respeita a ordem da inserção
        Map<String, Double> carrosPopulares2 = new LinkedHashMap<>(){{
            put("gol", 14.4);
            put("uno", 15.6);
            put("mobi", 16.1);
            put("hb20", 14.5);
            put("kwid", 15.6);
        }};
        System.out.println(carrosPopulares2);

        System.out.println("Exiba o dicionário ordenado pelo modelo");
        // modelo é a chave e quem ordena a chave é o TreeMap
        Map<String, Double> carrosPopulares3 = new TreeMap<>(carrosPopulares2);
        System.out.println(carrosPopulares3.toString());


        System.out.println("Apague o dicionário de carros: ");
        carrosPopulares.clear();
        System.out.println(carrosPopulares);


        System.out.println("Confirma se o dicionário está vazio: " + carrosPopulares.isEmpty());
    }
}
