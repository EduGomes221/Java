package Aula01;
import java.util.Scanner;

public class q04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o salário (R$): ");
        double salario = scanner.nextDouble();

        System.out.println("\n" + "=".repeat(50));
        System.out.println("FOLHA DE PAGAMENTO");
        System.out.println("=".repeat(50));
        System.out.printf("Salário Bruto: R$ %.2f%n", salario);
        System.out.println("-".repeat(50));

        String descontoIR;
        double valorDescontoIR = 0.0;

        if (salario <= 900.00) {
            descontoIR = "ISENTO";
        } else if (salario <= 1500.00) {
            descontoIR = "DESCONTO DE 5%";
            valorDescontoIR = salario * 0.05;
        } else if (salario <= 2500.00) {
            descontoIR = "DESCONTO DE 10%";
            valorDescontoIR = salario * 0.10;
        } else {
            descontoIR = "DESCONTO DE 20%";
            valorDescontoIR = salario * 0.20;
        }

        System.out.println("IR: " + descontoIR);
        if (valorDescontoIR > 0) {
            System.out.printf("Valor IR: R$ %.2f%n", valorDescontoIR);
        }
        System.out.println("-".repeat(50));

        double salarioLiquido = salario - valorDescontoIR;
        System.out.printf("Salário Líquido: R$ %.2f%n", salarioLiquido);

        System.out.println("=".repeat(50));
        scanner.close();
    }
}