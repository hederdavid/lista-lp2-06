package questao03;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> nomes = new ArrayList<>();
        List<String> sobrenomes = new ArrayList<>();
        List<String> nomeCompleto = new ArrayList<>();
        int qtdPessoas = 0;

        System.out.print("Quantas pessoas você quer gerar?: ");
        qtdPessoas = scanner.nextInt();

        try {
            FileReader fileReaderNomes = new FileReader("src/questao03/nomes.txt");
            FileReader fileReaderSobrenomes = new FileReader("src/questao03/sobrenomes.txt");

            scanner = new Scanner(fileReaderNomes);
            while (scanner.hasNext()) {
                nomes.add(scanner.nextLine());
            }

            scanner = new Scanner(fileReaderSobrenomes);
            while (scanner.hasNext()) {
                sobrenomes.add(scanner.nextLine());
            }

            Random random = new Random();
            for (int i = 0; i < qtdPessoas; i++) {
                nomeCompleto.add("Nome: " + nomes.get(random.nextInt(nomes.size())) + " " +
                        sobrenomes.get(random.nextInt(sobrenomes.size()))  + " Idade: " + (random.nextInt(100) + 1));
            }

            scanner.close();
            fileReaderNomes.close();
            fileReaderSobrenomes.close();

            nomeCompleto.forEach(System.out::println);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
}
