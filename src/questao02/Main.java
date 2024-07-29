package questao02;

import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String caminhoArquivo = "src/questao02/numeros.txt";
        Scanner scanner = new Scanner(System.in);
        double soma = 0, cont = 0;
        int qtdNumeros = 0;

        System.out.print("Digite a quantidade de número a ser lidos: ");
        qtdNumeros = scanner.nextInt();


        try {
            FileReader fileReader = new FileReader(caminhoArquivo);
            scanner = new Scanner(fileReader);

            try {
                for (int i = 0; i < qtdNumeros; i++) {
                    soma += scanner.nextInt();
                    cont++;
                }
                System.out.println("Média: " + soma/cont);
            } catch (NoSuchElementException e) {
                System.out.println("Linhas insuficientes!");
            }

            scanner.close();
            fileReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
