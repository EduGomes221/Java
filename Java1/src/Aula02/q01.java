package Aula02;
import java.util.Scanner;

public class q01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continuar;

        System.out.println("=".repeat(40));
        System.out.println("SISTEMA DE CADASTRO DE PESSOAS");
        System.out.println("=".repeat(40));

        do {
            System.out.print("Digite o nome da pessoa: ");
            String nome = scanner.nextLine();

            System.out.print("Digite a idade da pessoa: ");
            int idade = scanner.nextInt();
            scanner.nextLine();

            System.out.println("\n" + "-".repeat(40));
            System.out.println("DADOS CADASTRADOS:");
            System.out.println("-".repeat(40));
            System.out.println("Nome: " + nome);
            System.out.println("Idade: " + idade + " anos");

            if (idade < 13) {
                System.out.println("Classificação: CRIANÇA");
            } else if (idade < 18) {
                System.out.println("Classificação: ADOLESCENTE");
            } else if (idade < 60) {
                System.out.println("Classificação: ADULTO");
            } else {
                System.out.println("Classificação: IDOSO");
            }
            System.out.println("-".repeat(40));

            do {
                System.out.print("\nDeseja cadastrar outra pessoa? (S/N): ");
                continuar = scanner.nextLine().trim();
            } while (!continuar.equalsIgnoreCase("S") &&
                    !continuar.equalsIgnoreCase("N"));

            System.out.println(); // Linha em branco

        } while (continuar.equalsIgnoreCase("S"));

        System.out.println("=".repeat(40));
        System.out.println("CADASTRO FINALIZADO! Obrigado!");
        System.out.println("=".repeat(40));

        scanner.close();
    }
}