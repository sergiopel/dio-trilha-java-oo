package one.digitalinnovation.collection.list.exercicio1;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ExercicioPropostoList1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Double> meses = new ArrayList<>();

        System.out.println("Entre com a temperatura média dos 6 primeiros meses do ano: ");

        for (int i = 1; i <= 6; i++) {
            System.out.println("Mês " + i );
            Double mes = scan.nextDouble();
            meses.add(mes);
        }

        System.out.println(meses);

        Iterator<Double> iterator = meses.iterator();
        Double soma = 0d;
        Double media = 0d;
        while(iterator.hasNext()){
            Double next = iterator.next();
            soma += next;
        }
        media = soma / meses.size();
        System.out.println("A média semestral das temperatura foi: " + media);


        System.out.println("As temperaturas acima da média semestral foram: ");
        Iterator<Double> iterator2 = meses.iterator();
        while(iterator2.hasNext()){
            Double next = iterator2.next();
            String nomeDoMes = "";
            if(next > media){
                int indice = 0;
                indice = meses.indexOf(next);
                switch (indice){
                    case 0:
                        nomeDoMes = "Janeiro";
                        break;
                    case 1:
                        nomeDoMes = "Fevereiro";
                        break;
                    case 2:
                        nomeDoMes = "Março";
                        break;
                    case 3:
                        nomeDoMes = "Abril";
                        break;
                    case 4:
                        nomeDoMes = "Maio";
                        break;
                    case 5:
                        nomeDoMes = "Junho";
                        break;
                    default:
                        System.out.println("Mês inválido!");
                }
                System.out.println(next + " - " + (indice + 1) + " - " + nomeDoMes);
            }
        }



    }


}
