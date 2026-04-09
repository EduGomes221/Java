package Aula03;
import java.util.Scanner;

public class q02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome do aluno: ");
        String nome = scanner.nextLine();

        System.out.print("Nota 1: ");
        double nota1 = scanner.nextDouble();
        System.out.print("Nota 2: ");
        double nota2 = scanner.nextDouble();
        System.out.print("Nota 3: ");
        double nota3 = scanner.nextDouble();

        double media = (nota1 + nota2 + nota3) / 3.0;

        System.out.println("\n=== SITUAÇÃO ACADÊMICA ===");
        System.out.println("Aluno: " + nome);
        System.out.printf("Média: %.1f%n", media);

        if (media >= 70) {
            System.out.println("SITUAÇÃO: APROVADO ✅");
        } else if (media < 40) {
            System.out.println("SITUAÇÃO: REPROVADO ❌");
        } else {
            System.out.println("SITUAÇÃO: NA FINAL ⚠️");
        }

        scanner.close();
    }
}