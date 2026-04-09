package Aula01;
import java.util.Scanner;

public class q03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a 1ª nota: ");
        double nota1 = scanner.nextDouble();

        System.out.print("Digite a 2ª nota: ");
        double nota2 = scanner.nextDouble();

        System.out.print("Digite a 3ª nota: ");
        double nota3 = scanner.nextDouble();

        double media = (nota1 + nota2 + nota3) / 3.0;

        System.out.println("\n" + "=".repeat(40));
        System.out.println("RELATÓRIO DO ALUNO");
        System.out.println("=".repeat(40));
        System.out.printf("Nota 1: %.1f%n", nota1);
        System.out.printf("Nota 2: %.1f%n", nota2);
        System.out.printf("Nota 3: %.1f%n", nota3);
        System.out.printf("MÉDIA: %.1f%n", media);
        System.out.println("-".repeat(40));

        if (media >= 70.0) {
            System.out.println(" SITUAÇÃO: APROVADO");
        } else if (media < 40.0) {
            System.out.println(" SITUAÇÃO: REPROVADO");
        } else {
            System.out.println(" SITUAÇÃO: NA FINAL");
        }

        System.out.println("=".repeat(40));
        scanner.close();
    }
}