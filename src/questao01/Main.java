package questao01;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String caminhoArquivo = "src/questao01/numeros.txt";
        int soma = 0, cont = 0;

        try {
            FileReader fileReader = new FileReader(caminhoArquivo);
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNext()) {
                soma += Integer.parseInt(scanner.nextLine());
                cont++;
            }
            scanner.close();
            fileReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Média: " + (double) soma/cont);
    }
}
