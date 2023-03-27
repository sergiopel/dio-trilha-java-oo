package br.com.dio.exceptions;

import javax.swing.*;

// Fazer a divisão de 2 valores inteiros
public class UncheckedExceptions {
    public static void main(String[] args) {

        boolean continueLooping = true;
        do{
            try{
                String a = JOptionPane.showInputDialog("Numerador: ");
                String b = JOptionPane.showInputDialog("Denominador: ");

                // só executa essa lógica se não cair na exception
                int resultado = dividir(Integer.parseInt(a), Integer.parseInt(b));
                System.out.println("Resultado: " + resultado);
                continueLooping = false;
            } catch (NumberFormatException e) {
                e.printStackTrace(); // aqui ainda imprime o erro para análise do programador
                // o e.getMessage() traz um erro em inglês que normalmente não deve ser levado ao usuário
                JOptionPane.showMessageDialog(null,
                        "Entrada inválida, informe um número inteiro! " + e.getMessage());
                //throw new RuntimeException(e);
            } catch (ArithmeticException e){
                JOptionPane.showMessageDialog(null,
                        "Impossível dividir um número por 0. ");
            }
            finally {
                System.out.println("Chegou no finally"); // aqui sempre executa dando erro ou não
            }
        } while (continueLooping);

        System.out.println("O código continua...");
    }

    public static int dividir(int a, int b) { return a / b; }
}
