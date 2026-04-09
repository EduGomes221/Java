package Aula04;
import java.util.Scanner;

public class q01 {
    static class Produto {
        private int codigo;
        private String nome;
        private String tamanhoPeso;
        private String cor;
        private double valor;
        private int quantidadeEstoque;

        public Produto(int codigo, String nome, String tamanhoPeso, String cor, double valor, int quantidadeEstoque) {
            this.codigo = codigo;
            this.nome = nome;
            this.tamanhoPeso = tamanhoPeso;
            this.cor = cor;
            this.valor = valor;
            this.quantidadeEstoque = quantidadeEstoque;
        }
        public int getCodigo() { return codigo; }
        public String getNome() { return nome; }
        public String getTamanhoPeso() { return tamanhoPeso; }
        public String getCor() { return cor; }
        public double getValor() { return valor; }
        public int getQuantidadeEstoque() { return quantidadeEstoque; }

        public void setQuantidadeEstoque(int qtd) { this.quantidadeEstoque = qtd; }

        public boolean vender(int qtd) {
            if (qtd > 0 && qtd <= quantidadeEstoque) {
                quantidadeEstoque -= qtd;
                return true;
            }
            return false;
        }

        public double calcularTotal(int qtd) {
            return valor * qtd;
        }

        public void exibir() {
            System.out.printf("[Cód:%-4d] %-20s | %-8s | %-10s | R$%7.2f | Est:%3d%n",
                    codigo, nome, tamanhoPeso, cor, valor, quantidadeEstoque);
        }
    }

    private static Produto[] estoque = new Produto[50];
    private static int totalProdutos = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        cabecalho();

        do {
            menu();
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> cadastrar(sc);
                case 2 -> listar();
                case 3 -> vender(sc);
                case 4 -> System.out.println("👋 Sistema encerrado!");
                default -> System.out.println("❌ Opção inválida!");
            }
        } while (opcao != 4);

        sc.close();
    }

    static void cabecalho() {
        System.out.println("=".repeat(60));
        System.out.println("🛒 SISTEMA CONTROLE PRODUTO & VENDAS");
        System.out.println("=".repeat(60));
    }

    static void menu() {
        System.out.println("\n📋 MENU:");
        System.out.println("1️⃣  Cadastrar Produto");
        System.out.println("2️⃣  Listar Estoque");
        System.out.println("3️⃣  Vender");
        System.out.println("4️⃣  Sair");
        System.out.print("➤ ");
    }

    static void cadastrar(Scanner sc) {
        if (totalProdutos >= 50) {
            System.out.println("❌ Estoque cheio!");
            return;
        }

        System.out.print("Código.....: ");
        int cod = sc.nextInt();

        sc.nextLine();
        System.out.print("Nome.......: ");
        String nome = sc.nextLine();

        System.out.print("Tamanho/Peso: ");
        String tam = sc.nextLine();

        System.out.print("Cor........: ");
        String cor = sc.nextLine();

        System.out.print("Valor (R$)..: ");
        double val = sc.nextDouble();

        System.out.print("Qtd Inicial.: ");
        int qtd = sc.nextInt();

        estoque[totalProdutos++] = new Produto(cod, nome, tam, cor, val, qtd);
        System.out.println("✅ Cadastrado!");
    }

    static void listar() {
        if (totalProdutos == 0) {
            System.out.println("📦 Estoque vazio!");
            return;
        }

        System.out.println("\n📦 ESTOQUE:");
        System.out.println("-".repeat(70));
        for (int i = 0; i < totalProdutos; i++) {
            estoque[i].exibir();
        }
        System.out.println("-".repeat(70));
    }

    static void vender(Scanner sc) {
        if (totalProdutos == 0) {
            System.out.println("❌ Sem produtos!");
            return;
        }

        System.out.print("Código: ");
        int cod = sc.nextInt();
        Produto p = buscar(cod);

        if (p == null) {
            System.out.println("❌ Produto não existe!");
            return;
        }

        System.out.print("Quantidade: ");
        int qtd = sc.nextInt();

        if (!p.vender(qtd)) {
            System.out.println("❌ Estoque insuficiente!");
            return;
        }

        double total = p.calcularTotal(qtd);
        pagamento(sc, p, qtd, total);
    }

    static Produto buscar(int cod) {
        for (int i = 0; i < totalProdutos; i++) {
            if (estoque[i].getCodigo() == cod) return estoque[i];
        }
        return null;
    }

    static void pagamento(Scanner sc, Produto p, int qtd, double total) {
        System.out.println("\n💰 VENDA:");
        System.out.printf("%s (Cód:%d) x%d = R$%.2f%n", p.getNome(), p.getCodigo(), qtd, total);

        System.out.println("\n💳 PAGAMENTO:");
        System.out.println("1 - Pix/Débito/Transferência (5% OFF)");
        System.out.println("2 - Espécie (5% OFF + troco)");
        System.out.println("3 - Crédito (3x sem juros)");
        System.out.print("Forma: ");

        int forma = sc.nextInt();
        sc.nextLine();

        double valorPagar = total;
        String info = "";

        switch (forma) {
            case 1 -> {
                valorPagar *= 0.95;
                info = "Pix/Débito/Transferência (5% OFF)";
            }
            case 2 -> {
                valorPagar *= 0.95;
                info = "Espécie (5% OFF)";
                System.out.printf("💵 Pagar: R$%.2f%n", valorPagar);
                System.out.print("Valor dado: R$");
                double pago = sc.nextDouble();
                if (pago < valorPagar) {
                    System.out.println("❌ Dinheiro insuficiente!");
                    p.setQuantidadeEstoque(p.getQuantidadeEstoque() + qtd);
                    return;
                }
                System.out.printf("🎉 TROCO: R$%.2f%n", pago - valorPagar);
            }
            case 3 -> {
                info = "Crédito 3x";
                System.out.printf("📱 3x R$%.2f = R$%.2f%n", valorPagar/3, valorPagar);
            }
            default -> {
                System.out.println("❌ Forma inválida!");
                return;
            }
        }

        System.out.println("\n✅ VENDA APROVADA!");
        System.out.printf("💳 %s | Total: R$%.2f%n", info, valorPagar);
        System.out.printf("📦 Novo estoque: %d und%n", p.getQuantidadeEstoque());
    }
}