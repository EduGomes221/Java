package Aula02;
import java.util.Scanner;

public class q03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double soma = 0;
        int quantidade = 0;
        char opcao;

        System.out.println("Bem-vindo ao calculador de média do aluno!");

        do {
            System.out.print("Insira uma nota do aluno: ");
            double nota = scanner.nextDouble();

            soma += nota;
            quantidade++;

            System.out.print("Deseja inserir outra nota? (Digite 'S' para Sim ou 'N' para Não): ");
            opcao = scanner.next().toUpperCase().charAt(0);

        } while (opcao == 'S');

        double media = soma / quantidade;

        System.out.printf("\nMédia das notas: %.2f\n", media);
        System.out.println("Obrigado por usar o programa!");

        scanner.close();
    }
}