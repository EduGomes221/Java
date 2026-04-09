package Aula04ListaDeEx;
import java.util.Scanner;

public class q01 {
    static class Funcionario {
        private String matricula;
        private String nome;
        private double salarioBruto;
        private double deducaoINSS;
        private double salarioLiquido;

        public Funcionario(String matricula, String nome, double salarioBruto) {
            this.matricula = matricula;
            this.nome = nome;
            this.salarioBruto = salarioBruto;
        }

        public void calcularInss() {
            deducaoINSS = salarioBruto * 0.15;
        }

        public void calcularSalarioLiquido() {
            calcularInss();
            salarioLiquido = salarioBruto - deducaoINSS;
        }

        public void exibirContracheque() {
            calcularSalarioLiquido();
            System.out.println("\nMatrícula:     " + matricula);
            System.out.println("Nome completo: " + nome);
            System.out.printf("Salário Bruto: R$ %9.2f%n", salarioBruto);
            System.out.printf("Dedução INSS:  R$ %9.2f%n", deducaoINSS);
            System.out.printf("Salário Líquido:R$ %9.2f%n", salarioLiquido);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String opcao;

        do {
            System.out.print("Matrícula: ");
            String matricula = scanner.nextLine();
            System.out.print("Nome completo: ");
            String nome = scanner.nextLine();
            System.out.print("Salário Bruto: R$ ");
            double salarioBruto = scanner.nextDouble();
            scanner.nextLine();

            Funcionario funcionario = new Funcionario(matricula, nome, salarioBruto);
            funcionario.exibirContracheque();

            System.out.print("\nNovo funcionário? (S/N): ");
            opcao = scanner.nextLine();
        } while (opcao.equalsIgnoreCase("S"));

        scanner.close();
    }
}