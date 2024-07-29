package questao06;

import questao05.Pessoa;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Pessoa> pessoas;
        int soma = 0;

        try {
            FileInputStream fileInputStream = new FileInputStream("src/questao05/pessoas.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            pessoas = (List<Pessoa>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        for (Pessoa pessoa : pessoas) {
            soma += pessoa.getIdade();

        }

        System.out.println("Média: " + (double) soma / pessoas.size());

    }
}
