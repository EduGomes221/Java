package Aula02;
import java.util.Scanner;


public class q02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String continuar;

        System.out.println("=".repeat(60));
        System.out.println("FOLHA DE PAGAMENTO - INDÚSTRIA");
        System.out.println("=".repeat(60));

        do {
            System.out.print("Matrícula: ");
            String matricula = scanner.nextLine();

            System.out.print("Nome completo: ");
            String nome = scanner.nextLine();

            System.out.print("Salário Bruto (R$): ");
            double salarioBruto = scanner.nextDouble();
            scanner.nextLine();

            double deducaoINSS = salarioBruto * 0.15;
            double salarioLiquido = salarioBruto - deducaoINSS;

            System.out.println("\n" + "-".repeat(60));
            System.out.println("CONTRACHEQUE");
            System.out.println("-".repeat(60));
            System.out.println("Matrícula:     " + matricula);
            System.out.println("Nome completo: " + nome);
            System.out.printf("Salário Bruto: R$ %10.2f%n", salarioBruto);
            System.out.printf("Dedução INSS:  R$ %10.2f%n", deducaoINSS);
            System.out.printf("Salário Líquido:R$ %10.2f%n", salarioLiquido);
            System.out.println("-".repeat(60));

            do {
                System.out.print("\nProcessar outro funcionário? (S/N): ");
                continuar = scanner.nextLine().trim();
            } while (!continuar.equalsIgnoreCase("S") &&
                    !continuar.equalsIgnoreCase("N"));

            System.out.println();

        } while (continuar.equalsIgnoreCase("S"));

        System.out.println("=".repeat(60));
        System.out.println("FECHAMENTO DA FOLHA DE PAGAMENTO");
        System.out.println("=".repeat(60));

        scanner.close();
    }
}