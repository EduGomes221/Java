package Aula03;
import java.util.Scanner;

public class q01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();

        System.out.print("Nome completo: ");
        String nome = scanner.nextLine();

        System.out.print("Salário Bruto: ");
        double salarioBruto = scanner.nextDouble();

        double deducaoINSS = salarioBruto * 0.15;
        double salarioLiquido = salarioBruto - deducaoINSS;

        System.out.println("\nMatrícula:     " + matricula);
        System.out.println("Nome completo: " + nome);
        System.out.printf("Salário Bruto: R$ %8.2f%n", salarioBruto);
        System.out.printf("Dedução INSS:  R$ %8.2f%n", deducaoINSS);
        System.out.printf("Salário Líquido:R$ %8.2f%n", salarioLiquido);

        scanner.close();
    }
}