package Aula04ListaDeEx;
import java.util.Scanner;

public class q02 {
    static class ContaBancaria {
        private String numeroConta;
        private String titular;
        private double saldo;

        public ContaBancaria(String numeroConta, String titular) {
            this.numeroConta = numeroConta;
            this.titular = titular;
            this.saldo = 0.0;
        }

        public void consultarSaldo() {
            System.out.printf("Saldo %s (%s): R$ %.2f%n", numeroConta, titular, saldo);
        }

        public boolean depositar(double valor) {
            if (valor > 0) {
                saldo += valor;
                System.out.printf("✅ Depósito R$ %.2f%n", valor);
                return true;
            }
            System.out.println(" Valor inválido!");
            return false;
        }

        public boolean sacar(double valor) {
            if (valor > 0 && valor <= saldo) {
                saldo -= valor;
                System.out.printf("✅ Saque R$ %.2f%n", valor);
                return true;
            }
            System.out.println(" Saldo insuficiente!");
            return false;
        }

        public boolean transferir(ContaBancaria destino, double valor) {
            if (valor > 0 && valor <= saldo) {
                saldo -= valor;
                destino.saldo += valor;
                System.out.printf("Transferido R$ %.2f para %s%n", valor, destino.numeroConta);
                return true;
            }
            System.out.println(" Saldo insuficiente!");
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Número da conta: ");
        String numConta = scanner.nextLine();
        System.out.print("Titular: ");
        String titular = scanner.nextLine();

        ContaBancaria conta = new ContaBancaria(numConta, titular);
        ContaBancaria destino = new ContaBancaria("99999", "Destino");

        int opcao;
        do {
            System.out.println("\n1-Consultar 2-Depositar 3-Sacar 4-Transferir 0-Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> conta.consultarSaldo();
                case 2 -> {
                    System.out.print("Valor: R$ ");
                    conta.depositar(scanner.nextDouble());
                }
                case 3 -> {
                    System.out.print("Valor: R$ ");
                    conta.sacar(scanner.nextDouble());
                }
                case 4 -> {
                    System.out.print("Valor: R$ ");
                    conta.transferir(destino, scanner.nextDouble());
                }
                case 0 -> System.out.println("Tchau!");
                default -> System.out.println("Inválido!");
            }
        } while (opcao != 0);

        scanner.close();
    }
}