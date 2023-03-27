package br.com.dio.debugging;

import java.util.Scanner;

public class CalculadoraDeMedias {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] alunos = {"Sergio", "João", "Fabio", "Thiago"};

        double media = calculadoraMediaDaTurma(alunos, scan);

        System.out.printf("Média da turma %.1f", media);
    }

    public static double calculadoraMediaDaTurma(String[] alunos, Scanner scanner){
        double soma = 0;
        for (String aluno: alunos) {
            System.out.printf("Nota do aluno %s: ", aluno);
            double nota = scanner.nextInt();
            soma += nota;
        }

        return soma / alunos.length;
    }
}
