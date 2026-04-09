package Aula03;
import java.util.Scanner;

public class q03{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int operacao;

        System.out.println("=== CALCULADORA ===");
        System.out.println("1 - Soma");
        System.out.println("2 - Subtração");
        System.out.println("3 - Multiplicação");
        System.out.println("4 - Divisão");
        System.out.println("0 - Sair\n");

        do {
            System.out.print("Escolha a operação (0-4): ");
            operacao = scanner.nextInt();

            if (operacao == 0) {
                System.out.println("Calculadora encerrada! ");
                break;
            }

            if (operacao >= 1 && operacao <= 4) {
                System.out.print("Digite o primeiro número: ");
                double num1 = scanner.nextDouble();

                System.out.print("Digite o segundo número: ");
                double num2 = scanner.nextDouble();

                double resultado = 0;
                String operacaoNome = "";

                switch (operacao) {
                    case 1:
                        resultado = num1 + num2;
                        operacaoNome = "SOMA";
                        break;
                    case 2:
                        resultado = num1 - num2;
                        operacaoNome = "SUBTRAÇÃO";
                        break;
                    case 3:
                        resultado = num1 * num2;
                        operacaoNome = "MULTIPLICAÇÃO";
                        break;
                    case 4:
                        if (num2 != 0) {
                            resultado = num1 / num2;
                            operacaoNome = "DIVISÃO";
                        } else {
                            System.out.println(" ERRO: Divisão por zero!");
                            continue;
                        }
                        break;
                }

                System.out.printf("%s: %.2f %s %.2f = %.2f%n%n",
                        operacaoNome, num1,
                        getSimbolo(operacao), num2, resultado);
            } else {
                System.out.println(" Opção inválida! Escolha 0-4.\n");
            }

        } while (true);

        scanner.close();
    }

    public static String getSimbolo(int op) {
        switch (op) {
            case 1: return "+";
            case 2: return "-";
            case 3: return "×";
            case 4: return "÷";
            default: return "";
        }
    }
}