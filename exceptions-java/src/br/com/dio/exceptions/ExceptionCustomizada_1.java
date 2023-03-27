package br.com.dio.exceptions;

import javax.swing.*;
import java.io.*;

//Imprimir um arquivo no console.
public class ExceptionCustomizada_1 {
    public static void main(String[] args) {
        String nomeDoArquivo = JOptionPane.showInputDialog("Nome do arquivo a ser exibido: ");
        //                "romances-blake-crouch.txt";
        imprimirArquivoNoConsole(nomeDoArquivo);
        System.out.println("\nCom exception ou não, o programa cotinua...");
    }

    public static void imprimirArquivoNoConsole(String nomeDoArquivo) {
        try {
            BufferedReader br = lerArquivo(nomeDoArquivo);
            String line = br.readLine();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            do{
                bw.write(line);
                bw.newLine();
                line=br.readLine();
            } while (line != null);
            bw.flush();
            bw.close();
        } catch (ImpossivelAberturaDeArquivoException e) {
            //throw new RuntimeException(e);
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,
                    "Ocorreu um erro não esperado, por favor, fale com o suporte." + ex.getMessage());
            ex.printStackTrace();
        }

    }

    public static BufferedReader lerArquivo(String nomeDoArquivo) throws ImpossivelAberturaDeArquivoException {
        File file = new File(nomeDoArquivo);
        try {
            return new BufferedReader(new FileReader(nomeDoArquivo));
        } catch (FileNotFoundException e) {
            throw new ImpossivelAberturaDeArquivoException(file.getName(), file.getPath());
        }
    }
}

class ImpossivelAberturaDeArquivoException extends Exception {
    private String nomeDoArquivo;
    private String diretorioArquivo;

    public ImpossivelAberturaDeArquivoException(String nomeDoArquivo, String diretorioArquivo) {
        super("O arquivo " + nomeDoArquivo + " não foi encontrado no diretório " + diretorioArquivo);
        this.nomeDoArquivo = nomeDoArquivo;
        this.diretorioArquivo = diretorioArquivo;
    }

    @Override
    public String toString() {
        return "ImpossivelAberturaDeArquivoException{" +
                "nomeDoArquivo='" + nomeDoArquivo + '\'' +
                ", diretorioArquivo='" + diretorioArquivo + '\'' +
                '}';
    }
}