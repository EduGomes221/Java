package Aula04ListaDeEx;
import java.util.Scanner;

public class q03 {
    static class Produto {
        private String nome;
        private double preco;
        private int quantidade;

        public Produto(String nome, double preco, int quantidade) {
            this.nome = nome;
            this.preco = preco;
            this.quantidade = quantidade;
        }

        public void exibirDetalhes() {
            System.out.printf("%s: R$%.2f x %d = R$%.2f%n",
                    nome, preco, quantidade, preco * quantidade);
        }

        public double calcularValorTotal() {
            return preco * quantidade;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Produto[] produtos = new Produto[100];
        int total = 0;
        int opcao;

        do {
            System.out.println("\n1-Cadastrar 2-Exibir 3-Total 0-Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> {
                    scanner.nextLine();
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Preço: R$ ");
                    double preco = scanner.nextDouble();
                    System.out.print("Qtd: ");
                    int qtd = scanner.nextInt();
                    produtos[total++] = new Produto(nome, preco, qtd);
                    System.out.println(" Cadastrado!");
                }
                case 2 -> {
                    if (total == 0) System.out.println("Vazio!");
                    else {
                        System.out.println("\nESTOQUE:");
                        for (int i = 0; i < total; i++) {
                            produtos[i].exibirDetalhes();
                        }
                    }
                }
                case 3 -> {
                    double totalValor = 0;
                    for (int i = 0; i < total; i++) {
                        totalValor += produtos[i].calcularValorTotal();
                    }
                    System.out.printf("Total estoque: R$ %.2f%n", totalValor);
                }
            }
        } while (opcao != 0);

        scanner.close();
    }
}