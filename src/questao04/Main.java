package questao04;

import java.io.FileReader;
import java.io.FileWriter;
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
        List<String> nomesCompletos = new ArrayList<>();
        int qtdPessoas = 0;

        System.out.print("Quantas pessoas você quer gerar?: ");
        qtdPessoas = scanner.nextInt();

        try {
            FileReader fileReaderNomes = new FileReader("src/questao04/nomes.txt");
            FileReader fileReaderSobrenomes = new FileReader("src/questao04/sobrenomes.txt");

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
                nomesCompletos.add("Nome: " + nomes.get(random.nextInt(nomes.size())) + " " +
                        sobrenomes.get(random.nextInt(sobrenomes.size()))  + ",Idade: " + (random.nextInt(100) + 1));
            }

            scanner.close();
            fileReaderNomes.close();
            fileReaderSobrenomes.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (int i = 1; i < nomesCompletos.size(); i++) {
            String nomeTemp = nomesCompletos.get(i); // enésimo nome
            int j = i - 1; // índice de nome anterior ao enésimo nome em comparação
            /* realocação de nomes anteriores para índices imediatamente subsequentes
             * até que seja encontrado nome em ordem alfabética anterior ao enésimo nome */
            while (j >= 0 && nomesCompletos.get(j).compareTo(nomeTemp) > 0) {
                nomesCompletos.set(j + 1, nomesCompletos.get(j));
                j--;
            }
            /* atribuição de enésimo nome em índice de acordo com sua posição em relação aos
             * nomes anteriores comparados */
            nomesCompletos.set(j + 1, nomeTemp);
        }
        for (String nomesCompleto : nomesCompletos) {
            // listagem de nomes
            System.out.println(nomesCompleto);
        }

        try {
            FileWriter fileWriter = new FileWriter("src/questao04/nomesCompletos.txt");
            for (String nome : nomesCompletos) {
                fileWriter.write(nome + "\n");
            }
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }




    }
}
